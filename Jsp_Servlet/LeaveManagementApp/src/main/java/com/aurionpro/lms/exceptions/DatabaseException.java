package com.aurionpro.lms.exceptions;

public class DatabaseException extends RuntimeException{
	public DatabaseException() {
		super("Database error");
	}
	
	public DatabaseException(String message) {
		super(message);
	}

}
