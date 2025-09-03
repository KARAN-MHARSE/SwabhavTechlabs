<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="user" value="${user }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Karan Bank - Customer Dashboard</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-screen flex flex-col">
	<c:set var="action" value="${param.action }" />

	<!-- Navbar -->
	<nav
		class="bg-blue-600 text-white flex items-center justify-between px-6 py-3">
		<div class="font-bold text-xl">Karan Bank</div>
		<div class="flex items-center space-x-4">
			<span id="customerName">Welcome, <c:out value="${user.name }" /></span>
			<form action="LogoutController" method="post">
				<button type="submit"
					class="bg-red-500 hover:bg-red-600 px-3 py-1 rounded">Logout</button>
			</form>
		</div>
	</nav>

	<!-- Main layout -->
	<div class="flex flex-1 h-full">

		<!-- Sidebar -->
		<aside class="bg-gray-100 w-64 p-6 space-y-4 border-r">
			<a
				href=<%=request.getContextPath() + "/CustomerDashboardController"%>
				class="block px-4 py-2 rounded hover:bg-green-200">Dashboard</a> 			<a
				href=<%=request.getContextPath() + "/CustomerDashboardController?action=transfer"%>
				class="block px-4 py-2 rounded hover:bg-green-200">Transfer
				Money</a>  <a
				href=<%=request.getContextPath() + "/CustomerDashboardController?action=transactions"%>
				class="block px-4 py-2 rounded hover:bg-green-200">Transactions</a>
			<a
				href=<%=request.getContextPath() + "/CustomerDashboardController?action=profile"%>
				class="block px-4 py-2 rounded hover:bg-green-200">Profile</a>
				<a
				href=<%=request.getContextPath() + "/CustomerDashboardController?action=changepassword"%>
				class="block px-4 py-2 rounded hover:bg-green-200">Change Password</a>
		</aside>
		<c:choose>
			<c:when test="${action eq 'transactions' }">
				<jsp:include page="/WEB-INF/views/customer/pages/Transactions.jsp"></jsp:include>
			</c:when >
			<c:when test="${action eq 'profile' }">
							<jsp:include page="/WEB-INF/views/customer/pages/Profile.jsp"></jsp:include>
			
			</c:when>
			<c:when test="${action eq 'transfer'}">
							<jsp:include page="/WEB-INF/views/customer/pages/Transfer.jsp"></jsp:include>
			
			</c:when>
			<c:when test="${action eq 'changepassword'}">
							<jsp:include page="/WEB-INF/views/ChangePassword.jsp"></jsp:include>
			</c:when>
			
			<c:otherwise>
				<jsp:include page="/WEB-INF/views/customer/pages/Home.jsp"></jsp:include>

			</c:otherwise>

		</c:choose>


	</div>
</body>
</html>
