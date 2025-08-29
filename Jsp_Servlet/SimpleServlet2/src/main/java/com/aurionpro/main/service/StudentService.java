package com.aurionpro.main.service;

import java.util.List;

import com.aurionpro.main.dao.StudentDao;
import com.aurionpro.main.model.Student;

public class StudentService {
	private  StudentDao studentDao;
	
	public StudentService() {
		studentDao = new StudentDao();
	}
	
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
	
//	public boolean addNewStudent(Student student) {
//		
//	}
}
