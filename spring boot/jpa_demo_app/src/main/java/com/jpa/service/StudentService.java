package com.jpa.service;

import java.util.List;

import com.jpa.dto.StudentRequestDTO;
import com.jpa.dto.StudentResponseDTO;
import com.jpa.entity.Student;

public interface StudentService {

	public List<StudentResponseDTO> readAllStudents();
	
	public StudentResponseDTO addNewStudent(StudentRequestDTO student);
	
	public List<StudentResponseDTO> readStudentByName(String name);
}
