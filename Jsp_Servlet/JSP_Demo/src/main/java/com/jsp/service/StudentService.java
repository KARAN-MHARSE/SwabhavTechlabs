package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.model.Student;

public class StudentService {
	private StudentDao studentDao;
	
	public StudentService() {
		this.studentDao = new StudentDao();
	}
	
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}

}
