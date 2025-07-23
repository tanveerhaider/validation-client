package com.simplejava.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 10:54 PM
 */
public class ValidationResult {
    private boolean valid;
    private List<ValidationError> errors;

    public ValidationResult() {
        this.errors = new ArrayList<>();
    }

    public boolean isValid() {
        return valid;
    }

    public List<ValidationError> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void addError(ValidationError error) {
        this.errors.add(error);
        this.valid = false;
    }

    public static ValidationResult valid() {
        ValidationResult result = new ValidationResult();
        result.valid = true;
        return result;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "valid=" + valid +
                ", errors=" + errors +
                '}';
    }
}

