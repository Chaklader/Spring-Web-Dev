package com.mohsenj.core.lib.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable ex) {
        super(message, ex);
    }

	public BadRequestException() {
		super("");
	}

}
