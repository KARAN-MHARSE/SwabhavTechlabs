package com.aurionpro.bms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dao.AuthenticationDao;
import com.aurionpro.bms.models.Account;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.Role;
import com.aurionpro.bms.services.AccountService;
import com.aurionpro.bms.services.AuthenticationService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AuthenticationService authenticationService;
	private final AccountService accountService;

	public LoginController() {
		super();
		AuthenticationDao authenticationDao = new AuthenticationDao();
		AccountDao accountDao = new AccountDao();

		this.authenticationService = new AuthenticationService(authenticationDao);
		this.accountService = new AccountService(accountDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/auth/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			Optional<User> userOptional = authenticationService.login(email, password);

			if (userOptional.isEmpty()) {
				request.setAttribute("errorMessage", "Invalid email or password");
				request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
				;
				return;
			}

			User user = userOptional.get();
			HttpSession session = request.getSession();

			session.setAttribute("user", user);

			if (userOptional.get().getRole() == Role.Admin) {
				response.sendRedirect("AdminDashboardController");
				return;
			}

			List<Account> accounts = accountService.getAccountsByUserId(user.getId());

			if (accounts == null || accounts.isEmpty()) {
				response.sendRedirect("NewAccountController");
				return;
			}
			if(accounts.get(0).getAccountStatus().equals(AccountStatus.Pending)) {
				session.setAttribute("accounts", accounts);
				response.sendRedirect("PendingAccountController");
				return;
			}

			session.setAttribute("accounts", accounts);
			response.sendRedirect("CustomerDashboardController");

		} catch (Exception e) {
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);

		}
	}

}
