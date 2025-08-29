package com.aurionpro.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import com.aurionpro.main.database.Database;

public class AuthenticationDao {
	private Connection connection;
	
	public AuthenticationDao() {
		try {
			this.connection = Database.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String username,String password) {
		String sql = "select * from student where username=? and password = ?;";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) return true;
			return false;
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
