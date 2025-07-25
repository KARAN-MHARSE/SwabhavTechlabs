package com.aurionpro.jdbc.exceptions;

public class DatabaseConnectionNotFoundException extends RuntimeException {
public DatabaseConnectionNotFoundException() {
	super("Database not connected");
}
}
