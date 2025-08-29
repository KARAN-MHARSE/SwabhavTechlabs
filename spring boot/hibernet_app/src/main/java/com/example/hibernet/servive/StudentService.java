package com.example.hibernet.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hibernet.dao.StudentDao;
import com.example.hibernet.entity.Student;

public interface StudentService {
	public List<Student> readAllStudents();
	public Student addNewStudent(Student student);
	public Student getStudentById(int studentId);

}
