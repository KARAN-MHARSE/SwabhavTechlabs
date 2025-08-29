package com.aurionpro.bms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import com.aurionpro.bms.exceptions.DatabaseException;

public class Database {
	private static Connection connection;

	private Database() {
	}

	public static Connection getConnection() throws DatabaseException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");

				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank", "postgres",
						"Karan@06");

			} catch (ClassNotFoundException e) {
				throw new DatabaseException("Database not connected due to: " + e.getMessage());
			} catch (SQLException e) {
				throw new DatabaseException("Database not connected due to: " + e.getMessage());
			}

		}
		return connection;
	}

}
