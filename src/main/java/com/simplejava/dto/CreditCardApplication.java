package com.simplejava.dto;

import com.simplejava.annotation.UniqueEmail;
import com.simplejava.annotation.UniqueSSN;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 *  Description :
 * User: Tanveer Haider
 * Date: 7/12/2025
 * Time: 11:12 PM
 * 
 */
@UniqueSSN
@UniqueEmail
public class CreditCardApplication {

    @NotNull(message = "Application type is required")
    private ApplicationType applicationType;

    @Valid
    @NotNull(message = "Primary applicant is required")
    private Applicant primaryApplicant;

    @Valid
    private List<Applicant> coApplicants;

    @Valid
    @NotNull(message = "Business information is required")
    private BusinessInformation businessInformation;

    @NotNull(message = "Requested credit limit is required")
    @DecimalMin(value = "1000.00", message = "Minimum credit limit is $1000")
    @DecimalMax(value = "100000.00", message = "Maximum credit limit is $100,000")
    private Double requestedCreditLimit;

    @AssertTrue(message = "You must agree to the terms and conditions")
    private boolean termsAccepted;

    // Getters and setters

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

    public Applicant getPrimaryApplicant() {
        return primaryApplicant;
    }

    public void setPrimaryApplicant(Applicant primaryApplicant) {
        this.primaryApplicant = primaryApplicant;
    }

    public List<Applicant> getCoApplicants() {
        return coApplicants;
    }

    public void setCoApplicants(List<Applicant> coApplicants) {
        this.coApplicants = coApplicants;
    }

    public BusinessInformation getBusinessInformation() {
        return businessInformation;
    }

    public void setBusinessInformation(BusinessInformation businessInformation) {
        this.businessInformation = businessInformation;
    }

    public Double getRequestedCreditLimit() {
        return requestedCreditLimit;
    }

    public void setRequestedCreditLimit(Double requestedCreditLimit) {
        this.requestedCreditLimit = requestedCreditLimit;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }

    @Override
    public String toString() {
        return "CreditCardApplication{" +
                "applicationType=" + applicationType +
                ", primaryApplicant=" + primaryApplicant +
                ", coApplicants=" + coApplicants +
                ", businessInformation=" + businessInformation +
                ", requestedCreditLimit=" + requestedCreditLimit +
                ", termsAccepted=" + termsAccepted +
                '}';
    }
}


