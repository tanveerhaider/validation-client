package com.simplejava.annotation;

import com.simplejava.dto.CreditCardApplication;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class UniqueSSNValidator implements ConstraintValidator<UniqueSSN, CreditCardApplication> {

    @Override
    public boolean isValid(CreditCardApplication application, ConstraintValidatorContext context) {
        if (application == null) {
            return true;
        }

        Set<String> ssns = new HashSet<>();

        // Check primary applicant
        if (application.getPrimaryApplicant() != null &&
                !ssns.add(application.getPrimaryApplicant().getSsn())) {
            addViolation(context, "primaryApplicant.ssn", "SSN must be unique across all applicants");
            return false;
        }

        // Check co-applicants
        if (application.getCoApplicants() != null) {
            for (int i = 0; i < application.getCoApplicants().size(); i++) {
                if (!ssns.add(application.getCoApplicants().get(i).getSsn())) {
                    addViolation(context, String.format("coApplicants[%d].ssn", i),
                            "SSN must be unique across all applicants");
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
