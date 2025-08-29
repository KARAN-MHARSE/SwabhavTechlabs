package com.aurionpro.bms.controller;

import java.awt.desktop.AppHiddenEvent;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.services.AccountService;

@WebServlet("/ViewCustomerFormController")
public class ViewCustomerFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AccountService accountService;

	public ViewCustomerFormController() {
		super();
		AccountDao accountDao = new AccountDao();
		this.accountService = new AccountService(accountDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountNumber = request.getParameter("accountNumber");
		UserAccountDTO userAccount = accountService.getUserAccountDetailsByAccountNumber(accountNumber);

		if (userAccount == null) {
			request.setAttribute("errorMessage", "Something went wrong: Account not found");
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
			return;
		}

		request.setAttribute("userAccount", userAccount);

		request.getRequestDispatcher("/WEB-INF/views/admin/pages/ViewCustomerForm.jsp").forward(request, response);
		response.getWriter().print(userAccount);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try {
			UserAccountDTO userAccount = (UserAccountDTO) request.getAttribute("userAccount");
			String isApproved = request.getParameter("isApproved");
			String accountNumber = request.getParameter("accountNumber");

			boolean isDone = accountService.approvedOrRejectPendingAccount(accountNumber, isApproved.equals("true"));
			if (isDone) {

				PrintWriter writer = response.getWriter();
				writer.println("<script type='text/javascript'>");
				writer.println("alert('Account " + isApproved + " successfully!');");
				writer.println("window.location.href = '" + request.getContextPath() + "/AdminDashboardController';"); // redirect
																														// after
																														// alert
				writer.println("</script>");
				return;
			}
			response.getWriter().print(isApproved + accountNumber);
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
		}
	}

}
