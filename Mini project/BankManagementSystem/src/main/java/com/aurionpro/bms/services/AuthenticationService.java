package com.aurionpro.bms.services;

import java.util.Optional;

import com.aurionpro.bms.dao.AuthenticationDao;
import com.aurionpro.bms.exceptions.InputValidatorException;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.util.InputValidatorUtil;

public class AuthenticationService {
	private final AuthenticationDao authenticationDao;
	
	public AuthenticationService(AuthenticationDao authenticationDao) {
		this.authenticationDao = authenticationDao;
	}
	
	public Optional<User> login(String email,String password) {
		if(email==null || email.isBlank() || password==null || password.isBlank()) {
			throw new InputValidatorException("Enter valid email and password");
		}
		return authenticationDao.login(email, password);
	}
	
	public User register(User user) {
		if(user == null) throw new InputValidatorException("User is null");
		
		if(user.getName() == null || user.getName().isBlank()) {
			throw new InputValidatorException("Name cannot be empty");
		}
		if(user.getEmail() == null || user.getEmail().isBlank() || !InputValidatorUtil.isValidEmail(user.getEmail())) {
			throw new InputValidatorException("Invalid email id");
		}
		if(user.getAddress() == null || user.getAddress().isBlank()) {
			throw new InputValidatorException("Address cannot be empty");
		}
		
		if(!InputValidatorUtil.isValidMobileNumber(user.getMobile())) {
			throw new InputValidatorException("Enter valid mobile number");
		}
		if(!InputValidatorUtil.isValidAdharNumber(user.getAdharNo())) {
			throw new InputValidatorException("Enter valid adhar number");
		}
		
		return authenticationDao.register(user);
	}

	
}
