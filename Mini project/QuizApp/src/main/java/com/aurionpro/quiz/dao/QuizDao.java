package com.aurionpro.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.aurionpro.quiz.database.Database;
import com.aurionpro.quiz.exceptions.DatabaseException;
import com.aurionpro.quiz.model.Question;
import com.aurionpro.quiz.model.Topic;
import com.aurionpro.quiz.util.ResultSetConverter;

public class QuizDao {
	private Connection connection;
	
	public QuizDao() throws DatabaseException {
		this.connection = Database.getConnection();
	}
	
	public List<Question> getAllQuestionsOfTopic(String topic){
		List< Question> questions = new ArrayList();
		
		String sql = "select * from question where topic_id = (select id from topic where name=?);";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, topic);
			
			try(ResultSet resultSet = statement.executeQuery()){
				questions = ResultSetConverter.toQuestionsList(resultSet);
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
		
	}

}
