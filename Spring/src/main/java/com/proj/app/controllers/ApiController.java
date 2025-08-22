package com.proj.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proj.app.dto.ReservationSaveDto;
import com.proj.app.dto.ReservationViewDto;
import com.proj.app.dto.UserLoginDto;
import com.proj.app.dto.VolSaveDto;
import com.proj.app.entities.Utilisateur;
import com.proj.app.entities.Vol;
import com.proj.app.services.ReservationService;
import com.proj.app.services.UtilisateurService;
import com.proj.app.services.VolService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(
    origins = {"http://localhost:8080"},
    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class ApiController 
{
    @Autowired
    private VolService service;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UtilisateurService uService;


// VOLS
    @GetMapping("/vols")
    public List<Vol> getAllFlights() throws Exception {
        return service.getAllFlights();
    }

    @GetMapping("/vols/{id}")
    public Vol getFlightById(@PathVariable Long id) throws Exception {
        return service.getFlightById(id);
    }

    @PostMapping("/vols")
    public Vol createFlight(@Valid @RequestBody VolSaveDto vol) throws Exception {
        return service.insertNewFlight(vol);
    }

    @PutMapping("/vols/{id}")
    public Vol updateFlight(@PathVariable Long id,
     @Valid @RequestBody VolSaveDto vol) throws Exception {
        return service.updateFlight(id, vol);
    }

    @DeleteMapping("/vols/{id}")
    public void deleteFlight(@PathVariable Long id) throws Exception {
        service.deleteFlight(id);
    }

// Réservation
    // ✅ Créer une réservation
    @PostMapping("/reservations")
    public ReservationViewDto createReservation(@Valid @RequestBody ReservationSaveDto dto) {
        return reservationService.save(dto);
    }

    // ✅ Lister toutes les réservations
    @GetMapping("/reservations")
    public List<ReservationViewDto> getAllReservations() {
        return reservationService.findAll();
    }

    // ✅ Récupérer une réservation par ID
    @GetMapping("/reservations/{id}")
    public ReservationViewDto getReservationById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    // ✅ Supprimer une réservation
    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
    }

// Utilisateur
    @PostMapping("/clients/login")
    public Map<String, Object> loginSimpleUser(@RequestBody UserLoginDto dto) {
        Map<String, Object> result = new HashMap<>();
        Utilisateur user = this.uService.logSimpleUser(
            dto.getEmail(), dto.getMotDePasse()
        );
        if (user != null) {
            result.put("success", true);
            result.put("idUtilisateur", user.getIdUtilisateur());
        } else {
            result.put("success", false);
        }
        return result;
    }
}
