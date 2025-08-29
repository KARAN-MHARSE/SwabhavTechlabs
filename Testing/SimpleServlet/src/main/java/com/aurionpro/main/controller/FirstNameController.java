package com.aurionpro.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstNameController
 */
@WebServlet("/FirstNameController")
public class FirstNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstNameController() {
        super();
        // TODO Auto-generated constructor stub
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
		response.setContentType("text/html");
		
		String firstName = request.getParameter("firstname");
//		Cookie cookie = new Cookie("firstname", firstName);
		HttpSession session = request.getSession();
		session.setAttribute("firstname", firstName);
		
//		response.addCookie(cookie);
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<h1> Welcome "+firstName+"</h1>");
		writer.print(
				
			"<form action='LastNameController' method='post'>"
			+ "			<label>Last Name</label>"
			+ "			<input type='text' placeholder='Lastname' name='lastname'/>"
			+ "			<button>Submit</button>"
			+ "		</form>"
				);
		
	}

}
