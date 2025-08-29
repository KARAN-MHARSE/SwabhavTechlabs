package com.example.hibernet.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernet.dao.StudentDao;
import com.example.hibernet.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> readAllStudents() {
		return studentDao.readAllStudents();
	}

	@Override
	public Student addNewStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addNewStudent(student);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.ReadStudentById(studentId);
	}

}
