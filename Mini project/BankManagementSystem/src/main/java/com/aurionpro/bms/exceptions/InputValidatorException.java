package com.aurionpro.bms.exceptions;

public class InputValidatorException extends RuntimeException {

	public InputValidatorException() {
		super("Enter valid credentials");
	}
	public InputValidatorException(String message) {
		super(message);
	}
}

