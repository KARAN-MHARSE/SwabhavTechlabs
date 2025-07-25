package com.aurionpro.basic_testing.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.aurionpro.basic_testing.interfaces.IStudentService;

class StudentTest {
	Student student;
	IStudentService studentService;
	
	@BeforeEach
	void init() {
		studentService= Mockito.mock(IStudentService.class);
		student = new Student(studentService);
	}
	

	@Test
	void testAverageMarks() {
		Mockito.when(studentService.getTotalMarks()).thenReturn(350);
		Mockito.when(studentService.getTotalSubjects()).thenReturn(-5);
//		Mockito.when(studentService.getTotalMarks()).thenThrow(Exception.class);

		
		
//		assertEquals(70, student.averageMarks());
		assertThrows(RuntimeException.class, ()-> student.averageMarks());
		
		Mockito.when(studentService.getTotalMarks()).thenReturn(400);
		Mockito.when(studentService.getTotalSubjects()).thenReturn(8);
		
		assertEquals(50, student.averageMarks());
	}

}
