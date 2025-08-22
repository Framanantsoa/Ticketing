package com.controllers;

import com.services.UtilisateurService;
import ituprom16.annotations.*;
import ituprom16.models.ModelView;

@AnnotationController
public class UserController 
{
    private UtilisateurService service = new UtilisateurService();

    // @Get("/")
    // public ModelView login() {
    //     return new ModelView("/views/login.jsp");
    // }


    @Get("/")
    public ModelView accueil() {
        return new ModelView("/views/autres/accueil.jsp");
    }


    @Post("/login")
    @FormUrl("/views/login.jsp")
    public ModelView loginUser(
        @Param("email") String email, @Param("pwd") String pwd
    ) {
        ModelView mv = null;
        try {
            this.service.loginUser(email, pwd);
            mv = this.accueil();
        } 
        catch (Exception e) {
            mv = new ModelView("/views/erreurs/err400.jsp");
            mv.addObject("message", e.getMessage());
        }

        return mv;
    }

}
