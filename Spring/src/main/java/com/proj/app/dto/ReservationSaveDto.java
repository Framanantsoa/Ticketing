package com.proj.app.dto;

import jakarta.validation.constraints.*;

public class ReservationSaveDto 
{
    @NotNull(message = "Nom obligatoire")
    private String nomComplet;

    @NotNull(message = "CIN obligatoire")
    @Size(min=12, max=12, message = "Le CIN doit contenir exactement 12 caractères")
    private String cin;

    @NotNull(message = "Télephone obligatoire")
    @Pattern(
        regexp = "^(032|033|034|037|038)\\d{7}$",
        message = "Le téléphone doit être une opérateur Malagasy"
    )
    private String telephone;

    @NotNull(message = "Nombre de siège obligatoire")
    @Min(value = 0, message = "Le nombre de sièges ne peut pas être négatif")
    private Integer sieges;

    @NotNull(message = "Nombre d'enfant obligatoire")
    @Min(value = 0, message = "Le nombre d'enfants ne peut pas être négatif")
    private Integer enfants;

    @NotNull(message = "Nombre de siège obligatoire")
    @Min(value = 0, message = "Le nombre de sièges économique ne peut pas être négatif")
    private Integer siegeEconomique;

    @NotNull(message = "Nombre de siège obligatoire")
    @Min(value = 0, message = "Le nombre de sièges business ne peut pas être négatif")
    private Integer siegeBusiness;

    @NotNull(message = "Vol obligatoire")
    @Min(value = 0, message = "L'id du vol ne peut pas être négatif")
    private Integer idVol; 


    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSieges() {
        return sieges;
    }
    public void setSieges(Integer sieges) {
        this.sieges = sieges;
    }

    public Integer getEnfants() {
        return enfants;
    }
    public void setEnfants(Integer enfants) {
        this.enfants = enfants;
    }

    public Integer getSiegeBusiness() {
        return siegeBusiness;
    }
    public void setSiegeBusiness(Integer siegeBusiness) {
        this.siegeBusiness = siegeBusiness;
    }

    public Integer getSiegeEconomique() {
        return siegeEconomique;
    }
    public void setSiegeEconomique(Integer siegeEconomique) {
        this.siegeEconomique = siegeEconomique;
    }

    public Integer getIdVol() {
        return idVol;
    }
    public void setIdidVol(Integer idVol) {
        this.idVol = idVol;
    }
}
