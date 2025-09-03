package com.aurionpro.bms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.text.DateFormatter;
import javax.websocket.Session;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dao.TransactionDao;
import com.aurionpro.bms.dto.TransactionDto;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.models.Account;
import com.aurionpro.bms.models.Document;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.AccountType;
import com.aurionpro.bms.properties.DocumentType;
import com.aurionpro.bms.properties.Gender;
import com.aurionpro.bms.properties.Role;
import com.aurionpro.bms.properties.TransactionStatus;
import com.aurionpro.bms.services.AccountService;
import com.aurionpro.bms.services.TransactionService;

/**
 * Servlet implementation class AdminDashboardController
 */
@WebServlet("/AdminDashboardController")
@MultipartConfig
public class AdminDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AccountDao accountDao;
	private final AccountService accountService;
	private final TransactionService transactionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDashboardController() {
		super();
		accountDao = new AccountDao();
		this.transactionService = new TransactionService();
		this.accountService = new AccountService(accountDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if (action == null || action.isEmpty()) {
				request.setAttribute("stats", accountService.getStats());
				action = "home"; // default
			}
			switch (action) {
			case "pendingrequests":
				List<UserAccountDTO> pendingAccounts = new ArrayList<>();
				pendingAccounts = accountDao.getAllPendingAccounts();

				request.setAttribute("userAccounts", pendingAccounts);
				break;
			case "allaccount":
				showAllAccounts(request, response);
				break;
			case "transaction":
				showTransactions(request, response);
				break;
			default:
				request.setAttribute("stats", accountService.getStats());
				break;
			}
			request.getRequestDispatcher("/WEB-INF/views/admin/AdminDashboard.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			System.out.println(action);

			switch (action) {
			case "createAccount":
				createNewAccount(request, response);
				break;
			case "credit":
				credit(request, response);
				break;
			case "debit":
				debit(request, response);
				break;
			case "getUserByAccountNumber":
				System.out.println("getUserById");
				getUserByAccountNumber(request, response);
				break;
			case "updateUserProfile":
				updateUserProfile(request,response);
				return;
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
		}

	}

	private void updateUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String accountNumber = request.getParameter("accountNumber");
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			AccountStatus accountStatus = AccountStatus.valueOf(request.getParameter("accountStatus"));
			
			UserAccountDTO userAccountDTO = new UserAccountDTO();
			userAccountDTO.setUserId(userId);
			userAccountDTO.setAccountNumber(accountNumber);
			userAccountDTO.setName(name);
			userAccountDTO.setAddress(address);
			userAccountDTO.setAccountStatus(accountStatus);
			
			boolean isUpdated = accountService.updateUserProfile(userAccountDTO);
			PrintWriter writer;
			if(isUpdated) {
				writer = response.getWriter();
				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Profile successfully! updated');");
				writer.println("window.location.href='" + request.getHeader("Referer") + "';");
				writer.println("</script>");
			}else {
				writer = response.getWriter();
				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Profile updation failed');");
				writer.println("window.location.href='" + request.getHeader("Referer") + "';");
				writer.println("</script>");

			}
		}catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);

		}
		
	}

	private void getUserByAccountNumber(HttpServletRequest request, HttpServletResponse response) {
		String accountNumber = request.getParameter("accountNumber");
		UserAccountDTO userAccount = accountService.getUserAccountDetailsByAccountNumber(accountNumber);
		request.setAttribute("userAccount", userAccount);

		try {
			request.getRequestDispatcher("/WEB-INF/views/admin/AdminDashboard.jsp?action=updateuserprofile").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void debit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String accountNumber = request.getParameter("accountNumber");
			double amount = Double.parseDouble(request.getParameter("amount"));
			String message = request.getParameter("message");

			boolean isDone = transactionService.debit(accountNumber, amount, message);
			if (!isDone)
				throw new RuntimeException("Something went wrong");

			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Amount debited successfully!');");
				writer.println("window.location.href='" + request.getHeader("Referer") + "';");
				writer.println("</script>");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);

		}

	}

	private void credit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String accountNumber = request.getParameter("accountNumber");
			double amount = Double.parseDouble(request.getParameter("amount"));
			String message = request.getParameter("message");

			boolean isDone = transactionService.credit(accountNumber, amount, message);
			if (!isDone)
				throw new RuntimeException("Something went wrong");

			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Amount credited successfully!');");
				writer.println("window.location.href='" + request.getHeader("Referer") + "';");
				writer.println("</script>");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);

		}

	}

	private void createNewAccount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		System.out.println(name);
		String address = request.getParameter("address");

		String genderParam= request.getParameter("gender");
		Gender gender = Gender.Male;
		if (genderParam != null && !genderParam.isEmpty()) {
			gender = Gender.valueOf(genderParam);
		}

		String mobile = request.getParameter("mobile");
		String adhar = request.getParameter("adhar");
		String pan = request.getParameter("pan");
		String email = request.getParameter("email");
		String balance = request.getParameter("balance");
		Part aadharFile = request.getPart("aadharFile");
		Part panFile = request.getPart("panFile");
		System.out.println(mobile + adhar + pan + email + balance);

		User user = new User(0, name, gender, address, email, Long.parseLong(mobile), Long.parseLong(adhar), pan,
				Role.Customer, name, null);
		List<Document> documents = new ArrayList<>();

		byte[] adharBytes = null;
		try (InputStream inputStream = aadharFile.getInputStream()) {
			adharBytes = inputStream.readAllBytes();
		}
		byte[] panBytes = null;
		try (InputStream inputStream = panFile.getInputStream()) {
			panBytes = inputStream.readAllBytes();
		}
		Account account = new Account(0, 0, null, AccountType.Saving, Double.parseDouble(balance),
				AccountStatus.Approved, null);

		Document adharDocument = new Document(0, 0, adharBytes, aadharFile.getSubmittedFileName(), DocumentType.Adhar,
				null);
		documents.add(adharDocument);

		Document panDocument = new Document(0, 0, panBytes, panFile.getSubmittedFileName(), DocumentType.Pan, null);
		documents.add(panDocument);

		UserAccountDTO userAccountDTO = new UserAccountDTO(user, account, documents);

		accountService.createNewUserAccount(userAccountDTO);

		PrintWriter writer= response.getWriter();
		writer.println("<script type=\"text/javascript\">");
		writer.println("alert('Account created successfully!');");
		writer.println("window.location.href='" + request.getHeader("Referer") + "';");
		writer.println("</script>");
	}

	private void showAllAccounts(HttpServletRequest request, HttpServletResponse response) {
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		String statusStr = request.getParameter("status");
		String accountNumber = request.getParameter("accountNumber");

		List<UserAccountDTO> allAccounts = new ArrayList<>();
		allAccounts = accountDao.getAllUserAccounts();

		if (startDateStr != null && !startDateStr.isBlank()) {
			LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
			allAccounts = allAccounts.stream().filter(account -> {
				LocalDate date = account.getCreatedAt().toLocalDateTime().toLocalDate();
				return date.isAfter(startDate) || date.equals(startDate);

			}).collect(Collectors.toList());
		}

		if (endDateStr != null && !endDateStr.isBlank()) {
			LocalDate endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
			allAccounts = allAccounts.stream().filter(account -> {
				LocalDate date = account.getCreatedAt().toLocalDateTime().toLocalDate();
				return date.isBefore(endDate) || date.equals(endDate);

			}).collect(Collectors.toList());
		}

		if (statusStr != null && !statusStr.isBlank()) {
			allAccounts = allAccounts.stream()
					.filter(account -> account.getAccountStatus().equals(AccountStatus.valueOf(statusStr)))
					.collect(Collectors.toList());
		}

		if (accountNumber != null && !accountNumber.isBlank()) {
			allAccounts = allAccounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber))
					.collect(Collectors.toList());
		}

		request.setAttribute("userAccounts", allAccounts);

	}

	private void showTransactions(HttpServletRequest request, HttpServletResponse response) {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String status = request.getParameter("status");

		List<TransactionDto> transations = new ArrayList<>();
		transations = transactionService.getAllTransaction();

		if (startDate != null && !startDate.isBlank()) {
			LocalDate date = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);

			transations = transations.stream().filter(transaction -> {
				LocalDate localDate = transaction.getCreatedAt().toLocalDateTime().toLocalDate();
				return localDate.isAfter(date) || localDate.isEqual(date);
			}).collect(Collectors.toList());
		}

		if (endDate != null && !endDate.isBlank()) {
			LocalDate date = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);

			transations = transations.stream().filter(transaction -> {
				LocalDate localDate = transaction.getCreatedAt().toLocalDateTime().toLocalDate();
				return localDate.isBefore(date) || localDate.isEqual(date);
			}).collect(Collectors.toList());
		}

		if (status != null && !status.isBlank()) {
			transations = transations.stream()
					.filter(transaction -> transaction.getStatus().equals(TransactionStatus.valueOf(status)))
					.collect(Collectors.toList());
		}

		request.setAttribute("transactions", transations);

	}

}
