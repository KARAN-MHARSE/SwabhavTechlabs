package com.aurionpro.foodify.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException() {
		super("User not found");
	}
	
	public UserNotFoundException(UUID id){
		super("User not found with user id "+id);
	}

}
