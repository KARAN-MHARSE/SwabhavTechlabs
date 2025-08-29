package com.aurionpro.bms.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("User not found");
	}
}
