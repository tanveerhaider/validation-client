package com.simplejava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;

public class ProblemDetailFactory {
    public static ProblemDetail create(URI type, HttpStatus status, String detail, URI instance) {
        ProblemDetail pd = ProblemDetail.forStatus(status);
        pd.setType(type);
        pd.setTitle(status.getReasonPhrase());
        pd.setDetail(detail);
        pd.setInstance(instance);
        return pd;
    }
}
