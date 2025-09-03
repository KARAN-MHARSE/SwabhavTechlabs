package com.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dto.StudentRequestDTO;
import com.jpa.dto.StudentResponseDTO;
import com.jpa.entity.Student;
import com.jpa.repo.StudentRepository;
import com.jpa.service.StudentService;
import com.jpa.utils.EntityToDto;

@Service
public class StudentServioceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServioceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentResponseDTO> readAllStudents() {
		List<Student> students =studentRepository.findAll();
		List<StudentResponseDTO> responses = new ArrayList<>();
		for(Student student : students) {
			responses.add(EntityToDto.studentToStudentResponseDTO(student));
		}
		return responses;
	}

	@Override
	public StudentResponseDTO addNewStudent(StudentRequestDTO student) {
		return EntityToDto.studentToStudentResponseDTO(studentRepository.save(EntityToDto.studentRequestToStudent(student)));
	}

	@Override
	public List<StudentResponseDTO> readStudentByName(String name) {
		List<Student> students= studentRepository.findAllByName(name);
		
		List<StudentResponseDTO> responses = new ArrayList<>();
		for(Student student : students) {
			responses.add(EntityToDto.studentToStudentResponseDTO(student));
		}
		return responses;
	}

	

}
