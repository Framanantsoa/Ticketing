package com.proj.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.proj.app.dto.VolSaveDto;
import com.proj.app.entities.Avion;
import com.proj.app.entities.Trajet;
import com.proj.app.entities.Vol;
import com.proj.app.repositories.AvionRepo;
import com.proj.app.repositories.TrajetRepo;
import com.proj.app.repositories.VolRepo;

import jakarta.validation.ValidationException;

@Service
public class VolService 
{
    @Autowired
    private VolRepo volRepo;

    @Autowired
    private TrajetRepo trajetRepository;

    @Autowired
    private AvionRepo avionRepository;


    public Vol fromDto(VolSaveDto dto) {
        Vol vol = new Vol();
        vol.setDateDepart(dto.getDateDepart());
        vol.setDateArrivee(dto.getDateArrivee());

        // Récupérer les entités liées par leurs IDs
        Trajet trajet = trajetRepository.findById(dto.getIdTrajet())
            .orElseThrow(() -> new RuntimeException("Trajet introuvable"));
        vol.setTrajet(trajet);

        Avion avion = avionRepository.findById(dto.getIdAvion())
            .orElseThrow(() -> new RuntimeException("Avion introuvable"));
        vol.setAvion(avion);

        vol.setIsDeleted(false); // valeur par défaut
        return vol;
    }

    public List<Vol> getAllFlights() throws Exception {
        return this.volRepo.findAllFlights();
    }


    public Vol getFlightById(Long id) throws Exception {
        return this.volRepo.findFlightById(id);
    }


    public Vol insertNewFlight(VolSaveDto dto) throws Exception {
        List<String> errors = new ArrayList<>();
    
        // Vérifications
        if (!trajetRepository.existsById(dto.getIdTrajet())) {
            errors.add("Trajet introuvable avec id = " + dto.getIdTrajet());
        }
        if (!avionRepository.existsById(dto.getIdAvion())) {
            errors.add("Avion introuvable avec id = " + dto.getIdAvion());
        }
    
        // Si erreurs → concatène et lève exception
        if (!errors.isEmpty()) {
            throw new ValidationException(String.join(", ", errors));
        }
    
        // Récupération des entités
        Trajet trajet = trajetRepository.findById(dto.getIdTrajet())
                .orElseThrow(() -> new ValidationException("Trajet introuvable !"));
        Avion avion = avionRepository.findById(dto.getIdAvion())
                .orElseThrow(() -> new ValidationException("Avion introuvable !"));
    
        // Création du vol
        Vol vol = new Vol();
        vol.setDateDepart(dto.getDateDepart());
        vol.setDateArrivee(dto.getDateArrivee());
        vol.setTrajet(trajet);
        vol.setAvion(avion);
    
        return volRepo.save(vol);
    }    


    public Vol updateFlight(Long id, VolSaveDto dto) throws Exception {
        List<String> errors = new ArrayList<>();
    
        // Vérifications
        if (!trajetRepository.existsById(dto.getIdTrajet())) {
            errors.add("Trajet introuvable avec id = " + dto.getIdTrajet());
        }
        if (!avionRepository.existsById(dto.getIdAvion())) {
            errors.add("Avion introuvable avec id = " + dto.getIdAvion());
        }
        if (!volRepo.existsById(id)) {
            errors.add("Vol introuvable avec id = "+id);
        }
    
        // Si erreurs → concatène et lève exception
        if (!errors.isEmpty()) {
            throw new ValidationException(String.join(", ", errors));
        }

        Vol existant = this.volRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Vol introuvable"));

        Vol nouveau = this.fromDto(dto);

        existant.setDateDepart(nouveau.getDateDepart());
        existant.setDateArrivee(nouveau.getDateArrivee());
        existant.setTrajet(nouveau.getTrajet());
        existant.setAvion(nouveau.getAvion());

        return this.volRepo.save(existant);
    }


    public void deleteFlight(Long id) throws Exception {
        Vol vol = this.volRepo.findById(id)
            .orElseThrow(() -> new Exception("Vol introuvable avec l'id " + id));

        vol.setIsDeleted(true); 
        this.volRepo.save(vol);
    }
}
