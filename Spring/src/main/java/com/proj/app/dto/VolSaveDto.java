package com.proj.app.dto;

import java.time.LocalDateTime;
import com.proj.app.validators.ValidVolDates;
import jakarta.validation.constraints.NotNull;

@ValidVolDates
public class VolSaveDto 
{
    @NotNull(message = "La date de départ est obligatoire")
    private LocalDateTime dateDepart;

    private LocalDateTime dateArrivee;

    @NotNull(message = "Le trajet est obligatoire")
    private Long idTrajet;

    @NotNull(message = "L'avion est obligatoire")
    private Long idAvion;


    // getters & setters
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

    public Long getIdTrajet() {
        return idTrajet;
    }
    public void setIdTrajet(Long idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Long getIdAvion() {
        return idAvion;
    }
    public void setIdAvion(Long idAvion) {
        this.idAvion = idAvion;
    }
}
