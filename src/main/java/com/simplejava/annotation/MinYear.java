package com.simplejava.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinYearValidator.class)
@Documented
public @interface MinYear {
    String message() default "Date must be after {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value() default 1900; // Default minimum year
}