package com.aurionpro.quiz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.quiz.exceptions.DatabaseException;
import com.aurionpro.quiz.model.Question;
import com.aurionpro.quiz.model.User;
import com.aurionpro.quiz.service.AuthenticationService;
import com.aurionpro.quiz.service.QuizService;

/**
 * Servlet implementation class QuizController
 */
@WebServlet("/QuizController")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuizService quizService;

	public QuizController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		try {
			this.quizService = new QuizService();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Get from quiz");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String topic = request.getParameter("topic");

		List<Question> questions = quizService.getAllQuestionsOfTopic(topic);
		if (questions.isEmpty()) {
			response.getWriter().print("No questions found for this topic!");
			return;
		}

		HttpSession httpSession = request.getSession();

		httpSession.setAttribute("topic", topic);
		httpSession.setAttribute("questions", questions);
		httpSession.setAttribute("index", 0);
		httpSession.setAttribute("marks", 0);

		RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionController");
		dispatcher.forward(request, response);
	}

}
