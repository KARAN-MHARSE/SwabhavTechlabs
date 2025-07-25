package com.aurionpro.basic_testing.model;

import com.aurionpro.basic_testing.interfaces.IStudentService;

public class Student {
	IStudentService studentService;
	
	public Student(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	public double averageMarks() {
		int totalSubject = studentService.getTotalSubjects();
		int totalMarks = studentService.getTotalMarks();
		
		if(totalSubject<=0 || totalMarks <0) throw new RuntimeException("Not negative value");
		
		return totalMarks/totalSubject;
	}
}
