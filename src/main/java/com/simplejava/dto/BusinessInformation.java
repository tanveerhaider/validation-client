package com.simplejava.dto;

import com.simplejava.annotation.MinYear;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 *  Description :
 * User: Tanveer Haider
 * Date: 7/12/2025
 * Time: 11:10 PM
 * 
 */
public class BusinessInformation {
    @NotBlank(message = "Business name is required")
    @Size(max = 100, message = "Business name cannot exceed 100 characters")
    private String businessName;

    @NotBlank(message = "Tax ID is required")
    @Pattern(regexp = "^\\d{2}-\\d{7}$", message = "Tax ID must be in format XX-XXXXXXX")
    private String taxId;

    @NotNull(message = "Business start date is required")
    @Past(message = "Business start date must be in the past")
    @MinYear(value = 1900, message = "Business start date must be after 1900")
    private LocalDate businessStartDate;

    @NotNull(message = "Annual revenue is required")
    @DecimalMin(value = "0.00", message = "Annual revenue cannot be negative")
    private Double annualRevenue;

    @NotNull(message = "Number of employees is required")
    @Min(value = 1, message = "Must have at least 1 employee")
    private Integer numberOfEmployees;

    @Valid
    @NotNull(message = "Business address is required")
    private Address businessAddress;

    // Getters and setters


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public LocalDate getBusinessStartDate() {
        return businessStartDate;
    }

    public void setBusinessStartDate(LocalDate businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    public Double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(Double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Address getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    @Override
    public String toString() {
        return "BusinessInformation{" +
                "businessName='" + businessName + '\'' +
                ", taxId='" + taxId + '\'' +
                ", businessStartDate=" + businessStartDate +
                ", annualRevenue=" + annualRevenue +
                ", numberOfEmployees=" + numberOfEmployees +
                ", businessAddress=" + businessAddress +
                '}';
    }
}
