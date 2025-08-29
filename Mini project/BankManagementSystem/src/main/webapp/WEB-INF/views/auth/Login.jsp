<%@page import="com.aurionpro.bms.properties.Role"%>
<%@page import="com.aurionpro.bms.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>BankApp Login</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        if (user.getRole() == Role.Admin) {
            response.sendRedirect("AdminDashboard.jsp");
        } else {
            response.sendRedirect("CustomerDashboard.jsp");
        }
        return;  // stop further JSP execution
    }
%>

<div class="container d-flex align-items-center justify-content-center vh-100">
    <div class="card shadow-lg p-4 rounded-4" style="max-width: 400px; width: 100%;">
        <h3 class="text-center mb-4 text-primary">BankApp Login</h3>
        <form action="LoginController" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>
        <hr>
        <div class="text-center">
            <a href="RegisterController" class="text-decoration-none">Create a new bank account</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional for components like modal, dropdowns) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
