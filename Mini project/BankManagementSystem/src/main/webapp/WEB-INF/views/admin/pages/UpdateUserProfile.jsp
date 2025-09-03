<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="userAccount" value="${userAccount }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Profile Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background: #f0f2f5;
}

.card {
	border-radius: 15px;
	padding: 15px;
}

.card-header {
	border-radius: 15px 15px 0 0;
}

.profile-label {
	font-weight: 600;
	color: #555;
}
</style>


</head>
<body>
	<div class="container mt-5">
		<!--  Get User Details first-->
		<c:choose>
			<c:when test="${userAccount == null }">
				<div class="card shadow-lg">
	<div class="card-header bg-primary text-white">
		<h4 class="mb-0">Get User Details</h4>
	</div>
	<div class="card-body">

		<form action="AdminDashboardController" method="post">
			<input type="hidden" name="action" value="getUserByAccountNumber" />

			<div class="row mb-3">
				<div class="col-md-6">
					<label class="profile-label">User Account Number</label>
					<input type="text" class="form-control" name="accountNumber" placeholder="Enter User account number" required>
				</div>
			</div>

			<div class="text-center mt-4">
				<button type="submit" class="btn btn-success px-4">Get User Details</button>
				<button type="reset" class="btn btn-secondary px-4">Reset</button>
			</div>
		</form>

	</div>
</div>

			</c:when>
			<c:otherwise>
				<div class="card shadow-lg">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">User Profile Form</h4>
					</div>
					<div class="card-body">

						<form method="post" action="AdminDashboardController" 
							enctype="multipart/form-data">
							<input type="hidden" name="action" value="updateUserProfile">

							<!-- Personal Info -->
							<h5 class="mb-3">Personal Information</h5>
							<div class="row mb-3">
								<div class="col-md-6">
									<label class="profile-label">User ID</label> <input type="text"
										class="form-control" name="userId"
										value=${userAccount.userId } readonly> <label
										class="profile-label mt-2">Full Name</label> <input
										type="text" minLength=5 class="form-control" name="name"
										value="${userAccount.name}" required> <label
										class="profile-label mt-2">Gender</label> <label
										class="form-control" name="gender" required> <input
										type="text" class="form-control" name="gender"
										value="${userAccount.gender.toString()}" required readOnly>
										<label class="profile-label mt-2">Mobile</label> <input
										type="text" class="form-control" name="mobile"
										value="${userAccount.mobile}" readonly>
								</div>
								<div class="col-md-6">
									<label class="profile-label">Address</label> <input type="text" minLength=4
										class="form-control" name="address"
										value="${userAccount.address}" required> <label
										class="profile-label mt-2">Email</label> <input type="email" minLength=7
										class="form-control" name="email" value="${userAccount.email}">
									<label class="profile-label mt-2" readOnly>Aadhar No</label> <input
										type="text" class="form-control" name="adhar"
										value="${userAccount.adhar}" required readonly> <label
										class="profile-label mt-2">PAN No</label> <input type="text"
										class="form-control" name="pan" value="${userAccount.pan}"
										readonly readonly>
								</div>
							</div>

							<!-- Account Info -->
							<h5 class="mb-3 mt-4">Account Information</h5>
							<div class="row mb-3">
								<div class="col-md-6">
									<label class="profile-label">Account ID</label> <input
										type="text" class="form-control" name="accountId"
										value="${userAccount.accountId}" readonly required> <label
										class="profile-label mt-2">Account Number</label> <input
										type="text" class="form-control" name="accountNumber"
										value="${userAccount.accountNumber}" required readOnly>

									<label class="profile-label mt-2">Balance</label> <input
										type="number" step="0.01" class="form-control" name="balance"
										value="${userAccount.balance}" required readonly>
								</div>
								<div class="col-md-6">
									<label class="profile-label mt-2">Account status</label> <select
										class="form-control" name="accountStatus" required>
										<option value="${userAccount.accountStatus}">${userAccount.accountStatus }</option>
										<option value="Approved">Approved</option>
										<option value="Rejected">Rejected</option>
										<option value="Blocked">Blocked</option>

									</select> <label class="profile-label mt-2">Created At</label> <input
										type="text" class="form-control" name="createdAt"
										value="${userAccount.createdAt}" readOnly required>
								</div>
							</div>


							<div class="text-center mt-4">
								<button type="submit" class="btn btn-success px-4">Save
									Profile</button>
								
							</div>

						</form>
					</div>
				</div>

			</c:otherwise>
		</c:choose>




	</div>
</body>
</html>
