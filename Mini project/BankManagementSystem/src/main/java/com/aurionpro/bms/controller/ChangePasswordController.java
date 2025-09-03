package com.aurionpro.bms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dao.AuthenticationDao;
import com.aurionpro.bms.services.AccountService;
import com.aurionpro.bms.services.AuthenticationService;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private final AuthenticationService authenticationService;
	private static final long serialVersionUID = 1L;
       
  
    public ChangePasswordController() {
        super();
        this.authenticationService = new AuthenticationService(new AuthenticationDao());
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			int userId = Integer.parseInt( request.getParameter("userId"));
			boolean isChanged = authenticationService.changePassword(userId,oldPassword,newPassword);
			if(!isChanged) throw new RuntimeException("Something went wrong");
			
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			
			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Password successfully updated');");
			writer.println("window.location.href='" + request.getHeader("Referer") + "';");
			writer.println("</script>");
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			try {
				request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
