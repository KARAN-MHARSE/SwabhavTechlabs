<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="accounts" value="${sessionScope.accounts}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Money Transfer</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="card shadow-lg p-4" style="width: 100%; max-width: 500px;">
        <div class="card-body">
            <h2 class="card-title text-center mb-4">Transfer Money</h2>
            
            <form action="TransferController" method="post">
                <!-- From Account -->
                <div class="mb-3">
                    <label for="fromAccount" class="form-label">From Account</label>
                    <select id="fromAccount" name="fromAccount" class="form-select" required>
                        <c:forEach items="${accounts}" var="account">
                            <option>${account.accountNumber}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- To Account -->
                <div class="mb-3">
                    <label for="toAccount" class="form-label">To Account</label>
                    <input type="text" id="toAccount" name="toAccount" class="form-control"
                        placeholder="Enter receiver's account number" required>
                </div>

                <!-- Amount -->
                <div class="mb-3">
                    <label for="amount" class="form-label">Amount</label>
                    <input type="number" id="amount" name="amount" class="form-control"
                        placeholder="Enter amount to transfer" min="0" required>
                </div>

                <!-- Remark -->
                <div class="mb-3">
                    <label for="remark" class="form-label">Remark (Optional)</label>
                    <input type="text" id="remark" name="remark" class="form-control"
                        placeholder="Write a note">
                </div>
                
                 <div class="mb-3">
                    <label for="remark" class="form-label">Enter password</label>
                    <input type="password" id="remark" name="password" class="form-control"
                        placeholder="Login Password">
                </div>

                <!-- Submit -->
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary btn-lg">Send Money</button>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
