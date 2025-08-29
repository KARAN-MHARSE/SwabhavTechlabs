package com.aurionpro.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.main.model.Student;
import com.aurionpro.main.properties.Gender;
import com.aurionpro.main.properties.Subject;
import com.aurionpro.main.service.StudentService;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;

    public StudentController() {
        super();
        studentService = new StudentService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		List<Student> students = studentService.getAllStudents();
		
		writer.print("<b>Student List</b>");
		writer.print("<table  border='1' cellpadding='5' cellspacing='0'>"
				+ "		<tr>"
				+ "			<th>ID</th>"
				+ "			<th>Name</th>"
				+ "			<th>Gender</th>"
				+ "			<th>City</th>"
				+ "			<th>Subject</th>"
				+ "		</tr");
		
		for(Student student : students) {
//			System.out.println(student.getGender().toString());
			writer.print("		<tr>"
					+ "			<td>" +student.getStudentId() + "</td>"
					+ "			<td>" +student.getName() + "</td>"
					+ "			<td>" +student.getGender().toString() + "</td>"
					+ "			<td>" +student.getCity() + "City</td>"
					+ "			<td>" +student.getSubject().toString() + "</td>"
					+ "		</tr>");
		}
		
		 writer.println("</table>");
		 writer.close();
		
		
		
		
		
	}

	/**	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
