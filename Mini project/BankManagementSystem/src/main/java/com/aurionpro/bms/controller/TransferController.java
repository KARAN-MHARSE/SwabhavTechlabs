package com.aurionpro.bms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.bms.models.Transaction;
import com.aurionpro.bms.properties.TransactionStatus;
import com.aurionpro.bms.services.TransactionService;

/**
 * Servlet implementation class TransferController
 */
@WebServlet("/TransferController")
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final TransactionService transactionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferController() {
		super();
		transactionService = new TransactionService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fromAccount = request.getParameter("fromAccount");
		String toAccount = request.getParameter("toAccount");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String remark = request.getParameter("remark");

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String contextPath = request.getContextPath();
		try {
			Transaction transaction = new Transaction(0, fromAccount, toAccount, amount, remark,
					TransactionStatus.Pending, null);
			boolean isDone = transactionService.transfer(transaction);
			if (isDone) {

				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('Money Transfer successfully');");
				writer.println("window.location.href = '" + contextPath + "/CustomerDashboardController';");
				writer.println("</script>");

			}
			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Money Transfer Failed');");
			writer.println("window.location.href = '" + contextPath + "/CustomerDashboardController';");
			writer.println("</script>");

			return;

		} catch (Exception e) {
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
		}

	}

}
