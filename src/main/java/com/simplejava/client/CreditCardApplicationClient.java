package com.simplejava.client;

import com.simplejava.dto.CreditCardApplication;
import org.springframework.stereotype.Component;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 10:56 PM
 */
public class CreditCardApplicationClient {
    private final CreditCardApplicationValidator validator;

    public CreditCardApplicationClient(CreditCardApplicationValidator validator) {
        this.validator = validator;
    }

    public void processApplication(CreditCardApplication application) {
        ValidationResult result = validator.validate(application);

        if (!result.isValid()) {
            System.out.println("Validation errors found:");
            for (ValidationError error : result.getErrors()) {
                System.out.printf("- %s: %s (Code: %s)%n",
                        error.getFieldPath(), error.getMessage(), error.getErrorCode());
            }
            throw new IllegalArgumentException("Invalid application data");
        }

        // Proceed with valid application
        System.out.println("Application is valid. Processing...");
    }
}
