<%@page import="com.aurionpro.bms.dto.UserAccountDTO"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="account" value="${account }" scope="request"></c:set>
<%
	UserAccountDTO account = (UserAccountDTO) request.getAttribute("account");
	byte[] adharBytes = account.getDocuments().get(0).getFile();
	String adharImage = Base64.getEncoder().encodeToString(adharBytes);
	
	byte[] panBytes = account.getDocuments().get(1).getFile();
	String panImage = Base64.getEncoder().encodeToString(panBytes);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">User Profile</h4>
        </div>
        <div class="card-body">
            
            <!-- User Info -->
            <h5 class="mb-3">Personal Information</h5>
            <div class="row mb-3">
                <div class="col-md-6">
                    <p><span class="profile-label">User ID:</span> ${account.userId }</p>
                    <p><span class="profile-label">Full Name:</span>${account.name } </p>
                    <p><span class="profile-label">Gender:</span> ${account.gender }</p>
                    <p><span class="profile-label">Mobile:</span> ${account.mobile }</p>
                </div>
                <div class="col-md-6">
                    <p><span class="profile-label">Address:</span> ${account.address }</p>
                    <p><span class="profile-label">Email:</span>${account.email }</p>
                    <p><span class="profile-label">Aadhar No:</span> ${account.adhar }</p>
                    <p><span class="profile-label">PAN No:</span> ${account.pan }</p>
                </div>
            </div>

            <!-- Account Info -->
            <h5 class="mb-3 mt-4">Account Information</h5>
            <div class="row mb-3">
                <div class="col-md-6">
                    <p><span class="profile-label">Account ID:</span> ${account.accountId }</p>
                    <p><span class="profile-label">Account Number:</span> ${account.accountNumber}</p>
                    <p><span class="profile-label">Balance:</span> ${account.balance }</p>
                </div>
                <div class="col-md-6">
                    <p><span class="profile-label">Status:</span> ${account.accountStatus }</p>
                    <p><span class="profile-label">Approved:</span> ✅ Yes</p>
                    <p><span class="profile-label">Created At:</span> ${account.createdAt}</p>
                </div>
            </div>

            <!-- Documents -->
            <h5 class="mb-3 mt-4">Uploaded Documents</h5>
            <div class="row mb-3">
                <div class="col-md-6">
                    <p><span class="profile-label">Aadhar Document:</span></p>
                    <img src="data:image/png;base64,<%= adharImage %>"
                         class="img-fluid rounded shadow" alt="Aadhar Document">
                </div>
                <div class="col-md-6">
                    <p><span class="profile-label">PAN Document:</span></p>
                    <img src="data:image/png;base64,<%= panImage %>"
                         class="img-fluid rounded shadow" alt="PAN Document">
                </div>
            </div>
            
        </div>
    </div>
</div>
</body>
</html>
