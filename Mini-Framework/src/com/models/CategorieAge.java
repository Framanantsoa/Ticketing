package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories_ages")
public class CategorieAge 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie_age")
    private Long idCategorieAge;

    @Column(name = "nom_categorie_age", nullable = false, length = 50)
    private String nomCategorieAge;

    @Column(name = "age_min", nullable = false)
    private Short ageMin;

    @Column(name = "age_max", nullable = false)
    private Short ageMax;


    public Long getIdCategorieAge() {
        return idCategorieAge;
    }
    public void setIdCategorieAge(Long idCategorieAge) {
        this.idCategorieAge = idCategorieAge;
    }
    public String getNomCategorieAge() {
        return nomCategorieAge;
    }
    public void setNomCategorieAge(String nomCategorieAge) {
        this.nomCategorieAge = nomCategorieAge;
    }
    public Short getAgeMin() {
        return ageMin;
    }
    public void setAgeMin(Short ageMin) {
        this.ageMin = ageMin;
    }
    public Short getAgeMax() {
        return ageMax;
    }
    public void setAgeMax(Short ageMax) {
        this.ageMax = ageMax;
    }
}
