ackage com.aurionpro.bms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.services.AccountService;

/**
 * Servlet implementation class TrialController
 */
@WebServlet("/TrialController")
public class TrialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrialController() {
		super();
		accountService = new AccountService(new AccountDao());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<UserAccountDTO> users = accountService.getAllUserAccounts();
		
		PrintWriter writer = response.getWriter();
		
		for(UserAccountDTO user : users) {
			writer.println("<p>"+user+"</p><br>");
			writer.print("<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I am here");
		
		request.getRequestDispatcher("AdminDashboardController").forward(request, response);
	}

}
