package com.example.hibernet.dao;

import java.util.List;

import com.example.hibernet.entity.Student;

public interface StudentDao {
	public List<Student> readAllStudents();
	
	public Student addNewStudent(Student student);
	
	public Student ReadStudentById(int studentId);

}
