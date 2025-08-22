package com.proj.app.dto;

public class ReservationViewDto 
{
    private Long idReservation;
    private String cin;
    private String telephone;
    private Integer sieges;
    private Integer enfants;
    private String statut; 
    private String trajet; 


    public Long getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
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

    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTrajet() {
        return trajet;
    }
    public void setTrajet(String trajet) {
        this.trajet = trajet;
    }
}
