package com.aurionpro.foodify.exceptions;

public class DataValidationException extends RuntimeException {
	public DataValidationException() {
		super("Data is not validate.");
	}

	public DataValidationException(String message) {
		super(message);
	}
}
