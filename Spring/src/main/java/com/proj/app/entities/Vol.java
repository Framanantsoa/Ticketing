package com.proj.app.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "vols")
public class Vol 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vol")
    private Long idVol;

    @Column(name = "date_depart", nullable = false)
    private LocalDateTime dateDepart;

    @Column(name = "date_arrivee")
    private LocalDateTime dateArrivee;

    @ManyToOne
    @JoinColumn(name = "id_trajet", nullable = false)
    private Trajet trajet;

    @ManyToOne
    @JoinColumn(name = "id_avion", nullable = false)
    private Avion avion;

    @Column(name = "is_deleted")
    private boolean isDeleted;
    

    public Long getIdVol() {
        return idVol;
    }
    public void setIdVol(Long idVol) {
        this.idVol = idVol;
    }
    public LocalDateTime getDateDepart() {
        return dateDepart;
    }
    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }
    public LocalDateTime getDateArrivee() {
        return dateArrivee;
    }
    public void setDateArrivee(LocalDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }
    public Trajet getTrajet() {
        return trajet;
    }
    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
    public Avion getAvion() {
        return avion;
    }
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    public void setIsDeleted(boolean val) {
        this.isDeleted = val;
    }
    public boolean getIsDeleted() {
        return isDeleted;
    }
}
