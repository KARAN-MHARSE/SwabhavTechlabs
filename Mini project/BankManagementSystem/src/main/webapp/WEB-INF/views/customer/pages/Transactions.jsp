<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="transactions" value="${ transactions}"></c:set>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
    background-color: #f8f9fa;
}
.search-box {
    max-width: 300px;
    margin: auto;
}
</style>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center">Transaction History</h2>

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

    <!-- 📊 Transactions Table -->
    <table class="table table-striped table-bordered table-hover shadow-sm rounded">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Sender</th>
                <th>From Account</th>
                <th>Receiver</th>
                <th>To Account</th>
                <th>Amount</th>
                <th>Message</th>
                <th>Status</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody id="transactionTable">
           <c:forEach  items="${transactions }" var="transaction">
            <tr>
                <td>${transaction.transactionId}</td>
                <td>${transaction.senderName}</td>
                <td>${transaction.fromAccountNumber}</td>
                <td>${transaction.receiverName}</td>
                <td>${transaction.toAccountNumber}</td>
                <td>${transaction.amount }</td>
                <td>${transaction.message}</td>
                <c:choose>
                <c:when test="${transaction.status eq 'Successfull' }">
                  <td><span class="badge bg-success">${transaction.status}</span></td>
                </c:when>
                <c:otherwise>
                  <td><span class="badge bg-danger">${transaction.status}</span></td>
                </c:otherwise>
                </c:choose>
              
                <td>${transaction.createdAt}</td>
            </tr>
           </c:forEach>
            
        </tbody>
    </table>
    
</div>

<!-- 🔎 JS for search filter -->
<script>
document.getElementById("searchInput").addEventListener("keyup", function() {
  let filter = this.value.toLowerCase();
  let rows = document.querySelectorAll("#transactionTable tr");
  rows.forEach(row => {
    let text = row.textContent.toLowerCase();
    row.style.display = text.includes(filter) ? "" : "none";
  });
});
</script>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
