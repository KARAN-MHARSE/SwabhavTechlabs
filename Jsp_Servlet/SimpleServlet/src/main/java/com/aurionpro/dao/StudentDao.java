package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.database.Database;
import com.aurionpro.model.Student;

public class StudentDao {
	Connection connection;

	public StudentDao() {
		connection = Database.getConnection();
	}
	
	
	public  List<Student> getAllStudent(){
		String sql = "selectc * from student";
		List<Student> students = new ArrayList();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			
			
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String address = set.getString("address");
				String  gender = set.getString("gender");
				
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setAddress(address);
//				student.setGender();'
				
				students.add(student);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return students;
	}
}

