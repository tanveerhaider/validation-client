package com.simplejava.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueSSNValidator.class)
@Documented
public @interface UniqueSSN {
    String message() default "SSN must be unique across all applicants";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}