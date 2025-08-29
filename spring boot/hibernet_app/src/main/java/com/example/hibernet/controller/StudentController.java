package com.example.hibernet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernet.entity.Student;
import com.example.hibernet.servive.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> readAllStudents(){
		return studentService.readAllStudents();
	}
	
	@PostMapping("/students")
	public Student addNewStudent(@RequestBody Student student) {
		return studentService.addNewStudent(student);
	}
	

	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return studentService.getStudentById(studentId);
	}



}
