<%@page import="com.aurionpro.bms.dto.UserAccountDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="pendingAccounts" value="${userAccounts}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Pending Accounts</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<h2 class="mb-4 text-center">Pending Accounts</h2>
		<c:choose>
			<c:when test="${userAccounts ==null && userAccounts.isEmpty()}">
				<p>No accounts found.</p>
			</c:when>
			<c:otherwise>
				<table
					class="table table-striped table-bordered table-hover shadow-sm rounded">
					<thead class="table-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Mobile</th>
							<th scope="col">Email</th>
							<th scope="col" class="text-center">Actions</th>
						</tr>
					<tbody>
						<c:forEach items="${userAccounts }" var="userAccount">
							
							<tr>
								<td><c:out value="${userAccount.userId }" /></td>
								<td><c:out value="${userAccount.name }" /></td>
								<td><c:out value="${userAccount.mobile }" /></td>
								<td><c:out value="${userAccount.email }" /></td>
								<td class="text-center">
									<form action="ViewCustomerFormController">
										<input type="hidden" name="accountNumber"
											value="${userAccount.accountNumber}" />
										<button class="btn btn-success btn-sm">View Form</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


			</c:otherwise>

		</c:choose>


	</div>

	<!-- Bootstrap JS (optional for interactivity like modals) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
