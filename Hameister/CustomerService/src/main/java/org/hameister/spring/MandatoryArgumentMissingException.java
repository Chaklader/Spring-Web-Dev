package org.hameister.spring;


public class MandatoryArgumentMissingException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE_FORMAT = "The mandatory argument '%s' is missing in the request.";
	
	public MandatoryArgumentMissingException(String missingArgumentName) {
        super(String.format(MESSAGE_FORMAT, missingArgumentName));
    }
}
