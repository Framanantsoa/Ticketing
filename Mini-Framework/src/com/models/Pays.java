package com.models;

import javax.persistence.*;

@Entity
@Table(name = "pays")
public class Pays 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pays")
    private Long idPays;

    @Column(name = "nom_pays", nullable = false, length = 50)
    private String nomPays;


    public Long getIdPays() {
        return idPays;
    }
    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }
    public String getNomPays() {
        return nomPays;
    }
    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
}
