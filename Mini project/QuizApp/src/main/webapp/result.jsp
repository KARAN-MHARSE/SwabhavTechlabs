<%@page import="com.aurionpro.quiz.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Result</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
	User user = (User) session.getAttribute("user");
	if(user == null){
		throw new RuntimeException("User not found");
	}
	String topic = (String) session.getAttribute("topic");
	int marks = (int)session.getAttribute("marks");

	
%>

  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card shadow-sm">
          <div class="card-body text-center">
            <h3 class="card-title mb-4">Exam Result</h3>

            <!-- Name -->
            <p><strong>Name:</strong> <span id="name"><%= user.getName() %></span></p>

            <!-- Topic -->
            <p><strong>Topic:</strong> <span id="topic"><%= topic %></span></p>

            <!-- Marks -->
            <p><strong>Marks:</strong> <span id="marks"><%= marks %></span></p>

            <hr>
            <a href="home.jsp" class="btn btn-primary">Back to Home</a>
            <a href="LogOutController" class="btn btn-danger">LogOut</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
    