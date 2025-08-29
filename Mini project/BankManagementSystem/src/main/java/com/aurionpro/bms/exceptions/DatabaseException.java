package com.aurionpro.bms.exceptions;

public class DatabaseException extends RuntimeException {
	public DatabaseException() {
		super("Database Error");
	}
	public DatabaseException(String message, Throwable cause) {
		super(message,cause);
	}
	public DatabaseException(String message) {
		super(message);
	}

}
