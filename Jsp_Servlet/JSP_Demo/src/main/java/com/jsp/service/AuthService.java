package com.jsp.service;

import com.jsp.dao.AuthDao;
import com.jsp.model.Student;

public class AuthService {
	private AuthDao authDao;
	
	public AuthService() {
		authDao = new AuthDao();
	}
	
	public boolean login(Student student) {
		return authDao.login(student);
	}

}
