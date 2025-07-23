package com.simplejava.client;

import com.simplejava.dto.CreditCardApplication;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Set;
/**
 * Validator implementation that uses Jakarta Bean Validation (JSR 380)
 * to validate {@link CreditCardApplication} objects.
 * <p>
 * Collects all constraint violations and maps them to custom error codes.
 */
@Component
public class CreditCardApplicationBeanValidator implements CreditCardApplicationValidator {
    private final Validator validator;

    /**
     * Constructs a new CreditCardApplicationBeanValidator with the provided Validator.
     *
     * @param validator the Validator instance to use for validation
     */
    public CreditCardApplicationBeanValidator(Validator validator) {
        this.validator = validator;
    }
    /**
     * Validates the given {@link CreditCardApplication} using bean validation constraints.
     *
     * @param application the credit card application to validate
     * @return a {@link ValidationResult} containing validation errors, or valid if none found
     */
    @Override
    public ValidationResult validate(CreditCardApplication application) {
        ValidationResult result = new ValidationResult();

        Set<ConstraintViolation<CreditCardApplication>> violations =
                validator.validate(application);

        for (ConstraintViolation<CreditCardApplication> violation : violations) {
            result.addError(new ValidationError(
                    violation.getPropertyPath().toString(),
                    determineErrorCode(violation),
                    violation.getMessage()
            ));
        }

        if (result.getErrors().isEmpty()) {
            return ValidationResult.valid();
        }
        return result;
    }
    /**
     * Determines the error code for a given constraint violation by mapping
     * the annotation type to a custom error code.
     *
     * @param violation the constraint violation
     * @return the corresponding error code as a String
     */
    private String determineErrorCode(ConstraintViolation<CreditCardApplication> violation) {
        // Map the annotation type to an error code
        return ValidationErrorCodes.getErrorCode(
                violation.getConstraintDescriptor().getAnnotation().annotationType()
        );
    }
}
