package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dto.StudentRequestDTO;
import com.jpa.dto.StudentResponseDTO;
import com.jpa.entity.Student;
import com.jpa.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/studentapp")
public class StudentController {

	private StudentService studentService;
	
	public StudentController( StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentResponseDTO>> readAllStudents(@RequestParam(required = false) String name){
		if(name==null || name.isBlank()) {
			return ResponseEntity.ok(studentService.readAllStudents());
		}
		return ResponseEntity.ok(studentService.readStudentByName(name));
		
	}
	
	@PostMapping("/students")
	public ResponseEntity<StudentResponseDTO> addNewStudent(@RequestBody StudentRequestDTO student) {
		return new ResponseEntity<>(studentService.addNewStudent(student),HttpStatus.CREATED);
	}
	

}
