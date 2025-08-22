package com.proj.app.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.app.dto.ReservationViewDto;
import com.proj.app.services.ReservationService;
import com.proj.app.services.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/reservations")
public class ReservationController 
{
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UtilisateurService uService;


    @GetMapping("/liste")
    public String listeReservation(HttpServletRequest request, Model model,
     @RequestParam(required = false) String statut) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }
        try {
            List<ReservationViewDto> reservations;

            if (statut != null && !statut.isEmpty()) {
                reservations = reservationService.findByStatut(statut);
            } else {
                reservations = reservationService.findAll();
            }

            model.addAttribute("reservations", reservations);
            model.addAttribute("statut", statut);
            return "reservations/list";
        } 
        catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }


    @GetMapping("{id}/accepter")
    public String accepterReservation(HttpServletRequest request,
     @PathVariable("id") Long id, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }
        try {
            this.reservationService.accepter(id);
            return "redirect:/reservations/liste";
        } 
        catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }

    @GetMapping("{id}/refuser")
    public String refuserReservation(HttpServletRequest request,
     @PathVariable("id") Long id, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }
        try {
            this.reservationService.refuser(id);
            return "redirect:/reservations/liste";
        } 
        catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }

    @GetMapping("{id}/annuler")
    public String annulerReservation(HttpServletRequest request,
     @PathVariable("id") Long id, Model model) {
        String token = uService.getToken(request);
        // Si pas de token ou invalide → login
        if (token==null || uService.verifyToken(token)==null) {
            return "redirect:/login";
        }
        try {
            this.reservationService.annuler(id);
            return "redirect:/reservations/liste";
        } 
        catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "errors/500";
        }
    }

    @GetMapping("{id}/imprimer")
    public void imprimerReservation(HttpServletRequest request,
     HttpServletResponse response, @PathVariable("id") Long id) {
        String token = uService.getToken(request);
        if (token == null || uService.verifyToken(token) == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition",
             "inline; filename=billet_" + id + ".pdf");

            reservationService.imprimer(id, response.getOutputStream());
            response.flushBuffer();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                 "Erreur lors de l'impression : " + e.getMessage());
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
