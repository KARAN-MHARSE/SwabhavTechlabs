<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="allAccounts" value="${ userAccounts }"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Accounts</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
		<h2 class="mb-4 text-center">User Accounts</h2>

		<c:choose>
			<c:when test="${ allAccounts == null && allAccounts.isEmpty()}">
				<p>Accounts not found</p>
			</c:when>
			<c:otherwise>
				<!-- Search/Filter -->
				<form method="get" action="AdminDashboardController"
					class="row g-3 p-3 border rounded bg-light">
					<!-- Date Range -->
					<div class="col-md-3">
						<label for="startDate" class="form-label">Start Date</label> <input
							type="date" name="startDate" id="startDate" class="form-control">
					</div>
					<div class="col-md-3">
						<label for="endDate" class="form-label">End Date</label> <input
							type="date" name="endDate" id="endDate" class="form-control">
					</div>

					<!-- Account Status -->
					<div class="col-md-3">
						<label for="status" class="form-label">Status</label> <select
							name="status" id="status" class="form-select">
							<option value="">All</option>
							<option value="Approved">Approved</option>
							<option value="Pending">Pending</option>
							<option value="Rejected">Rejected</option>
						</select>
					</div>



					<!-- Account Number or Name -->
					<div class="col-md-3">
						<label for="search" class="form-label">Search Account</label> <input
							type="text" name="accountNumber" id="search" class="form-control"
							placeholder="Eg. TDCB0001">
					</div>

					<!-- Button -->
					<div class="col-md-12 text-end">
						<button type="submit" class="btn btn-primary" name="action"
							value="allaccount">Show Results</button>
						<button type="reset" class="btn btn-secondary">Reset</button>
					</div>
				</form>


				<!-- Table -->
				<table
					class="table table-striped table-bordered table-hover shadow-sm rounded">
					<thead class="table-dark">
						<tr>
							<th>Name</th>
							<th>Address</th>
							<th>Mobile</th>
							<th>Adhar</th>
							<th>Email</th>
							<th>Account Number</th>
							<th>Balance</th>
							<th>Account Status</th>
							<th>Created At</th>
							<th class="text-center">Actions</th>
						</tr>
					</thead>
					<tbody id="userTable">
						<c:forEach items="${allAccounts }" var="account">

							<tr>
								<td>${account.name}</td>
								<td>${account.address}</td>
								<td>${account.mobile}</td>
								<td>${account.adhar}</td>
								<td>${account.email}</td>
								<td>${account.accountNumber}</td>
								<td>${account.balance}</td>
								<td>${account.accountStatus}</td>
								<td>${account.createdAt}</td>
								<td class="text-center"><c:choose>
										<c:when test="${account.accountStatus eq 'Approved'}">
											<form action="UpdateAccountStatusController" method="post">
												<input type="hidden" name="accountNumber"
													value="${account.accountNumber }" /> <input type="hidden"
													name="status" value="Blocked" />
												<button class="btn btn-danger btn-sm"
													onclick="blockAccount("+ ${account.accountNumber }+")">Block</button>
											</form>
										</c:when>
										<c:otherwise>
											<form action="UpdateAccountStatusController" method="post">
												<input type="hidden" name="accountNumber"
													value="${account.accountNumber }" /> <input type="hidden"
													name="status" value="Approved" />

												<button class="btn btn-success btn-sm"
													onclick="blockAccount("+ ${account.accountNumber }+")">Approved</button>
											</form>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


			</c:otherwise>
		</c:choose>
	</div>

	<!-- JS for filter + block -->
	<script>
    // 🔎 Filter rows
    document.getElementById("searchInput").addEventListener("keyup", function() {
      let filter = this.value.toLowerCase();
      let rows = document.querySelectorAll("#userTable tr");
      rows.forEach(row => {
        let text = row.textContent.toLowerCase();
        row.style.display = text.includes(filter) ? "" : "none";
      });
    });

    // 🚫 Block account function
    function blockAccount(accountNumber) {
      if (confirm("Are you sure you want to block account " + accountNumber + "?")) {
    
      }
    }
  </script>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
