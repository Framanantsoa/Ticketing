package com.dto;

public class ReservationSaveDto 
{
    private String nomComplet;
    private String cin;
    private String telephone;
    private Integer nombrePlace;
    private Integer nombreEnfant;
    private Integer placeBusiness;
    private Integer placeEconomique;
    private Integer idVol;
    private Long idUtilisateur;

    
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Integer getNombrePlace() {
        return nombrePlace;
    }
    public void setNombrePlace(Integer nombrePlace) {
        this.nombrePlace = nombrePlace;
    }
    public Integer getNombreEnfant() {
        return nombreEnfant;
    }
    public void setNombreEnfant(Integer nombreEnfant) {
        this.nombreEnfant = nombreEnfant;
    }
    public Integer getPlaceBusiness() {
        return placeBusiness;
    }
    public void setPlaceBusiness(Integer placeBusiness) {
        this.placeBusiness = placeBusiness;
    }
    public Integer getPlaceEconomique() {
        return placeEconomique;
    }
    public void setPlaceEconomique(Integer placeEconomique) {
        this.placeEconomique = placeEconomique;
    }
    public void setIdVol(Integer idVol) {
        this.idVol = idVol;
    }
    public Integer getIdVol() {
        return idVol;
    }
    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }
}
