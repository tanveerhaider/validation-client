package com.simplejava.exception;

import java.net.URI;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/12/2025
 * Time: 11:19 PM
 */
public class ProblemTypes {
    public static final URI VALIDATION_ERROR = URI.create("https://api.mybank.com/problems/validation-error");
    public static final URI AUTHENTICATION_FAILURE = URI.create("https://api.mybank.com/problems/auth-failed");
    public static final URI INSUFFICIENT_CREDIT = URI.create("https://api.mybank.com/problems/insufficient-credit");
}
