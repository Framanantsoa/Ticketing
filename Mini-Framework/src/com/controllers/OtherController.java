package com.controllers;

import java.util.List;
import com.dto.TrajetViewDto;
import com.models.Avion;
import com.services.OtherService;
import ituprom16.annotations.AnnotationController;
import ituprom16.annotations.Get;
import ituprom16.models.ModelView;

@AnnotationController
public class OtherController 
{
    private OtherService service = new OtherService();

    @Get("/avions")
    public ModelView listeAvions() {
        ModelView mv = null;
        try {
            List<Avion> avions = service.getAllAvions();
            mv = new ModelView("/views/autres/liste-avions.jsp");
            mv.addObject("avions", avions);
        } 
        catch (Exception e) {
            mv = new ModelView("/views/erreurs/err500.jsp");
            mv.addObject("message", e.getMessage());
        }

        return mv;
    }


    @Get("/trajets")
    public ModelView listeTrajets() {
        ModelView mv = null;
        try {
            List<TrajetViewDto> trajets = service.getAllTrajects();
            mv = new ModelView("/views/autres/liste-trajets.jsp");
            mv.addObject("trajets", trajets);
        } 
        catch (Exception e) {
            mv = new ModelView("/views/erreurs/err500.jsp");
            mv.addObject("message", e.getMessage());
        }

        return mv;
    }


}
