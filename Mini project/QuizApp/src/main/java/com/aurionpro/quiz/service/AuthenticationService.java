package com.aurionpro.quiz.service;

import com.aurionpro.quiz.dao.AuthenticationDao;
import com.aurionpro.quiz.exceptions.DatabaseException;
import com.aurionpro.quiz.model.User;

public class AuthenticationService {
	private final AuthenticationDao authenticationDao;
	
	public AuthenticationService() throws DatabaseException {
		this.authenticationDao = new AuthenticationDao();
	}
	
	
	public User login(String email,String password) throws DatabaseException {
		return authenticationDao.login(email, password);
	}
	
	
	
	
}
