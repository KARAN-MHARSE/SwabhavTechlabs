package com.aurionpro.foodify.utils;

public class InputValidator {
public static boolean isEmailValid(String email) {
	int atTheRateIndex = -1;
	int dotIndex = -1;
	
	if(email.indexOf('@') == -1 || email.indexOf('.') == -1 || email.length()<4) {
		return false;
	}
	
	return true;
}
}
