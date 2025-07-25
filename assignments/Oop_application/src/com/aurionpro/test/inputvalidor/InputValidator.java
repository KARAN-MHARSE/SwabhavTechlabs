package com.aurionpro.test.inputvalidor;

import java.util.Scanner;

public class InputValidator {
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

//		takeInputAndvalidateUser(scanner);
		
	}
	public boolean validate(String input, int minimumLength, int maximumLength) {
		if(input==null || input.equals("") || input.length() < minimumLength || input.length() >maximumLength){
			return false;
		}
		return true;
		
	}
	public boolean validateUsername(String userName) {
		return validate(userName, 3, 20);
	}
	public boolean validatePassword(String password) {
		return validate(password, 8, 20);
	}
	
	public boolean validateEmail(String email) {
		if(!validate(email, 5, 50)) return false;
		
		if(!email.contains("@)") || !email.contains(".")) return false;
		
		return true;
	}
	

//	private static void takeInputAndvalidateUser(Scanner scanner) {
//		System.out.println("Enter the user name");
//		String userName = scanner.nextLine();
//		
//		System.out.println("Enter the password");
//		String password = scanner.nextLine();
//		
//		System.out.println("Enter the user email id");
//		String email = scanner.nextLine();
//		
//		validate(userName,password,email);
//		
//		
//	}
//
//	private static void validate(String userName, String password, String email) {
//		UserNameValidator userNameValidator = new UserNameValidator(userName);
//		userNameValidator.validateUserName();
//		
//		EmailValidator emailValidator = new EmailValidator(email);
//		emailValidator.validateEmail();
//		
//		PasswordValidator passwordValidator = new PasswordValidator(password);
//		passwordValidator.validatePassword();
//		
//	}


}


