package com.github.hburgmeier.jerseyoauth2.authsrv.api.ui;

public class AuthorizationFlowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorizationFlowException() {
	}

	public AuthorizationFlowException(String message) {
		super(message);
	}

	public AuthorizationFlowException(Throwable cause) {
		super(cause);
	}

	public AuthorizationFlowException(String message, Throwable cause) {
		super(message, cause);
	}

}
