package com.aurionpro.main.service;

import javax.management.RuntimeErrorException;

import com.aurionpro.main.dao.AuthenticationDao;
import com.aurionpro.main.dao.StudentDao;
import com.aurionpro.main.model.Student;

public class AuthenticationService {
	private final AuthenticationDao loginDao;
	private final StudentDao studentDao;
	
	public AuthenticationService() {
		this.loginDao = new AuthenticationDao();
		this.studentDao = new StudentDao();
	}
	
	public boolean login(String username,String password) {
		if(username==null || username.isBlank()) {
			throw new RuntimeException("Enter valid username");
		}
		
		if(password==null || password.isBlank()) {
			throw new RuntimeException("Enter valid password");
		}
		
		return loginDao.login(username, password);
	}

	public boolean register(Student student) {
		return studentDao.addNewStudent(student);
	}
}
