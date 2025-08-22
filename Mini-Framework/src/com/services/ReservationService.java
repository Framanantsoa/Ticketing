package com.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.dto.ReservationSaveDto;
import com.dto.ReservationViewDto;
import com.exceptions.ValidationException;
import com.models.Reservation;
import com.models.Statut;
import com.models.Utilisateur;
import com.models.Vol;
import com.repositories.ReservationRepo;

public class ReservationService extends Service
{
    private EntityManagerFactory emf = this.getEntityManagerFact();


    public List<ReservationViewDto> getAllReservationValidated() throws Exception {
        EntityManager em = emf.createEntityManager();
        ReservationRepo repo = new ReservationRepo(em);

        List<ReservationViewDto> reservations = repo.getAllReservations();
        em.close();

        return reservations;
    }


    public void insererReservation(ReservationSaveDto dto) throws ValidationException {
        VolService volService = new VolService();
        ValidationException validationErrors = new ValidationException();
    
    // Validation des données nom remplies
        if (dto.getNomComplet() == null || dto.getNomComplet().trim().isEmpty()) {
            validationErrors.addError("nomComplet", "Le nom est obligatoire");
        }
        if (dto.getCin() == null || dto.getCin().trim().isEmpty()) {
            validationErrors.addError("cin", "Le CIN est obligatoire");
        }
        if (dto.getTelephone() == null || dto.getTelephone().trim().isEmpty()) {
            validationErrors.addError("telephone", "Le téléphone est obligatoire");
        }
        if (dto.getNombrePlace() == null || dto.getNombrePlace() < 1) {
            validationErrors.addError("nombrePlace", "Le nombre de places doit être au moins 1");
        }
        if (dto.getNombreEnfant() == null || dto.getNombreEnfant() < 0) {
            validationErrors.addError("nombreEnfant", "Le nombre d'enfants ne peut pas être négatif ou nul");
        }
        if (dto.getPlaceBusiness() == null || dto.getPlaceBusiness() < 0) {
            validationErrors.addError("placeBusiness", "Le nombre de places business ne peut pas être négatif ou nul");
        }
        if (dto.getPlaceEconomique() == null || dto.getPlaceEconomique() < 0) {
            validationErrors.addError("placeEconomique", "Le nombre de places économiques ne peut pas être négatif ou nul");
        }
        if (dto.getIdVol() == null || dto.getIdVol() <= 0) {
            validationErrors.addError("idVol", "Le vol est obligatoire");
            throw validationErrors;
        }

    // Cohérence nombre de sièges
        if (dto.getNombrePlace() != (dto.getPlaceEconomique() + dto.getPlaceBusiness())) {
            validationErrors.addError("nombrePlace", "Nombre de place incohérent avec économique + business");
        }
        if (dto.getNombreEnfant() >= dto.getNombrePlace()) {
            validationErrors.addError("nombreEnfant", "Le nombre des enfants doit être inférieur aux places totales");
        }

    // Disponibilité avion
        int siegeEcoDispo = volService.getPlacesEcoDispo(dto.getIdVol().longValue());
        int siegeBusDispo = volService.getPlacesBusDispo(dto.getIdVol().longValue());

        if (siegeEcoDispo < dto.getPlaceEconomique()) {
            validationErrors.addError("placeEconomique", "Sièges économiques insuffisants (" + siegeEcoDispo + " disponibles)");
        }
        if (siegeBusDispo < dto.getPlaceBusiness()) {
            validationErrors.addError("placeBusiness", "Sièges business insuffisants (" + siegeBusDispo + " disponibles)");
        }

    // Fin des validations et insertion
        if (validationErrors.hasErrors()) throw validationErrors;

        this.finirInsertion(dto);
    }
    

    public void finirInsertion(ReservationSaveDto dto) {
        EntityManager em = emf.createEntityManager();

        Reservation reservation = new Reservation();
        reservation.setNomComplet(dto.getNomComplet());
        reservation.setCin(dto.getCin());
        reservation.setTelephone(dto.getTelephone());
        reservation.setNombrePlace(dto.getNombrePlace());
        reservation.setNombreEnfant(dto.getNombreEnfant());
        reservation.setPlaceBusiness(dto.getPlaceBusiness());
        reservation.setPlaceEconomique(dto.getPlaceEconomique());

    // relations
        Vol vol = em.find(Vol.class, dto.getIdVol().longValue());  
        reservation.setVol(vol);

        Statut statut = em.find(Statut.class, 1L); // Statut "en attente"
        reservation.setStatut(statut);

        Utilisateur user = em.find(Utilisateur.class, dto.getIdUtilisateur()); 
        reservation.setUtilisateur(user);

    // persistance
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();

        em.close();
    }
}
