package com.aurionpro.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.quiz.exceptions.DatabaseException;
import com.aurionpro.quiz.model.User;
import com.aurionpro.quiz.service.AuthenticationService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationService authenticationService;

	public LoginController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		try {
			this.authenticationService = new AuthenticationService();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/login.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			User user = authenticationService.login(email, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}else {
				try(PrintWriter writer = response.getWriter()){
					writer.print("Wrong credentials");
				}
			}
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

}
