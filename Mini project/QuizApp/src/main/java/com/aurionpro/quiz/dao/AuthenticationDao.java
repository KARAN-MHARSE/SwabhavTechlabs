package com.aurionpro.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.xml.crypto.Data;

import com.aurionpro.quiz.database.Database;
import com.aurionpro.quiz.exceptions.DataValidationException;
import com.aurionpro.quiz.exceptions.DatabaseException;
import com.aurionpro.quiz.exceptions.UserNotFoundException;
import com.aurionpro.quiz.model.User;
import com.aurionpro.quiz.util.ResultSetConverter;

public class AuthenticationDao {
	private Connection connection;

	public AuthenticationDao() throws DatabaseException {
		this.connection = Database.getConnection();
	}

	public User login(String email, String password) throws DatabaseException {
		if (email == null || email.isBlank() || password == null || password.isBlank()) {
			throw new DataValidationException("Enter valid credentials");
		}

		String sql = "select * from users where email=?;";

		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, email);

			try (ResultSet result = statement.executeQuery();) {
				List<User> users = ResultSetConverter.toUserList(result);
				if (users == null || users.isEmpty())
					throw new UserNotFoundException();
				String dbPassword = users.get(0).getPassword();
				if (!password.equals(dbPassword))
					throw new DataValidationException("Enter valid credentials");
				return users.get(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong.");

		}
	}

}
