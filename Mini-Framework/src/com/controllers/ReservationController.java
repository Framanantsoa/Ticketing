package com.controllers;

import java.util.List;
import com.dto.ReservationSaveDto;
import com.dto.ReservationViewDto;
import com.exceptions.ValidationException;
import com.models.Vol;
import com.services.ReservationService;
import com.services.VolService;
import ituprom16.annotations.*;
import ituprom16.models.ModelView;

@AnnotationController
public class ReservationController 
{
    private ReservationService service = new ReservationService();
    private VolService volService = new VolService();

    @Get("/reservations/liste")
    public ModelView listeReservations() {
        ModelView mv = null;
        try {
            mv = new ModelView("/views/reservations/liste.jsp");
            List<ReservationViewDto> reservations=service.getAllReservationValidated();
            mv.addObject("reservations", reservations);
        } 
        catch (Exception e) {
            mv = new ModelView("/views/erreurs/err500.jsp");
            mv.addObject("message", e.getMessage());
        }

        return mv;
    }


    @Get("/reservations/saisie")
    public ModelView saisieReservation() {
        ModelView mv = null;
        try {
            mv = new ModelView("/views/reservations/saisie.jsp");
            List<Vol> vols = volService.getAllVols();
            mv.addObject("vols", vols);
        } 
        catch (Exception e) {
            mv = new ModelView("/views/erreurs/err500.jsp");
            mv.addObject("message", e.getMessage());
        }
        return mv;
    }

    
    @Post("/reservations/soumission")
    public ModelView soumettreReservation(@RequestBody ReservationSaveDto res) {
        ModelView mv;
        try {
            service.insererReservation(res);
            mv = new ModelView("/views/reservations/liste.jsp");

            List<ReservationViewDto> reservations=service.getAllReservationValidated();
            mv.addObject("reservations", reservations);
        } 
        catch (ValidationException ve) {
            mv = new ModelView("/views/reservations/saisie.jsp");
            mv.addObject("validationErrors", ve);

            List<Vol> vols = volService.getAllVols();
            mv.addObject("vols", vols);
        } 
        catch (Exception e) {
            mv = new ModelView("/views/erreurs/err500.jsp");
            mv.addObject("message", e.getMessage());
        }

        return mv;
    }

}
