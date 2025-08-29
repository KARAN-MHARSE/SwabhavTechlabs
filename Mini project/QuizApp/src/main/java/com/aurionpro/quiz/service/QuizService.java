package com.aurionpro.quiz.service;

import java.util.List;

import com.aurionpro.quiz.dao.QuizDao;
import com.aurionpro.quiz.exceptions.DatabaseException;
import com.aurionpro.quiz.model.Question;

public class QuizService {
	private QuizDao quizDao;
	
	public QuizService() throws DatabaseException {
		this.quizDao = new QuizDao();
	}
	
	public List<Question> getAllQuestionsOfTopic(String topic){
		return quizDao.getAllQuestionsOfTopic(topic);
	}

}
