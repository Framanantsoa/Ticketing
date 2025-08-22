package com.dto;

public class TrajetViewDto 
{
    private Long idTrajet;
    private String villeDepart;
    private String paysDepart;
    private String villeArrivee;
    private String paysArrivee;
    private Double fraisEconomique;
    private Double fraisBusiness;
    private Double fraisEnfant;

    public TrajetViewDto(Long idTrajet, String villeDepart, String paysDepart,
     String villeArrivee, String paysArrivee,
     Double fraisEconomique, Double fraisEnfant, Double fraisBusiness) {
        this.idTrajet = idTrajet;
        this.villeDepart = villeDepart;
        this.paysDepart = paysDepart;
        this.villeArrivee = villeArrivee;
        this.paysArrivee = paysArrivee;
        this.fraisEconomique = fraisEconomique;
        this.fraisEnfant = fraisEnfant;
        this.fraisBusiness = fraisBusiness;
    }

    public Long getIdTrajet() {
        return idTrajet;
    }
    public String getVilleDepart() {
        return villeDepart;
    }
    public String getPaysDepart() {
        return paysDepart;
    }
    public String getVilleArrivee() {
        return villeArrivee;
    }
    public String getPaysArrivee() {
        return paysArrivee;
    }
    public Double getFraisEconomique() {
        return fraisEconomique;
    }
    public Double getFraisBusiness() {
        return fraisBusiness;
    }
    public Double getFraisEnfant() {
        return fraisEnfant;
    }
}
