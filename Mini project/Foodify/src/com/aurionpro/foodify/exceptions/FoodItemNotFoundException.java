package com.aurionpro.foodify.exceptions;

import java.util.UUID;

public class FoodItemNotFoundException extends RuntimeException {
	
	public  FoodItemNotFoundException() {
		super("Food Item not found");
	}
	
	public FoodItemNotFoundException(UUID id){
		super("Food Item not found of id "+id);
	}
	
	public FoodItemNotFoundException(String name){
		super("Food Item not found of name "+name);
	}
}
