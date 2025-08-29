package com.aurionpro.main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection connection;
	private static int connectionCount = 0;
	private final static String databaseUrl = "jdbc:postgresql://localhost:5432/school";
	private final static String user = "postgres";
	private final static String password= "Karan@06";
	private Database() {}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(connection == null) {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(databaseUrl,user,password);
			connectionCount++;
            System.out.println("🔵 New connection created. Total connections so far: " + connectionCount);

		}
		return connection;
	}
}
