package com.models;

import javax.persistence.*;

@Entity
@Table(name = "trajets")
public class Trajet 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trajet")
    private Long idTrajet;

    @ManyToOne
    @JoinColumn(name = "id_depart", nullable = false)
    private Ville depart;

    @ManyToOne
    @JoinColumn(name = "id_arrivee", nullable = false)
    private Ville arrivee;

    
    public Long getIdTrajet() {
        return idTrajet;
    }
    public void setIdTrajet(Long idTrajet) {
        this.idTrajet = idTrajet;
    }
    public Ville getDepart() {
        return depart;
    }
    public void setDepart(Ville depart) {
        this.depart = depart;
    }
    public Ville getArrivee() {
        return arrivee;
    }
    public void setArrivee(Ville arrivee) {
        this.arrivee = arrivee;
    }
}
