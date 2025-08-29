package com.aurionpro.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.main.model.Student;
import com.aurionpro.main.properties.Gender;
import com.aurionpro.main.properties.Subject;
import com.aurionpro.main.service.AuthenticationService;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationService authenticationService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
        authenticationService = new AuthenticationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		Gender gender = Gender.valueOf(request.getParameter("gender").toUpperCase());
		Subject subject = Subject.valueOf(request.getParameter("subject").toUpperCase());
		String city = request.getParameter("city");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student student = new Student(0, name, address, gender, city, subject, username, password);
		boolean isAdded = authenticationService.register(student);
		
		if (isAdded) {
		    response.getWriter().append("Added");
		} else {
		    response.getWriter().append("Something went wrong");
		}	
	}

}
