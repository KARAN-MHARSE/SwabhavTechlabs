<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="admin" value="${user }"></c:set>
<c:set var="stats" value="${stats }"></c:set>
<c:set var="recentTransactions" value="${recentTransactions }"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container my-5">

        <!-- Dashboard Title -->
        <div class="text-center mb-4">
            <h2 class="fw-bold">Welcome, ${admin.name}</h2>
            <p class="text-muted">Admin Control Panel</p>
        </div>

        <div class="row g-4">

            <!-- Admin Info -->
            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-body text-center">
                        <h6 class="text-muted mb-1">Admin Name</h6>
                        <h5 class="fw-bold">${admin.name}</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-body text-center">
                        <h6 class="text-muted mb-1">Email</h6>
                        <h5 class="fw-bold">${admin.email}</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-body text-center">
                        <h6 class="text-muted mb-1">Role</h6>
                        <h5 class="fw-bold text-primary">Manager</h5>
                    </div>
                </div>
            </div>

            <!-- System Overview Stats -->
            <div class="col-md-12">
                <div class="card shadow border-0">
                    <div class="card-body">
                        <h5 class="fw-bold mb-3">System Overview</h5>
                        <div class="row text-center">
                            <div class="col-md-3">
                                <div class="p-3 bg-light rounded">
                                    <h6 class="text-muted">Total Users</h6>
                                    <h4 class="fw-bold">${stats.totalCustomers}</h4>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="p-3 bg-light rounded">
                                    <h6 class="text-muted">Total Approved Accounts</h6>
                                    <h4 class="fw-bold">${stats.totalApprovedAccounts}</h4>
                                </div>
                            </div>
                             <div class="col-md-3">
                                <div class="p-3 bg-light rounded">
                                    <h6 class="text-muted">Total Pending Accounts</h6>
                                    <h4 class="fw-bold">${stats.totalPendingAccounts}</h4>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="p-3 bg-light rounded">
                                    <h6 class="text-muted">Successfull Transactions</h6>
                                    <h4 class="fw-bold">${stats.totalSuccessTransaction}</h4>
                                </div>
                            </div>
                             <div class="col-md-3">
                                <div class="p-3 bg-light rounded">
                                    <h6 class="text-muted">Failed Transactions</h6>
                                    <h4 class="fw-bold">${stats.totalFailedTransaction}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Quick Actions -->
            <div class="col-md-12">
                <div class="card shadow border-0">
                    <div class="card-body">
                        <h5 class="fw-bold mb-3">Quick Actions</h5>
                        <div class="d-flex flex-wrap gap-2">
                            <a href=<%=request.getContextPath()+"/AdminDashboardController?action=allaccount" %> class="btn btn-outline-success px-4">All Accounts</a>
                            <a href=<%=request.getContextPath()+"/AdminDashboardController?action=pendingrequests"%> class="btn btn-outline-warning px-4">Pending Request</a>
                            <a href=<%=request.getContextPath()+"/AdminDashboardController?action=transaction"%> class="btn btn-outline-info px-4">See Transactions</a>
                            <a href=<%=request.getContextPath()+"/AdminDashboardController?action=creadiordebit"%> class="btn btn-outline-dark px-4">Credit/Debit</a>
                        </div>
                    </div>
                </div>
            </div>

           

        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
