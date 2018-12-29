package org.hameister.spring;


public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE_FORMAT = "Customer with id '%s' not found.";
	
	public CustomerNotFoundException(String customerId) {
        super(String.format(MESSAGE_FORMAT, customerId));
    }
}
