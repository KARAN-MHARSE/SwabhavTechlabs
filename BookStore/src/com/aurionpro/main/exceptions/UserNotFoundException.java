package com.aurionpro.main.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("User not found");
	}

}
