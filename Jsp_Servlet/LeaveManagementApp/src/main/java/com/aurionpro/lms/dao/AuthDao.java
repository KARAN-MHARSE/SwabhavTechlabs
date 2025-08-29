package com.aurionpro.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.taglibs.standard.lang.jstl.EnumeratedMap;

import com.aurionpro.lms.db.Database;
import com.aurionpro.lms.model.Employee;
import com.aurionpro.lms.properties.Role;

public class AuthDao {
	private Connection connection;
	
	public AuthDao() {
		this.connection = Database.getConnection();
	}
	
	public Employee login(String email,String password) {
		if(connection == null) throw new RuntimeException("Database connection error");
		
		String sql = "select id,name,role from employee where email=? and password=?";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, email);
			statement.setString(2,password);
				
			ResultSet set = statement.executeQuery();
			if(set.next()) {
				Employee employee = new Employee();
				employee.setId(set.getInt("id"));
				employee.setName(set.getString("name"));
				employee.setEmail(email);
				employee.setRole(Role.valueOf(set.getString("role")));
				System.out.println(employee.getRole());
				
				return employee;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
