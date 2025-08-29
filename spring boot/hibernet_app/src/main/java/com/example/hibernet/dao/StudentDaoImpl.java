package com.example.hibernet.dao;

import java.util.List;

import org.hibernate.engine.spi.Managed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernet.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Student> readAllStudents() {
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s",Student.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Student addNewStudent(Student student) {
		return entityManager.merge(student);
	}

	@Override
	public Student ReadStudentById(int studentId) {
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s where id=:studentId",Student.class);
		query.setParameter("studentId", studentId);
		return query.getSingleResult();
	}
	
}
