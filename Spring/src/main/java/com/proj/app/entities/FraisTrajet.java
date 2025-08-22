package com.proj.app.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "frais_trajets")
public class FraisTrajet 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_frais_trajet")
    private Long idFraisTrajet;

    @Column(name = "date_changement", nullable = false)
    private LocalDate dateChangement;

    @Column(name = "frais", nullable = false)
    private Double frais;

    @ManyToOne
    @JoinColumn(name = "id_type_frais", nullable = false)
    private TypeFrais typeFrais;

    @ManyToOne
    @JoinColumn(name = "id_trajet", nullable = false)
    private Trajet trajet;


    public Long getIdFraisTrajet() {
        return idFraisTrajet;
    }
    public void setIdFraisTrajet(Long idFraisTrajet) {
        this.idFraisTrajet = idFraisTrajet;
    }
    public LocalDate getDateChangement() {
        return dateChangement;
    }
    public void setDateChangement(LocalDate dateChangement) {
        this.dateChangement = dateChangement;
    }
    public Double getFrais() {
        return frais;
    }
    public void setFrais(Double frais) {
        this.frais = frais;
    }
    public Trajet getTrajet() {
        return trajet;
    }
    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
    public TypeFrais getTypeFrais() {
        return typeFrais;
    }
    public void setTypeFrais(TypeFrais typeFrais) {
        this.typeFrais = typeFrais;
    }
}
