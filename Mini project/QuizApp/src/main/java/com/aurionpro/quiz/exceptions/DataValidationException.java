package com.aurionpro.quiz.exceptions;

public class DataValidationException extends RuntimeException{
	public DataValidationException() {
		super();
	}
	
	public DataValidationException(String message) {
		super(message);
	}
}
