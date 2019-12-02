package com.ccanto.zenklub.schedule.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ScheduleExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ScheduleNotFoundException.class})
    protected ResponseEntity<Object> handleScheduleNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Schedule not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
