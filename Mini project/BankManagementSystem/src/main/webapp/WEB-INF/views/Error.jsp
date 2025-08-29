<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String message = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<style>
body {
	background-color: #f8d7da;
}

.error-container {
	margin-top: 100px;
}

.card {
	border: 2px solid #f5c6cb;
	background-color: #f8d7da;
	color: #721c24;
}

.card-header {
	font-size: 24px;
	font-weight: bold;
}

.btn-home {
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container error-container">
		<div class="card shadow-lg mx-auto" style="max-width: 500px;">
			<div class="card-header text-center">Oops! Something went wrong
			</div>
			<div class="card-body text-center">
				<p class="card-text">
					<c:out
						value="${errorMessage != null ? errorMessage : 'An unexpected error occurred while processing your request.'}" />
				</p>
				<a  class="btn btn-danger btn-home" onclick="history.back();return false;">Go
					Back </a>
			</div>
		</div>
	</div>
</body>
</html>
