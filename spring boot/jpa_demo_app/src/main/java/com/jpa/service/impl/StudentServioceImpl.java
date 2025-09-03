package com.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper mapper;
	
//	public StudentServioceImpl(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
////		this.mapper = mapper;
//	}
	

	@Override
	public List<StudentResponseDTO> readAllStudents() {
		List<Student> students =studentRepository.findAll();
		List<StudentResponseDTO> responses = new ArrayList<>();
		for(Student student : students) {
			responses.add(mapper.map(student, StudentResponseDTO.class));
		}
		return responses;
	}

	@Override
	public StudentResponseDTO addNewStudent(StudentRequestDTO student) {
		return mapper.map(studentRepository.save(mapper.map(student, Student.class)),StudentResponseDTO.class);
	}

	@Override
	public List<StudentResponseDTO> readStudentByName(String name) {
		List<Student> students= studentRepository.findAllByName(name);
		
		List<StudentResponseDTO> responses = new ArrayList<>();
		for(Student student : students) {
			responses.add(mapper.map(student, StudentResponseDTO.class));
		}
		return responses;
	}

	

}
