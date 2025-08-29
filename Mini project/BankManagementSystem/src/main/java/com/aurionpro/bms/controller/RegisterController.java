package com.aurionpro.bms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.bms.dao.AuthenticationDao;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.Gender;
import com.aurionpro.bms.properties.Role;
import com.aurionpro.bms.services.AuthenticationService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AuthenticationService authenticationService;

	public RegisterController() {
		super();
		AuthenticationDao authenticationDao = new AuthenticationDao();
		this.authenticationService = new AuthenticationService(authenticationDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/auth/Register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			Gender gender = Gender.valueOf(request.getParameter("gender"));
			Long adharNo = Long.parseLong(request.getParameter("adhar"));
			Long mobile = Long.parseLong(request.getParameter("mobile"));
			String password = request.getParameter("password");

			User user = new User(0, name, gender, address, email, mobile, adharNo, email, null, password, null);
			User registerUser = authenticationService.register(user);
			if (registerUser == null) {
				request.setAttribute("errorMessage", "Something went wrong while register");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);
				return;
			}

			HttpSession session = request.getSession();
			session.setAttribute("user", registerUser);
			response.sendRedirect("NewAccountController");
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", "Invalid input: " + e.getMessage());
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}

	}

}
