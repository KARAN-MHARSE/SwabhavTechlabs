package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.model.Student;
import com.jsp.service.AuthService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService authService;
       
    
    public LoginController() {
        super();
        authService = new AuthService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append("get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student student = new Student();
		student.setUserName(username);
		student.setPassword(password);
		
		RequestDispatcher dispatcher = null;
		
		if(authService.login(student)) {
			dispatcher = request.getRequestDispatcher("StudentController");
		}else {
			dispatcher = request.getRequestDispatcher("Error.jsp");
		}
		dispatcher.forward(request, response);
		
	}

}
