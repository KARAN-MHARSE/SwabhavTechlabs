package com.aurionpro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection connection;
	
	private Database() {
		
	}
	
	public static Connection getConnection()  {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","Karan@06");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection != null) System.out.println("Connected");
		return connection;
	}

}
