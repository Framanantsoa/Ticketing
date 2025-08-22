package com.proj.app.validators;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VolDatesValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidVolDates 
{
    String message() default "La date d'arrivée doit être après la date de départ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
