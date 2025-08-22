package com.proj.app.validators;

import com.proj.app.dto.VolSaveDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VolDatesValidator implements ConstraintValidator<ValidVolDates, VolSaveDto> 
{
    @Override
    public boolean isValid(VolSaveDto dto, ConstraintValidatorContext context) {
        // si une des deux dates est null, on ne valide pas ici
        if (dto.getDateDepart() == null || dto.getDateArrivee() == null) {
            return true; 
        }
        return dto.getDateArrivee().isAfter(dto.getDateDepart());
    }
}
