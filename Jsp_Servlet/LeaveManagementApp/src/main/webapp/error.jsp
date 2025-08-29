<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .error-container {
            background: #fff;
            padding: 40px 60px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        }

        .error-code {
            font-size: 96px;
            font-weight: bold;
            color: #e74c3c;
            margin: 0;
        }

        .error-message {
            font-size: 20px;
            color: #555;
            margin: 15px 0;
        }

        .btn-home {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 24px;
            background: #3498db;
            color: #fff;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background 0.3s;
        }

        .btn-home:hover {
            background: #217dbb;
        }
    </style>
</head>
<body>
	<%
		String errorMassage = (String) request.getAttribute("error");
	%>


    <div class="error-container">
        <h1 class="error-code">500</h1>
        <p class="error-message"><%= (errorMassage!=null && !errorMassage.isBlank()) ? errorMassage : "Oops! Something went wrong on our side."%></p>
        <a href="Login.jsp" class="btn-home">Go Login</a>
    </div>
</body>
</html>
