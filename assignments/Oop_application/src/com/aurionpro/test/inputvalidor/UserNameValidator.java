package com.aurionpro.test.inputvalidor;

public class UserNameValidator {
	private String userName;
	
	public UserNameValidator(String userName) {
		this.userName = userName;
	}
	
	public void validateUserName() {
		if(userName != null && !userName.equals("") && userName.length() >3 && userName.length()<=20 ) {
			
			System.out.println("userName is valid");
			return;
		}
		 System.out.println("userName is not valid");;
	}
}
