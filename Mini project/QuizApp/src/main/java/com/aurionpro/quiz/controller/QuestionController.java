package com.aurionpro.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.quiz.model.Question;
import com.aurionpro.quiz.model.User;

/**
 * Servlet implementation class QuestionController
 */
@WebServlet("/QuestionController")
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public QuestionController() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("QuestionController get method");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
		   request.setAttribute("error", "user session timeout");
		   RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
		   dispatcher.forward(request, response);
		   

		}
		
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		int index = (int) session.getAttribute("index");
		int marks = (int) session.getAttribute("marks");
		

		if (index > 0) {
			String userAnswer = request.getParameter("answer");

			String rightAns = questions.get(index - 1).getRightAns();
			if (userAnswer != null && userAnswer.equalsIgnoreCase(rightAns)) {
				marks++;
			}
		}

		try {
			if (index >= questions.size()) {
				session.setAttribute("marks", marks);
				response.sendRedirect("result.jsp");
				return;
			}

			session.setAttribute("index", index + 1);
			session.setAttribute("marks", marks);

			RequestDispatcher dispatcher = request.getRequestDispatcher("question.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			try {
				response.sendRedirect("errorPage.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
