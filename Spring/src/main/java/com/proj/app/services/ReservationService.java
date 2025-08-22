package com.proj.app.services;

import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.proj.app.dto.ReservationSaveDto;
import com.proj.app.dto.ReservationViewDto;
import com.proj.app.entities.*;
import com.proj.app.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lowagie.text.*;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService 
{
    @Autowired
    private ReservationRepo reservationRepository;

    @Autowired
    private StatutRepo statutRepository;

    @Autowired
    private VolRepo volRepository;

    @Autowired
    private UtilisateurRepo utilisateurRepository;

    // ✅ Création d'une réservation
    public ReservationViewDto save(ReservationSaveDto dto) {
        Reservation reservation = new Reservation();

        reservation.setNomComplet(dto.getNomComplet()); 
        reservation.setCin(dto.getCin());
        reservation.setTelephone(dto.getTelephone());
        reservation.setNombrePlace(dto.getSieges());
        reservation.setNombreEnfant(dto.getEnfants());
        reservation.setPlaceBusiness(dto.getSiegeBusiness());  
        reservation.setPlaceEconomique(dto.getSiegeEconomique());

        // Relations
        Statut statut = statutRepository.findById(1L) // par défaut "EN_ATTENTE"
                .orElseThrow(() -> new RuntimeException("Statut non trouvé"));
        reservation.setStatut(statut);

        Vol vol = volRepository.findById(dto.getIdVol().longValue())
                .orElseThrow(() -> new RuntimeException("Vol non trouvé"));
        reservation.setVol(vol);

        Utilisateur utilisateur = utilisateurRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        reservation.setUtilisateur(utilisateur);

        Reservation saved = reservationRepository.save(reservation);

        return mapToViewDto(saved);
    }

    // ✅ Lire toutes les réservations
    public List<ReservationViewDto> findAll() {
        return reservationRepository.findAllByOrderByIdReservationDesc()
                .stream()
                .map(this::mapToViewDto)
                .collect(Collectors.toList());
    }

    public List<ReservationViewDto> findByStatut(String statut) {
        return reservationRepository.findByNomStatut(statut)
                .stream()
                .map(this::mapToViewDto)
                .collect(Collectors.toList());
    }    

    // ✅ Lire une réservation par ID
    public ReservationViewDto findById(Long id) {
        return reservationRepository.findById(id)
                .map(this::mapToViewDto)
                .orElse(null);
    }

    // ✅ Supprimer
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    // ✅ Conversion Reservation → DTO
    private ReservationViewDto mapToViewDto(Reservation reservation) {
        String depart = reservation.getVol().getTrajet().getDepart().getNomVille();
        String arrivee = reservation.getVol().getTrajet().getArrivee().getNomVille();
        String dateDepart = reservation.getVol().getDateDepart()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd à HH:mm"));

        ReservationViewDto dto = new ReservationViewDto();
        dto.setIdReservation(reservation.getIdReservation());
        dto.setCin(reservation.getCin());
        dto.setTelephone(reservation.getTelephone());
        dto.setSieges(reservation.getNombrePlace());
        dto.setEnfants(reservation.getNombreEnfant());
        dto.setStatut(reservation.getStatut().getNomStatut());
        dto.setTrajet(depart+" -- "+arrivee+" # "+dateDepart);
        return dto;
    }


    public void accepter(Long id) {
        Reservation reservation = reservationRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        
        Statut statut = new Statut();
        statut.setIdStatut(2L);
        reservation.setStatut(statut);

        this.reservationRepository.save(reservation);
    }

    public void refuser(Long id) {
        Reservation reservation = reservationRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        
        Statut statut = new Statut();
        statut.setIdStatut(4L);
        reservation.setStatut(statut);

        this.reservationRepository.save(reservation);
    }

    public void annuler(Long id) {
        Reservation reservation = reservationRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        
        Statut statut = new Statut();
        statut.setIdStatut(3L);
        reservation.setStatut(statut);

        this.reservationRepository.save(reservation);
    }

    public void imprimer(Long id, OutputStream out) {
        Optional<Reservation> optReservation = reservationRepository.findById(id);
        if (optReservation.isEmpty()) {
            throw new RuntimeException("Réservation introuvable");
        }
        Reservation r = optReservation.get();

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, out);

            document.open();

            // Titre
            Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Billet d'Avion", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" ")); // saut de ligne

            // Infos passager
            document.add(new Paragraph("Nom Complet : "+r.getNomComplet()));
            document.add(new Paragraph("CIN : "+r.getCin()));
            document.add(new Paragraph("Téléphone : "+r.getTelephone()));
            document.add(new Paragraph("Nombre de places : "+r.getNombrePlace()));
            document.add(new Paragraph("Nombre d'enfants : "+r.getNombreEnfant()));
            document.add(new Paragraph("Place Business : "+r.getPlaceBusiness()));
            document.add(new Paragraph("Place Économique : "+r.getPlaceEconomique()));

            document.add(new Paragraph(" "));

            // Encadré type billet
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.addCell("Numéro de réservation");
            table.addCell(String.valueOf(r.getIdReservation()));
            table.addCell("Vol");
            table.addCell(r.getVol().getTrajet().getDepart().getNomVille()+" vers "+
                        r.getVol().getTrajet().getArrivee().getNomVille());
            table.addCell("Date de départ");
            table.addCell(r.getVol().getDateDepart()
             .format(DateTimeFormatter.ofPattern("yyyy-MM-dd à HH:mm")));
            document.add(table);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur génération PDF : " + e.getMessage());
        }
    }

}
