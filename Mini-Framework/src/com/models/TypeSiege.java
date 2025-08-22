package com.models;

import javax.persistence.*;

@Entity
@Table(name = "types_siege")
public class TypeSiege 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_siege")
    private Long idTypeSiege;

    @Column(name = "nom_type_siege", nullable = false, length = 50)
    private String nomTypeSiege;


    public Long getIdTypeSiege() {
        return idTypeSiege;
    }
    public void setIdTypeSiege(Long idTypeSiege) {
        this.idTypeSiege = idTypeSiege;
    }
    public String getNomTypeSiege() {
        return nomTypeSiege;
    }
    public void setNomTypeSiege(String nomTypeSiege) {
        this.nomTypeSiege = nomTypeSiege;
    }
}
