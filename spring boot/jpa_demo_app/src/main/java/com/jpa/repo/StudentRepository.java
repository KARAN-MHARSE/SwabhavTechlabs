package com.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findAllByName(String name);
}
