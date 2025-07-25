package com.aurionpro.test.inputvalidor;

public class EmailValidator {
	private String email;

	public EmailValidator(String email) {
		super();
		this.email = email;
	}
	
	public void validateEmail() {
		if(email != null && !email.equals("") && email.length() >5 && email.length() <=50 && email.indexOf('@') != -1 && email.indexOf('.') != -1) {
			System.out.println("Email id valid");
			return;
		}
		System.out.println("Email is not valid");
		
	}

}
