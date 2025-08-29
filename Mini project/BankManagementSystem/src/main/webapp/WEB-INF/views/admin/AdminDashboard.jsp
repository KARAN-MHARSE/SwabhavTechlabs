<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Karan Bank - Admin Dashboard</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-screen flex flex-col">
	<c:set var="action" value="${param.action }" />

	<!-- Navbar -->
	<nav
		class="bg-blue-600 text-white flex items-center justify-between px-6 py-3">
		<div class="font-bold text-xl">Karan Bank</div>
		<div class="flex items-center space-x-4">
			<span id="userFirst">Admin</span>
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
			<a href=<%=request.getContextPath() + "/AdminDashboardController"%>
				class="block px-4 py-2 rounded hover:bg-blue-200">Dashboard</a> <a
				href=<%=request.getContextPath() + "/AdminDashboardController?action=addaccount"%>
				class="block px-4 py-2 rounded hover:bg-blue-200">Add New
				Account</a> <a
				href=<%=request.getContextPath() + "/AdminDashboardController?action=allaccount"%>
				class="block px-4 py-2 rounded hover:bg-blue-200">All Accounts</a> <a
				href=<%=request.getContextPath() + "/AdminDashboardController?action=pendingrequests"%>
				class="block px-4 py-2 rounded hover:bg-blue-200">Pending
				Requests</a> <a
				href=<%=request.getContextPath() + "/AdminDashboardController?action=creadiordebit"%>
				class="block px-4 py-2 rounded hover:bg-blue-200">Credit/Debit</a><a
				href=<%=request.getContextPath() + "/AdminDashboardController?action=transaction"%>
				class="block px-4 py-2 rounded hover:bg-blue-200">Transactions</a>
		</aside>

		<!-- Body / Content Area -->
		<main class="flex-1 p-6 bg-gray-50">
			<c:choose>
				<c:when test="${action eq 'addaccount' }">
					<jsp:include page="/WEB-INF/views/admin/pages/AddNewAccount.jsp" />
				</c:when>
				<c:when test="${action eq 'allaccount' }">
					<jsp:include page="/WEB-INF/views/admin/pages/AllAccounts.jsp" />

				</c:when>
				<c:when test="${action eq 'pendingrequests' }">
					<jsp:include page="/WEB-INF/views/admin/pages/PendingRequest.jsp" />

				</c:when>
				<c:when test="${action eq 'creadiordebit' }">
					<jsp:include page="/WEB-INF/views/admin/pages/CreditDebit.jsp" />

				</c:when>
				<c:when test="${action eq 'transaction' }">
					<jsp:include page="/WEB-INF/views/admin/pages/Transactions.jsp" />

				</c:when>
				<c:otherwise>
					<jsp:include page="/WEB-INF/views/admin/pages/Home.jsp" />

				</c:otherwise>


			</c:choose>
		</main>

	</div>
</body>
</html>
