package com.baeldung.web.error;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    public GlobalExceptionHandlerController() {
        super();
    }

    //

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException ex) {
        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), "test");
        return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}