package com.aurionpro.main.exceptions;

public class InvalidBookDetailsException extends RuntimeException {
	private String message;

	public InvalidBookDetailsException() {
		this("The details are not valid");
	}

	public InvalidBookDetailsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
