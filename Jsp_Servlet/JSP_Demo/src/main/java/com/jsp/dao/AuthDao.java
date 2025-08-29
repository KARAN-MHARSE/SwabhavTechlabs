package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.db.Database;
import com.jsp.model.Student;

public class AuthDao {
	private Connection connection;
	
	public AuthDao() {
		this.connection = Database.getConnection();
	}
	
	public boolean login(Student student) {
		if(student == null) return false;
		
		String sql  = "select 1 from student where username=? and password=?";
		ResultSet result;
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, student.getUserName());
			statement.setString(2,student.getPassword());
			
			result = statement.executeQuery();
			if(result.next()) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
