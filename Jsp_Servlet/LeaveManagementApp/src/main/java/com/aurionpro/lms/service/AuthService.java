package com.aurionpro.lms.service;

import com.aurionpro.lms.dao.AuthDao;
import com.aurionpro.lms.model.Employee;

public class AuthService {
	private AuthDao authDao;
	
	public AuthService() {
		this.authDao = new AuthDao();
	}
	
	public Employee login(String email,String password) {
		return authDao.login(email, password);
	}

}
