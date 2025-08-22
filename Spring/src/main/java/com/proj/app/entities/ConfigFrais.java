package com.proj.app.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "config_frais")
public class ConfigFrais
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_config")
    private Long idConfig;

    @Column(name = "pourcentage", nullable = false)
    private Double pourcentage;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;


    public Long getIdConfig() {
        return idConfig;
    }
    public void setIdConfig(Long idConfig) {
        this.idConfig = idConfig;
    }
    public Double getPourcentage() {
        return pourcentage;
    }
    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
