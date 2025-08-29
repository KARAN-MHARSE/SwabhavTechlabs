package com.aurionpro.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.main.service.AuthenticationService;
import com.aurionpro.main.service.StudentService;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationService loginService;
       
    
    public LoginController() {
        super();
        loginService = new AuthenticationService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		if(username.trim().equals("Karan") && password.trim().equals("1234")) {
//			writer.print("<b>Login successfull</b>");
//		}else {
//			writer.print("<b>Login Failed</b>");
//		}
		
		if(loginService.login(username, password)) {
			writer.print("<b>Login successfull</b>");
		}else {
			writer.print("<b>Login Failed</b>");

		}
		writer.close();
	}

}
