package com.aurionpro.bms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.text.StyledDocument;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.models.Document;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.AccountType;
import com.aurionpro.bms.properties.DocumentType;
import com.aurionpro.bms.properties.Role;
import com.aurionpro.bms.services.AccountService;

/**
 * Servlet implementation class NewAccountController
 */
@WebServlet("/NewAccountController")
@MultipartConfig
public class NewAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AccountService accountService;
       

    public NewAccountController() {
        super();
        AccountDao accountDao = new AccountDao();
        this.accountService = new AccountService(accountDao);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/customer/NewAccount.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			
			Long adharNo = Long.parseLong(request.getParameter("adharNo"));
			String panNo = request.getParameter("panNo");
			String accountType = request.getParameter("accountType");
			double deposit = Double.parseDouble(request.getParameter("initialDeposit"));
			String terms = request.getParameter("agree");
			Part adharDoc = request.getPart("adharDoc");
			Part panDoc = request.getPart("panDoc");
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println(user);
			int userId = user.getId();
			
			List<Document> documents = new ArrayList<>();
			
			byte[] adharBytes = null;
			try(InputStream inputStream = adharDoc.getInputStream()){
				adharBytes = inputStream.readAllBytes();
			}
			Document adharDocument = new Document();
			adharDocument.setFile(adharBytes);
			adharDocument.setName(adharDoc.getSubmittedFileName());
			adharDocument.setType(DocumentType.Adhar);
			adharDocument.setUserId(userId);
			
			documents.add(adharDocument);
			
			byte[] panBytes = null;
			try(InputStream inputStream = panDoc.getInputStream()){
				panBytes = inputStream.readAllBytes();
			}
			
			Document panDocument = new Document();
			panDocument.setFile(panBytes);
			panDocument.setName(panDoc.getSubmittedFileName());
			panDocument.setType(DocumentType.Pan);
			panDocument.setUserId(userId);
			
			documents.add(panDocument);		

			if (terms != null && terms.equals("accepted")) {
				boolean isSend = accountService.requestForNewAccount(userId, adharNo, panNo, AccountType.valueOf(accountType), documents);
				if(isSend) {
					String contextPath = request.getContextPath();
					PrintWriter writer = response.getWriter();
					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('Request raised  successfully');");
					writer.println("window.location.href = '" + contextPath + "/LoginController';");
					writer.println("</script>");	
				}
				else {
					String contextPath = request.getContextPath();
					PrintWriter writer = response.getWriter();
					writer.println("<script type=\"text/javascript\">");
					writer.println("alert('Request raised failed');");
					writer.println("window.location.href = '" + contextPath + "/LoginController';");
					writer.println("</script>");
				}
			} else {
				String contextPath = request.getContextPath();
				PrintWriter writer = response.getWriter();
				writer.println("<script type=\"text/javascript\">");
				writer.println("alert('terms accept please');");
				writer.println("window.location.href = '" + contextPath + "/LoginController';");
				writer.println("</script>");
			}

		}
		catch (Exception e) {
			request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
		}
//		User newUser = new User(0, name, address, email, mobile, adhar, Role.Customer, password, null);
		
	}

}
