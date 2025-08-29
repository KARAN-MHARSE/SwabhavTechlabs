<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All students data</title>
</head>
<body>
	<c:set var="studentsList" value="${students}"></c:set>

	<div>
		<h1>Student list</h1>
	</div>
	<c:choose>
		<c:when test="${studentsList==null || studentsList.isEmpty() }">
			<h1>Students not found</h1>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Student name</th>
					<th>Student username</th>
					<th>Student password</th>
				</tr>
				<c:forEach items="${studentsList}" var="student">
					<tr>
						<td>${student.name}</td>
						<td>${student.userName}</td>
						<td>${student.password}</td>
					</tr>

				</c:forEach>

			</table>

		</c:otherwise>

	</c:choose>

</body>
</html>