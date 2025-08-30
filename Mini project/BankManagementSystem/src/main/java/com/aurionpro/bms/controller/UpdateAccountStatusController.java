package com.aurionpro.bms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.services.AccountService;

/**
 * Servlet implementation class BlockCustomerAccount
 */
@WebServlet("/UpdateAccountStatusController")
public class UpdateAccountStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountStatusController() {
        super();
        this.accountService = new AccountService(new AccountDao());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			
			String accountNumber = request.getParameter("accountNumber");
			String accountStatus = request.getParameter("status");
			
			boolean isAccountBlocked =  accountService.blockAccount(accountNumber,accountStatus);
			
			if(isAccountBlocked) {
				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('" + accountNumber + " "+ accountStatus+ "successfully');");
				writer.println("window.location.href = '" + request.getContextPath() + "/AdminDashboardController';");
				writer.println("</script>");
				return ;
			}
			
			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('" + accountNumber + " "+ accountStatus+" failed');");
			writer.println("window.location.href = '" + request.getContextPath() + "/AdminDashboardController';");
			writer.println("</script>");
		}
		catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
		}
	}

}
