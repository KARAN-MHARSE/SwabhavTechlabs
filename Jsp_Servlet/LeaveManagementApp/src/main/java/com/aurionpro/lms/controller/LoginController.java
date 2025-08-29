package com.aurionpro.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.aurionpro.lms.model.Employee;
import com.aurionpro.lms.service.AuthService;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		RequestDispatcher dispatcher = null;

		if (email == null || email.isBlank() || password == null || password.isBlank()) {
			dispatcher = request.getRequestDispatcher("error.jsp");

		}

		try {
			Employee employee = authService.login(email, password);
			if (employee == null) {
				dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);

				return;
			}

			HttpSession session = request.getSession();
			session.setAttribute("employee", employee);

			if (employee.getRole().toString().equalsIgnoreCase("Employee")) {
				response.sendRedirect("EmployeeLeaveController");
				return;
			}

			response.sendRedirect("AdminLeaveController");
			return;
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			dispatcher = request.getRequestDispatcher("error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				throw new RuntimeException(e.getMessage());
			}
		}

	}

}
