package com.aurionpro.lms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection connection;
	
	private Database() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LeaveManagementSystem", "postgres",
						"Karan@06");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
