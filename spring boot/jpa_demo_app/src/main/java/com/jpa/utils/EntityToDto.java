package com.jpa.utils;

import java.util.List;

import com.jpa.dto.StudentRequestDTO;
import com.jpa.dto.StudentResponseDTO;
import com.jpa.entity.Student;

public class EntityToDto {
	
	public static StudentResponseDTO studentToStudentResponseDTO(Student student) {
		StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
		studentResponseDTO.setId(student.getId());
		studentResponseDTO.setName(student.getName());
		studentResponseDTO.setAge(student.getAge());
		studentResponseDTO.setEmail(student.getEmail());
		studentResponseDTO.setRollNumber(student.getRollNumber());
		
		return studentResponseDTO;
	}
	
	public static Student studentRequestToStudent(StudentRequestDTO studentRequest) {
		Student  student = new Student();
		
		student.setName(studentRequest.getName());
		student.setAge(studentRequest.getAge());
		student.setEmail(studentRequest.getEmail());
		student.setRollNumber(studentRequest.getRollNumber());
		student.setPassword(studentRequest.getPassword());
		
		return student;
	}

}
 