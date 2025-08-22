package com.proj.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;

    @Column(name = "nom_complet", nullable = false, length = 120)
    private String nomComplet;

    @Column(name = "cin", nullable = false, length = 15)
    private String cin;

    @Column(name = "telephone", nullable = false, length = 15)
    private String telephone;

    @Column(name = "nombre_place", nullable = false)
    private Integer nombrePlace;

    @Column(name = "nombre_enfant", nullable = false)
    private Integer nombreEnfant;

    @Column(name = "place_business", nullable = false)
    private Integer placeBusiness;

    @Column(name = "place_economique", nullable = false)
    private Integer placeEconomique;

    @ManyToOne
    @JoinColumn(name = "id_statut")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "id_vol", nullable = false)
    private Vol vol;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;


    public Long getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }
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
    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
