package com.simplejava.annotation;

import com.simplejava.dto.CreditCardApplication;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, CreditCardApplication> {

    @Override
    public boolean isValid(CreditCardApplication application, ConstraintValidatorContext context) {
        if (application == null) {
            return true;
        }

        Set<String> emails = new HashSet<>();

        // Check primary applicant
        if (application.getPrimaryApplicant() != null &&
                !emails.add(application.getPrimaryApplicant().getEmail())) {
            addViolation(context, "primaryApplicant.email", "Email must be unique across all applicants");
            return false;
        }

        // Check co-applicants
        if (application.getCoApplicants() != null) {
            for (int i = 0; i < application.getCoApplicants().size(); i++) {
                if (!emails.add(application.getCoApplicants().get(i).getEmail())) {
                    addViolation(context, String.format("coApplicants[%d].email", i),
                            "Email must be unique across all applicants");
                    return false;
                }
            }
        }

        return true;
    }

    private void addViolation(ConstraintValidatorContext context, String path, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(path)
                .addConstraintViolation();
    }
}