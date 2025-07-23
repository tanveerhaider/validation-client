package com.simplejava.client;

import java.lang.annotation.Annotation;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 10:55 PM
 */
public class ValidationError {
    private String fieldPath;
    private String errorCode;
    private String message;

    // Constructor, getters, and setters
    public ValidationError(String fieldPath, String errorCode, String message) {
        this.fieldPath = fieldPath;
        this.errorCode = errorCode;
        this.message = message;
    }

    // Getters omitted for brevity


    public String getFieldPath() {
        return fieldPath;
    }

    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "fieldPath='" + fieldPath + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
