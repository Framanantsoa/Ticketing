package com.proj.app.dto;

import jakarta.validation.constraints.NotNull;

public class UserLoginDto 
{
    @NotNull(message = "Email requise")
    private String email;

    @NotNull(message = "Mot de passe requis")
    private String motDePasse;


    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
        return this.motDePasse;
    }
}
