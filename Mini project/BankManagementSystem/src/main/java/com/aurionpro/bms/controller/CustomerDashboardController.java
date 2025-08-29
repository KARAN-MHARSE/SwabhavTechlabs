package com.aurionpro.bms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dto.TransactionDto;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.TransactionStatus;
import com.aurionpro.bms.services.AccountService;
import com.aurionpro.bms.services.TransactionService;

@WebServlet("/CustomerDashboardController")
public class CustomerDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AccountService accountService;
	private final TransactionService transactionService;

	public CustomerDashboardController() {
		super();
		AccountDao accountDao = new AccountDao();
		transactionService = new TransactionService();
		accountService = new AccountService(accountDao);
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");

			HttpSession session = request.getSession();

			User user = (User) session.getAttribute("user");
			if (action == null || action.isBlank()) {
				UserAccountDTO account = accountService.getUserAccountDetailsByUserId(user.getId());
				request.setAttribute("account", account);

				List<TransactionDto> transactions = transactionService.getTransactionsByUserId(user.getId());
				transactions = transactions.stream().limit(5).collect(Collectors.toList());
				request.setAttribute("transactions", transactions);

				request.getRequestDispatcher("/WEB-INF/views/customer/CustomerDashboard.jsp").forward(request, response);
				return;
			}
			switch (action) {
			case "profile":
				UserAccountDTO account = accountService.getUserAccountDetailsByUserId(user.getId());
				request.setAttribute("account", account);

				break;

			case "transactions":
				showTransactions(request, response);

				break;
			}
			request.getRequestDispatcher("/WEB-INF/views/customer/CustomerDashboard.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
		}
	}

	private void showTransactions(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<TransactionDto> transations = transactionService.getTransactionsByUserId(user.getId());
		
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String status = request.getParameter("status");
				
		if(startDate != null && !startDate.isBlank()) {
			LocalDate date = LocalDate.parse(startDate,DateTimeFormatter.ISO_LOCAL_DATE);
			
			transations = transations.stream()
					.filter(transaction-> {
						LocalDate localDate  = transaction.getCreatedAt().toLocalDateTime().toLocalDate();
						return localDate.isAfter(date) || localDate.isEqual(date);
					}).collect(Collectors.toList());
		}
		
		if(endDate != null && !endDate.isBlank()) {
			LocalDate date = LocalDate.parse(endDate,DateTimeFormatter.ISO_LOCAL_DATE);
			
			transations = transations.stream()
					.filter(transaction-> {
						LocalDate localDate  = transaction.getCreatedAt().toLocalDateTime().toLocalDate();
						return localDate.isBefore(date) || localDate.isEqual(date);
					}).collect(Collectors.toList());
		}
		
		if(status != null && !status.isBlank()) {
			transations = transations.stream()
					.filter(transaction-> transaction.getStatus().equals(TransactionStatus.valueOf(status)))
					.collect(Collectors.toList());
		}
		
		request.setAttribute("transactions", transations);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
