<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="transactions" value="${transactions }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<h2 class="text-center mb-4">Transaction History</h2>

		<!--  filter -->

		<div class="card shadow-sm mb-4">
			<div class="card-body">
				<form method="get" action="AdminDashboardController">
					<div class="row g-3">
						<!-- Start Date -->
						<div class="col-md-3">
							<label for="startDate" class="form-label">Start Date</label> <input
								type="date" name="startDate" class="form-control" id="startDate">
						</div>

						<!-- End Date -->
						<div class="col-md-3">
							<label for="endDate" class="form-label">End Date</label> <input
								name="endDate" type="date" class="form-control" id="endDate">
						</div>

						<!-- Status -->
						<div class="col-md-3">
							<label for="status" class="form-label">Status</label> <select
								class="form-select" id="status" name="status">
								<option value="">All</option>
								<option value="Successfull">Successful</option>
								<option value="Failed">Failed</option>
								<option value="Pending">Pending</option>
							</select>
						</div>

						<!-- Button -->
						<div class="col-md-3 d-flex align-items-end">
							<button type="submit" class="btn btn-primary w-100" name="action"
								value="transaction">Show Transactions</button>
						</div>
					</div>
				</form>

			</div>
		</div>
		<!--  trasactions -->
		<div class="table-responsive">
			<table class="table table-striped table-bordered text-center">
				<thead class="table-dark">
					<tr>
						<th>Transaction ID</th>
						<th>Sender</th>
						<th>Receiver</th>
						<th>From Account</th>
						<th>To Account</th>
						<th>Amount (₹)</th>
						<th>Status</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${transactions }" var="transaction">
						<tr>
							<td>${transaction.transactionId }</td>
							<td>${transaction.senderName }</td>
							<td>${transaction.receiverName }</td>
							<td>${transaction.fromAccountNumber }</td>
							<td>${transaction.toAccountNumber }</td>
							<td>${transaction.amount }</td>
							<c:choose>
								<c:when test="${transaction.status  eq 'Successfull' }">
									<td><span class="badge bg-success">${transaction.status }</span></td>
								</c:when>
								<c:otherwise>
									<td><span class="badge bg-danger">${transaction.status }</span></td>

								</c:otherwise>
							</c:choose>
							<td>${transaction.createdAt }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
