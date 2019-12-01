package com.ccanto.zenklub.registration.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RegistrationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProfessionalNotFoundException.class})
    protected ResponseEntity<Object> handleProfessionalNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Professional not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ClientNotFoundException.class})
    protected ResponseEntity<Object> handleClientNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Client not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
