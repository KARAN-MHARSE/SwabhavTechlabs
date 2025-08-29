package com.aurionpro.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.main.database.Database;
import com.aurionpro.main.model.Student;
import com.aurionpro.main.properties.Gender;
import com.aurionpro.main.properties.Subject;

public class StudentDao {
	private Connection connection;
	
	public StudentDao()  {
		try {
			connection = Database.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudents(){
		String sql = "select * from student;";
		List<Student> students = new ArrayList<Student>();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				int studentId = result.getInt("id");
				String name = result.getString("name");
				String address = result.getString("address");
				Gender gender = Gender.valueOf(result.getString("gender").toUpperCase());
				String City = result.getString("city");
				Subject subject = Subject.valueOf(result.getString("subject").toUpperCase());
				String username = result.getString("username");
				String password = result.getString("password");
				
				Student student = new Student(studentId, name, address, null, City, null, username, password);
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

	public boolean addNewStudent(Student student) {
		String sql = "insert into student (name,address,gender,city,subject,username,password) values (?,?,?,?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, student.getName());
			statement.setString(2, student.getAddress());
			statement.setString(3, student.getGender().toString());
			statement.setString(4, student.getCity());
			statement.setString(5, student.getSubject().toString());
			statement.setString(6, student.getUserName());
			statement.setString(7, student.getPassword());
			
			int affectedRows = statement.executeUpdate();
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
