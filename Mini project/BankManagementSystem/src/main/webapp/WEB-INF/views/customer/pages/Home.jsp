<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="account" value="${account }"></c:set>
<c:set var="transactions" value="${transactions }"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Customer Dashboard</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container my-5">

        <!-- Dashboard Title -->
        <div class="text-center mb-4">
            <h2 class="fw-bold">Welcome, ${account.name}</h2>
            <p class="text-muted">Here’s a summary of your account</p>
        </div>

        <div class="row g-4">

            <!-- Personal Information -->
            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-body text-center">
                        <h6 class="text-muted mb-1">Customer Name</h6>
                        <h5 class="fw-bold">${account.name }</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-body text-center">
                        <h6 class="text-muted mb-1">Email</h6>
                        <h5 class="fw-bold">${account.email}</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-body text-center">
                        <h6 class="text-muted mb-1">Mobile</h6>
                        <h5 class="fw-bold">${account.mobile}</h5>
                    </div>
                </div>
            </div>

            <!-- Account Balance -->
            <div class="col-md-4">
                <div class="card shadow border-0 h-100 text-center">
                    <div class="card-body">
                        <h6 class="text-muted mb-1">Account Balance</h6>
                        <p class="display-6 text-success fw-bold mb-1">
                             ${account.balance}
                        </p>
                        <p class="text-muted">A/C No: ${account.accountNumber}</p>
                    </div>
                </div>
            </div>

            <!-- Quick Actions -->
            <div class="col-md-8">
                <div class="card shadow border-0 h-100">
                    <div class="card-body">
                        <h5 class="fw-bold mb-3">Quick Actions</h5>
                        <div class="d-flex flex-wrap gap-2">
                            <a href="http://localhost:8080/BankManagementSystem/CustomerDashboardController?action=transfer"> <button class="btn btn-outline-primary px-4">Transfer Money</button></a>
                            <button class="btn btn-outline-success px-4">View Statements</button>
                            <a href="http://localhost:8080/BankManagementSystem/CustomerDashboardController?action=profile"><button class="btn btn-outline-warning px-4">View Profile</button></a>
                            <button class="btn btn-outline-danger px-4">Report Issue</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Transactions -->
            <div class="col-12">
                <div class="card shadow border-0">
                    <div class="card-body">
                        <h5 class="fw-bold mb-3">Recent Transactions</h5>

                        <c:choose>
                            <c:when test="${empty transactions}">
                                <p class="text-muted">No transactions found.</p>
                            </c:when>
                            <c:otherwise>
                                <div class="table-responsive">
                                    <table class="table table-hover align-middle">
                                        <thead class="table-primary">
                                            <tr>
                                                <th>Date</th>
                                                <th>Description</th>
                                                <th>From Account</th>
                                                <th class="text-end">To Account</th>
                                                <th class="text-end">Amount</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${transactions}" var="transaction">
                                                <tr>
                                                    <td>${transaction.createdAt}</td>
                                                    <td>${transaction.message}</td>
                                                    <td>
                                                        <span class="badge bg-danger">
                                                            ${transaction.fromAccountNumber}
                                                        </span>
                                                    </td>
                                                    <td class="text-end">${transaction.toAccountNumber}</td>
                                                    <td class="text-end fw-bold">${transaction.amount}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <a href="http://localhost:8080/BankManagementSystem/CustomerDashboardController?action=transactions" class="btn btn-sm btn-primary mt-3">View All Transactions</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
