package com.aurionpro.foodify.controllers;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import com.aurionpro.foodify.Foodify;
import com.aurionpro.foodify.builder.UserBuilder;
import com.aurionpro.foodify.exceptions.CustomException;
import com.aurionpro.foodify.exceptions.DataValidationException;
import com.aurionpro.foodify.exceptions.UserNotFoundException;
import com.aurionpro.foodify.models.Customer;
import com.aurionpro.foodify.models.FoodItem;
import com.aurionpro.foodify.models.User;
import com.aurionpro.foodify.utils.UserUtility;

public class Authentication {
	
	public static void register(Scanner scanner, Map<UUID, User> users) {
		System.out.println("Enter the user name");
		String userName = scanner.nextLine().trim();
		
		System.out.println("Enter the email id");
		String email = scanner.nextLine().trim();
		
		if(isUserPresent(users, email)) throw new CustomException("Email id already registered, Use another one.");
		
		if(!validateEmailId(email)) throw new CustomException("Enter valid email id");
		
		System.out.println("Enter the mobile number");
		Long mobileNumber = scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter the password greater 5 characters");
		String password = scanner.nextLine();
		
		if(password.isBlank() || password.length() <5) throw new CustomException("Password length should be greater than 5 characters");
		
		if(String.valueOf(mobileNumber).length() <10 || String.valueOf(mobileNumber).length() != 10) {
			throw new CustomException("Mobile number must be exactly 10 digits. Please try again.");
		}
		
		if( userName.isBlank() || email.isBlank()  || password.isBlank()) {
			throw new DataValidationException("All credentials are required");
		}
		
		Customer customer = new UserBuilder()
				.setName(userName)
				.setEmail(email)
				.setMobileNumber(mobileNumber)
				.setPassword(password)
				.buildCustomer();
		
		if(customer == null) throw new CustomException("Something went wrong, try again");
		users.put(customer.getId(), customer);
		
		System.out.println("User successfully registered");
	}
	
	public static boolean login(Scanner scanner, Map<UUID,User> users) {	
		System.out.println("Enter the email id");
		String email = scanner.nextLine();
			
		System.out.println("Enter the password");
		String password = scanner.nextLine();
		
		User user = UserUtility.getUserByEmailId(users, email);
		if(user==null) throw new UserNotFoundException();
		
		if(!user.getPassword().equals(password)) throw new CustomException("Wrong credentials");
		
//		if user authenticated
		Foodify.currentUser = user;
		System.out.println("User login successfully");
		return true;
	}
	
	public static boolean validateEmailId(String email) {
		if(email.isBlank() || email.indexOf('@') <= 1 || email.indexOf('.') <= 2  ) {
			return false;			
		}
		return true;
		
	}
	
	public static boolean isUserPresent(Map<UUID, User> users, String email) {
		User user = UserUtility.getUserByEmailId(users, email);
		if(user!= null ) return true;
		return false;
	}

}
