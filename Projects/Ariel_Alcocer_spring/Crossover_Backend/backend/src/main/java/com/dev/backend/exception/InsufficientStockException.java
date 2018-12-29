package com.dev.backend.exception;

public class InsufficientStockException extends RuntimeException {
    private String errorMessage;

    public InsufficientStockException(String errorMessage) {
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
