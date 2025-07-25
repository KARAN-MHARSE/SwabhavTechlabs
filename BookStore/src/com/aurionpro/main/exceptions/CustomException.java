package com.aurionpro.main.exceptions;

public class CustomException extends RuntimeException{
	public CustomException() {
		super("Something went wrong");
	}
	public CustomException(String message) {
		super(message);
	}
}
