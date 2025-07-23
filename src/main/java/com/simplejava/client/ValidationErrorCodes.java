package com.simplejava.client;

import java.lang.annotation.Annotation;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/19/2025
 * Time: 7:14 PM
 */
public class ValidationErrorCodes {

    // Format: HTTP_STATUS.ERROR_GROUP.SPECIFIC_ERROR
    public static final String NOT_NULL = "400.001";
    public static final String NOT_BLANK = "400.002";
    public static final String SIZE = "400.003";
    public static final String PATTERN = "400.004";
    public static final String EMAIL = "400.005";
    public static final String PAST_DATE = "400.006";
    public static final String FUTURE_DATE = "400.007";
    public static final String MIN_MAX = "400.008";
    public static final String DIGITS = "400.009";
    public static final String ASSERT_TRUE = "400.010";
    public static final String MIN_YEAR = "400.011";

    // Business validation codes
    public static final String CREDIT_LIMIT_EXCEEDED = "400.101";
    public static final String INVALID_TAX_ID = "400.102";
    public static final String UNIQUE_SSN = "400.103";
    public static final String UNIQUE_EMAIL = "400.104";


    public static String getErrorCode(Class<? extends Annotation> constraintType) {
        return switch (constraintType.getSimpleName()) {
            case "NotNull" -> NOT_NULL;
            case "NotBlank" -> NOT_BLANK;
            case "Size" -> SIZE;
            case "Pattern" -> PATTERN;
            case "Email" -> EMAIL;
            case "Past" -> PAST_DATE;
            case "Future" -> FUTURE_DATE;
            case "Min", "Max", "DecimalMin", "DecimalMax" -> MIN_MAX;
            case "Digits" -> DIGITS;
            case "AssertTrue" -> ASSERT_TRUE;
            case "MinYear" -> MIN_YEAR;
            case "UniqueSSN" -> UNIQUE_SSN;
            case "UniqueEmail" -> UNIQUE_EMAIL;
            default -> "400.000"; // Generic validation error
        };
    }

}
