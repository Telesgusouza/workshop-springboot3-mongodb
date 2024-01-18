package com.gustavo.workshop.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8255577131401383075L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
}
