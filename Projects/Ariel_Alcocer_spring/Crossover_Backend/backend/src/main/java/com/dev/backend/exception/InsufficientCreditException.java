package com.dev.backend.exception;

public class InsufficientCreditException extends RuntimeException {

    private String errorMessage;

    public InsufficientCreditException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
