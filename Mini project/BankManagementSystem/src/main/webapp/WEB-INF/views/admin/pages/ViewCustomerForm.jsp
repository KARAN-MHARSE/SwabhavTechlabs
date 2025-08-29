<%@page import="java.util.Base64"%>
<%@page import="com.aurionpro.bms.dto.UserAccountDTO"%>
<%@page import="org.apache.catalina.startup.UserConfig"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="userAccount" value="${userAccount}"></c:set>
<%
UserAccountDTO account = (UserAccountDTO) request.getAttribute("userAccount");
String adharUrl = "";
String panUrl = "";
if (account != null) {
	byte[] adharBytes = account.getDocuments().get(0).getFile();
	adharUrl = Base64.getEncoder().encodeToString(adharBytes);

	byte[] panBytes = account.getDocuments().get(1).getFile();
	panUrl = Base64.getEncoder().encodeToString(panBytes);

}
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Bank Admin - User Account Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<c:choose>
		<c:when test="${ userAccount==null}">
		Details not found
	</c:when>
		<c:otherwise>
			<div class="container mt-5">
				<h2 class="mb-4 text-center">User & Account Details</h2>

				<!-- User Details -->
				<div class="card mb-4 shadow-sm">
					<div class="card-header bg-dark text-white">
						<h5 class="mb-0">Customer Information</h5>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th>User ID</th>
									<td>${userAccount.userId }</td>
								</tr>
								<tr>
									<th>Name</th>
									<td>${userAccount.name }</td>
								</tr>
								<tr>
									<th>Address</th>
									<td>${userAccount.address}</td>
								</tr>
								<tr>
									<th>Gender</th>
									<td>${userAccount.gender.toString()}</td>
								</tr>
								<tr>
									<th>Mobile</th>
									<td>${userAccount.mobile }</td>
								</tr>
								<tr>
									<th>Aadhar</th>
									<td>${userAccount.adhar }</td>
								</tr>
								<tr>
									<th>Email</th>
									<td>${userAccount.email }</td>
								</tr>
								<tr>
									<th>Active</th>
									<td><span class="badge bg-success"> <c:choose>
												<c:when test="${userAccount.email == true }">Yes</c:when>
												<c:otherwise>No</c:otherwise>
											</c:choose>

									</span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<!-- Account Details -->
				<div class="card mb-4 shadow-sm">
					<div class="card-header bg-dark text-white">
						<h5 class="mb-0">Account Information</h5>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th>Account ID</th>
									<td>${userAccount.accountId }</td>
								</tr>
								<tr>
									<th>Account Number</th>
									<td>${userAccount.accountNumber }</td>
								</tr>
								<tr>
									<th>Balance</th>
									<td>${userAccount.balance }</td>
								</tr>
								<tr>
									<th>Approved</th>
									<td><span class="badge bg-warning text-dark">Pending</span></td>
								</tr>
								<tr>
									<th>Created At</th>
									<td>${userAccount.createdAt }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<!-- Documents -->
				<div class="card mb-4 shadow-sm">
					<div class="card-header bg-dark text-white">
						<h5 class="mb-0">Uploaded Documents</h5>
					</div>
				<div class="card-body">
    <div class="row text-center">
        <!-- Aadhaar Image -->
        <div class="col-12 col-md-6 mb-3">
            <img src="data:image/png;base64,<%=adharUrl%>" 
                 alt="Aadhaar"
                 class="img-fluid rounded shadow-sm"
                 style="max-width: 250px; height: auto;">
        </div>

        <!-- PAN Image -->
        <div class="col-12 col-md-6 mb-3">
            <img src="data:image/png;base64,<%=panUrl%>" 
                 alt="PAN"
                 class="img-fluid rounded shadow-sm"
                 style="max-width: 250px; height: auto;">
        </div>
    </div>
</div>

				</div>

				<!-- Action Buttons -->
				<div class="text-center mb-5">
					<form action="ViewCustomerFormController" method="post">
						<input type="hidden" name="isApproved" value="true"> <input
							type="hidden" name="accountNumber"
							value="${userAccount.accountNumber }">
						<button class="btn btn-success btn-lg me-3">Approve</button>
					</form>

					<form action="ViewCustomerFormController" method="post">
						<input type="hidden" name="isApproved" value="false"> <input
							type="hidden" name="accountNumber"
							value="${userAccount.accountNumber }">
						<button class="btn btn-danger btn-lg">Reject</button>
					</form>

				</div>

			</div>

		</c:otherwise>

	</c:choose>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
