package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types_frais")
public class TypeFrais 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_frais")
    private Long idTypeFrais;

    @Column(name = "nom_type_frais", nullable = false, length = 50)
    private String nomTypeFrais;


    public Long getIdTypeFrais() {
        return idTypeFrais;
    }
    public void setIdTypeFrais(Long idTypeFrais) {
        this.idTypeFrais = idTypeFrais;
    }
    public String getNomTypeFrais() {
        return nomTypeFrais;
    }
    public void setNomTypeFrais(String nomTypeFrais) {
        this.nomTypeFrais = nomTypeFrais;
    }
}
