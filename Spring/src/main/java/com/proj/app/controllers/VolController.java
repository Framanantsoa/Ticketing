package com.proj.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proj.app.dto.VolSaveDto;
import com.proj.app.entities.*;
import com.proj.app.repositories.AvionRepo;
import com.proj.app.repositories.TrajetRepo;
import com.proj.app.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/vols")
public class VolController 
{
    @Autowired
    private VolService volService;

    @Autowired
    private TrajetRepo trajetRepo;

    @Autowired
    private AvionRepo avionRepo;

    @Autowired
    private UtilisateurService uService;


    @GetMapping("/creation")
    public String creationVol(HttpServletRequest request, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }

        List<Trajet> trajets=null; List<Avion> avions=null;
        try {
            trajets = this.trajetRepo.findAll();
            model.addAttribute("trajets", trajets);

            avions = this.avionRepo.findAll();
            model.addAttribute("avions", avions);
            return "vols/save";
        } 
        catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }

    @PostMapping("/creation")
    public String creerVol(HttpServletRequest request, @Valid @ModelAttribute VolSaveDto dto,
     Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }

        try {
            volService.insertNewFlight(dto);
            return "redirect:/vols/liste";
        } 
        catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/400";
        }
    }


    @GetMapping("/liste")
    public String listeVol(HttpServletRequest request, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }

        try {
            List<Vol> vols=this.volService.getAllFlights();
            model.addAttribute("vols", vols);
            return "vols/list";
        } 
        catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }


    @GetMapping("/{id}/suppression")
    public String supprimer(HttpServletRequest request, @PathVariable Long id, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }

        try {
            this.volService.deleteFlight(id);
            return "redirect:/vols/liste";
        } 
        catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }

    
    @GetMapping("/{id}/edition")
    public String editVol(HttpServletRequest request, @PathVariable Long id, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }

        try {
            Vol vol = volService.getFlightById(id); // Récupère le vol
            List<Trajet> trajets = trajetRepo.findAll();
            List<Avion> avions = avionRepo.findAll();

            model.addAttribute("vol", vol);
            model.addAttribute("trajets", trajets);
            model.addAttribute("avions", avions);

            return "vols/save"; // Réutilise le formulaire
        } 
        catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }

    @PostMapping("/{id}/edition")
    public String updateVol(HttpServletRequest request, 
     @PathVariable Long id, @ModelAttribute VolSaveDto dto, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }

        try {
            volService.updateFlight(id, dto);
            return "redirect:/vols/liste";
        } 
        catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/400";
        }
    }

}
