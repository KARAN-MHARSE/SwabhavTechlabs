<%@page import="com.aurionpro.quiz.model.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quiz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
</head>
<body class="bg-light">

	<%
	String topic = (String)session.getAttribute("topic");
	List<Question> questions = (List<Question>)session.getAttribute("questions");
	int index = (int) session.getAttribute("index");
	index--;
	Question question = questions.get(index);
%>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-sm">
					<div class="card-body">
						<h4 class="card-title text-center mb-4"><%= topic %></h4>
						<form action="QuestionController" method="post">

							<!-- Question -->
							<div class="mb-3" style="display: flex; align-items: center;">
								<label style="margin-right: 5px;"><%=(index+1) %></label>
								<p class="mb-0"><%= question.getQuestion() %></p>
							</div>

							<!-- Options -->
							<div class="form-check">
								<input class="form-check-input" type="radio" name="answer"
									value=<%= question.getOption1() %> id="option1"> <label
									class="form-check-label" for="option1"> <%= question.getOption1() %>
								</label>
							</div>

							<div class="form-check">
								<input class="form-check-input" type="radio" name="answer"
									value=<%= question.getOption2() %> id="option2"> <label
									class="form-check-label" for="option2"> <%= question.getOption2() %>
								</label>
							</div>

							<div class="form-check">
								<input class="form-check-input" type="radio" name="answer"
									value=<%= question.getOption3() %> id="option3"> <label
									class="form-check-label" for="option3"> <%= question.getOption3() %>
								</label>
							</div>

							<div class="form-check">
								<input class="form-check-input" type="radio" name="answer"
									value=<%= question.getOption4() %> id="option4"> <label
									class="form-check-label" for="option4"> <%= question.getOption4() %>
								</label>
							</div>

							<!-- Next Button -->
							<button type="submit" class="btn btn-primary w-100 mt-3">Next</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>

</body>
</html>
