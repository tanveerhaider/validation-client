package com.simplejava.annotation;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/12/2025
 * Time: 11:33 PM
 */
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Year;

public class MinYearValidator implements ConstraintValidator<MinYear, LocalDate> {
    private int minYear;

    @Override
    public void initialize(MinYear constraintAnnotation) {
        this.minYear = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Let @NotNull handle null checks
        }
        return value.getYear() >= minYear;
    }
}
