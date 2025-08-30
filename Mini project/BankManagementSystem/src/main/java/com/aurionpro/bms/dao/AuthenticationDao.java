package com.aurionpro.bms.dao;

import java.awt.Taskbar.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import com.aurionpro.bms.database.Database;
import com.aurionpro.bms.exceptions.DatabaseException;
import com.aurionpro.bms.exceptions.InputValidatorException;
import com.aurionpro.bms.exceptions.UserNotFoundException;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.Role;

public class AuthenticationDao {
	private Connection connection;
	
	public AuthenticationDao() {
		connection = Database.getConnection();
	}
	
	public Optional<User> login(String email,String password) {
		
		String sql = "select id,name,address,mobile,adhar_no,role from users where email=? and password=? and isActive=true;";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, email);
			statement.setString(2,password);
			
			try(ResultSet result = statement.executeQuery()){
				if(!result.next()) return Optional.empty();
				
				User user = new User();
				user.setId(result.getInt("id"));
				user.setEmail(email);
				user.setName(result.getString("name"));
				user.setAddress(result.getString("address"));
				user.setAdharNo(result.getLong("adhar_no"));
				user.setMobile(result.getLong("mobile"));
				user.setRole(Role.valueOf(result.getString("role")));
				return Optional.of(user);
			}
		}
		catch (SQLException e) {
			throw new DatabaseException("Error while fetching user. ",e);
		}
	}

	
	public User register(User user) {
		String sql = "insert into users(name,address,email,mobile,adhar_no,password)"
				+ "values (?,?,?,?,?,?);";
		
		try(PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, user.getName());
			statement.setString(2, user.getAddress());
			statement.setString(3, user.getEmail());
			statement.setLong(4, user.getMobile());
			statement.setLong(5, user.getAdharNo());
			statement.setString(6, user.getPassword());
			
			int insertedRows = statement.executeUpdate();
			if(insertedRows >0) {
				try(ResultSet keys = statement.getGeneratedKeys()){
					if(keys.next()) {
						user.setId(keys.getInt(1));
					}
				}
				return user;
			}
		}
		catch (SQLException e) {
			throw new DatabaseException("Failed to add in user", e);
		}
		return  null;
	}
}
