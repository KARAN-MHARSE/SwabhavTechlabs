
package com.aurionpro.quiz.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aurionpro.quiz.model.Question;
import com.aurionpro.quiz.model.User;
import com.aurionpro.quiz.properties.Role;

public class ResultSetConverter {

	public static List<User> toUserList(ResultSet resultSet) throws SQLException {
		List<User> list = new ArrayList<>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			Role role = Role.valueOf(resultSet.getString("role"));
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");

			User user = new User(id, name, role, email, password);
			list.add(user);

		}

		return list;

	}

	public static List<Question> toQuestionsList(ResultSet resultSet) {
	    List<Question> questions = new ArrayList<>();
	    try {
	        while (resultSet.next()) {
	            Question q = new Question();
	            q.setId(resultSet.getInt("id"));
	            q.setQuestion(resultSet.getString("question"));
	            q.setOption1(resultSet.getString("option1"));
	            q.setOption2(resultSet.getString("option2"));
	            q.setOption3(resultSet.getString("option3"));
	            q.setOption4(resultSet.getString("option4"));
	            q.setRightAns(resultSet.getString("right_ans"));
	            q.setTopicId(resultSet.getInt("topic_id"));
	            questions.add(q);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return questions;
	}

}
