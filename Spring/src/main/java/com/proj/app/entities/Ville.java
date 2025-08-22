package com.proj.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "villes")
public class Ville 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ville")
    private Long idVille;

    @Column(name = "nom_ville", nullable = false, length = 50)
    private String nomVille;

    @ManyToOne
    @JoinColumn(name = "id_pays", nullable = false)
    private Pays pays;
    

    public Long getIdVille() {
        return idVille;
    }
    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }
    public String getNomVille() {
        return nomVille;
    }
    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }
    public Pays getPays() {
        return pays;
    }
    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
