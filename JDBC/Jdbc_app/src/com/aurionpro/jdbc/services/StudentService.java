package com.aurionpro.jdbc.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.relation.RoleUnresolved;

import com.aurionpro.jdbc.database.Database;
import com.aurionpro.jdbc.exceptions.DatabaseConnectionNotFoundException;
import com.aurionpro.jdbc.exceptions.StudentNotFoundException;
import com.aurionpro.jdbc.model.Student;

public class StudentService {
	Connection connection;

	public StudentService(Connection connection) {
		if (connection == null)
			System.out.println("Not found in studentService");
		this.connection = connection;
		connection = Database.getConnection();

	}

	public void printAllStudentsData() {

		if (connection == null)
			throw new DatabaseConnectionNotFoundException();

		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet studentList = statement.executeQuery("select * from student;");

			if (studentList == null)
				throw new StudentNotFoundException("Students not found");

			while (studentList.next()) {
				System.out.println("Roll Number: " + studentList.getInt("roll_number") + "\tStudent Name: "
						+ studentList.getString("name") + "\tAge: " + studentList.getInt("age") + "\tPercentage: "
						+ studentList.getDouble("percentage"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet getStudentById(Scanner scanner) {
		System.out.println("Enter the student id");
		int studentId = scanner.nextInt();
		scanner.nextLine();

		if (studentId < 0)
			throw new RuntimeException("Enter right student id");

		try {
			Statement statement = connection.createStatement();
			String query = "select * from student where id = " + studentId;

			ResultSet studentDetails = statement.executeQuery(query);
			if (studentDetails.next())
				return studentDetails;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		throw new StudentNotFoundException();

	}

	public ResultSet getTopperStudent() {
		try {
			Statement statement = connection.createStatement();
			String query = "select * from student where percentage = (select max(percentage) from student)";

			ResultSet studentDetails = statement.executeQuery(query);
			if (studentDetails.next())
				return studentDetails;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		throw new StudentNotFoundException();
	}

	public void addNewStudent(Scanner scanner) throws SQLException {
//		System.out.println("Enter student roll number: ");
//		int rollNumber = scanner.nextInt();
//		scanner.nextLine();

//		if(rollNumber<100 ) {
//			System.out.println("ENter roll number greatter than 100");
//		}

		System.out.println("Enter student name: ");
		String name = scanner.nextLine();

		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(name);
		boolean b = m.find();

		if (name.isBlank() || b) {
			System.err.println("Enter right name and try again");
			return;
		}

		System.out.println("Enter student age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		if (age < 0 || age > 70) {
			System.err.println("Enter right age and try again.");
			return;
		}

		System.out.println("Enter student percentage ");
		double percentage = scanner.nextDouble();
		scanner.nextLine();

		if (percentage < 0 || percentage > 100) {
			System.out.println("Enter percentage greatter than 0");
			return;
		}

		Student student = new Student(name, age, percentage);

		PreparedStatement ps = connection.prepareStatement("select max(roll_number) as roll_number from student;");
		ResultSet set = ps.executeQuery();
		set.next();
		int highestRollNumber = set.getInt("roll_number");

		String query = "insert into student (roll_number,name,age,percentage) values (?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, highestRollNumber + 1);
		statement.setString(2, student.getName());
		statement.setInt(3, student.getAge());
		statement.setDouble(4, student.getPercentage());

		int rowInserted = statement.executeUpdate();
		if (rowInserted > 0) {
			System.out.println("Student details successfully inserted");
			return;
		}

		System.out.println("Something went wrong");
	}

	public void crudOperation() {
		try {
//		Select students whose age is greater than ?
			String sql1 = "select * from student where age >= ?";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, 20);
			ResultSet set = statement1.executeQuery();
			while (set.next())
				System.out.println(set.getString("name"));

//			update query
			String sql2 = "update student set age= ? where id=?";
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setInt(1, 30);
			statement2.setInt(2, 2);

			int rows1 = statement2.executeUpdate();
			if (rows1 > 0)
				System.out.println("Updated");
			else
				System.out.println("Error");

//			Delete query
			String sql3 = "Delete from student where id=?";
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			statement3.setInt(1, 2);

			int rows2 = statement3.executeUpdate();
			if (rows2 > 0)
				System.out.println("deleted");
			else
				System.out.println("Error");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void updateStudentPercentage(Scanner scanner) throws SQLException {
		System.out.println("Enter the student id");
		int studentId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the student updated percentage");
		double percentage = scanner.nextDouble();
		scanner.nextLine();

		if (percentage < 0 || percentage > 100) {
			System.out.println("Enter percentage greatter than 0");
			return;
		}

		String sql = "update student set percentage = ? where id= ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, studentId);
		statement.setDouble(2, percentage);

		int rowsAffected = statement.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Student updated succesfully");
			return;
		}

		System.err.println("Something went wrong");

	}

	public void deleteStudentById(Scanner scanner) throws SQLException {
		System.out.println("Enter the student id");
		int studentId = scanner.nextInt();
		scanner.nextLine();

		String sql = "{ call delete_student(?)}";
		CallableStatement callableStatement = connection.prepareCall(sql);
		callableStatement.setInt(1, studentId);

		callableStatement.execute();
		int rowAffected = callableStatement.getUpdateCount();
		if (rowAffected > 0) {
			System.out.println("Student deleted succesfully");
			return;
		}

		System.err.println("Student details not found");
	}

	public void addNewStudentAndProfile(Scanner scanner) throws SQLException {

		try {
			connection.setAutoCommit(false);

			System.out.println("Enter student name: ");
			String name = scanner.nextLine();

			Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(name);
			boolean b = m.find();

			if (name.isBlank() || b) {
				System.err.println("Enter right name and try again");
				return;
			}

			System.out.println("Enter student age: ");
			int age = scanner.nextInt();
			scanner.nextLine();
			if (age < 0 || age > 70) {
				System.err.println("Enter right age and try again.");
				return;
			}

			System.out.println("Enter student percentage ");
			double percentage = scanner.nextDouble();
			scanner.nextLine();
			if (percentage < 0 || percentage > 100) {
				System.out.println("Enter percentage greatter than 0");
				return;
			}
			
			System.out.println("Enter City ");
			String city = scanner.nextLine();
			if(city.isBlank()) throw new Exception("Enter city name");
			
			System.out.println("Enter mobile number ");
			int mobileNumber = scanner.nextInt();
			scanner.nextLine();
			

			Student student = new Student(name, age, percentage);
			
			PreparedStatement ps = connection.prepareStatement("select max(roll_number) as roll_number from student;");
			ResultSet set = ps.executeQuery();
			set.next();
			int highestRollNumber = set.getInt("roll_number");

			String query = "insert into student (roll_number,name,age,percentage) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, highestRollNumber + 1);
			statement.setString(2, student.getName());
			statement.setInt(3, student.getAge());
			statement.setDouble(4, student.getPercentage());
			int rowInserted = statement.executeUpdate();
			if(rowInserted < 0 ) throw new Exception("Something went wrong");

			
			String selectQeury = "select id from student  where name=?";
			PreparedStatement selectStatement = connection.prepareStatement(selectQeury);
			selectStatement.setString(1, student.getName());
			ResultSet selectResult = selectStatement.executeQuery();
			if(!selectResult.next()) throw new Exception("Student not inserted");
			int studentId = selectResult.getInt("id");
			
			
			
			String profilequery = "insert into profile (city,mobile_number,student_id) values (?,?,?)";
			PreparedStatement profileStatement = connection.prepareStatement(profilequery);
//			statement.setInt(1, 1000);
			profileStatement.setString(1, city);
			profileStatement.setLong(2, mobileNumber);
			profileStatement.setInt(3, studentId);
			rowInserted =  profileStatement.executeUpdate();

			if (rowInserted > 0) {
				System.out.println("Student details successfully inserted");
				connection.commit();
				return;
			}

			System.out.println("Something went wrong");
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("Enter write input format");
			scanner.nextLine();
		}
		catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			// TODO: handle exception
			System.err.println(e.getMessage());

		}
		finally {
			connection.setAutoCommit(true);
		}

	}
	
	public void printDataFromMetadata() {
		try {
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet tables= metaData.getTables(null, null, "%", new String[] {"TABLE"});
			while(tables.next()) {
				System.out.println(tables.getString("Table_name"));
			}
			
			ResultSet cols  = metaData.getColumns(connection.getCatalog(), null, "student", "%");
			
			ResultSetMetaData colsMetaData = cols.getMetaData();
			System.out.println("Column: "+ colsMetaData.getColumnCount());
			int columnsCount = cols.getFetchSize()-1;
//			System.out.println("Total columns: "+ columnsCount);
			while(cols.next()) {
				 String name       = cols.getString("COLUMN_NAME");
		            String type       = cols.getString("TYPE_NAME");
		            System.out.println(name +" :" +type);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public boolean isNameValid(String name) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(name);
		boolean b = m.find();

		if (name.isBlank() || b) {
			System.err.println("Enter right name and try again");
			return false;
		}
		return true;
	}

}
