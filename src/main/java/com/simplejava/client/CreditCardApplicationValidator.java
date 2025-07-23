package com.simplejava.client;

import com.simplejava.dto.CreditCardApplication;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 10:54 PM
 */
public interface CreditCardApplicationValidator {
    ValidationResult validate(CreditCardApplication application);
}
