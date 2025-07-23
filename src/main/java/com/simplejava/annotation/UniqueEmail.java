package com.simplejava.annotation;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 10:03 PM
 */
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default "Email must be unique across all applicants";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
