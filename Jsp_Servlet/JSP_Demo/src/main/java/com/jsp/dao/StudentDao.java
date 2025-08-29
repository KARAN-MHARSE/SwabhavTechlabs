package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.jsp.db.Database;
import com.jsp.model.Student;

public class StudentDao {
	private Connection connection;
	
	public StudentDao() {
		this.connection = Database.getConnection();
	}
	
	public List<Student> getAllStudents(){
		List< Student> students = new ArrayList();
		String sql = "select * from student;";
		
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet resultSet =  statement.executeQuery();
			while(resultSet.next()) {
				Student student = new Student();
				student.setName(resultSet.getString("name"));
				student.setUserName(resultSet.getString("username"));
				student.setPassword(resultSet.getString("password"));
				
				students.add(student);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

}
