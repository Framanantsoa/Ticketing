package com.proj.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "avions")
public class Avion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avion")
    private Long idAvion;

    @Column(name = "nom_avion", nullable = false, length = 50)
    private String nomAvion;

    @Column(name = "siege_economique", nullable = false)
    private Short siegeEconomique;

    @Column(name = "siege_business", nullable = false)
    private Short siegeBusiness;

    public Long getIdAvion() {
        return idAvion;
    }
    public void setIdAvion(Long idAvion) {
        this.idAvion = idAvion;
    }
    public String getNomAvion() {
        return nomAvion;
    }
    public void setNomAvion(String nomAvion) {
        this.nomAvion = nomAvion;
    }
    public Short getSiegeEconomique() {
        return siegeEconomique;
    }
    public void setSiegeEconomique(Short siegeEconomique) {
        this.siegeEconomique = siegeEconomique;
    }
    public Short getSiegeBusiness() {
        return siegeBusiness;
    }
    public void setSiegeBusiness(Short siegeBusiness) {
        this.siegeBusiness = siegeBusiness;
    }
}
