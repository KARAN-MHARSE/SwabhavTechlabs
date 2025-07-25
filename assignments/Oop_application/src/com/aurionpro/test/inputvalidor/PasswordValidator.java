package com.aurionpro.test.inputvalidor;

public class PasswordValidator {
private String passoword;
	
	public PasswordValidator(String password) {
		this.passoword = password;
	}
	
	public void validatePassword() {
		if(passoword != null && !passoword.equals("") && passoword.length() > 8 && passoword.length() <=30) {
			System.out.println("Password is valid");
			return;
		}
		System.out.println("Password is not valid");
	}
}
