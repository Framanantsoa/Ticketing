package com.models;

import javax.persistence.*;

@Entity
@Table(name = "statuts")
public class Statut 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statut")
    private Long idStatut;

    @Column(name = "nom_statut", nullable = false, length = 50)
    private String nomStatut;

    public Long getIdStatut() {
        return idStatut;
    }
    public void setIdStatut(Long idStatut) {
        this.idStatut = idStatut;
    }
    public String getNomStatut() {
        return nomStatut;
    }
    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }
}
