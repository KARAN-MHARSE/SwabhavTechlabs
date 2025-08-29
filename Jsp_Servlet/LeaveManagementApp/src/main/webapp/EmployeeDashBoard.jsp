<%@page import="com.aurionpro.lms.properties.Leave"%>
<%@page import="java.util.List"%>
<%@page import="com.aurionpro.lms.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Dashboard</title>
</head>
<body style="margin: 0; height: 100vh;background: #f5f6f8;">

	<%
	Employee employee = (Employee) request.getSession().getAttribute("employee");
	if (employee == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
	String employeeName = employee.getName();
	%>

	<!-- Navbar -->
	<div
		style="padding: 5px 10px; background: #f0f0f0; display: flex; align-items: center; justify-content: space-between; margin-bottom: 15px">
		<h1 style="font-size: 20px">
			Hello
			<%=employeeName%>!
		</h1>
		<form action="LogOutController" method="post"
			style="padding: 10px 20px">
			<button
				style="padding: 7px 20px; border-radius: 10px; font-weight: bold">Log
				Out</button>

		</form>

	</div>

	<div
		style="background: #f5f6f8; font-family: Arial, sans-serif; display: flex; align-items: center; justify-content: center;">

		<div
			style="background: white; padding: 40px 50px; border-radius: 15px; border: 1px solid #d3d3d3; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); width: 600px;">

			<h1 style="text-align: center; margin-bottom: 20px; color: #333;">Employee
				Dashboard</h1>
			<h3 style="text-align: center; color: #555; margin-bottom: 30px;">
				Welcome,
				<%=employee.getName()%>
			</h3>

			<!-- Error Message -->
			<%
			String errorMessage = (String) request.getAttribute("errorMessage");
			if (errorMessage != null) {
			%>
			<p style="color: red; text-align: center;"><%=errorMessage%></p>
			<%
			}
			%>

			<!-- Leave Application Form -->
			<div style="margin-bottom: 40px;">
				<form action="EmployeeLeaveController" method="post"
					style="display: flex; flex-direction: column; gap: 12px;">

					<label style="font-weight: bold; color: #555;">Start Date</label> <input
						type="date" name="startDate"
						style="padding: 10px; border-radius: 10px; border: 1px solid #ccc; background-color: #f9f9f9; outline: none;">

					<label style="font-weight: bold; color: #555;">End Date</label> <input
						type="date" name="endDate"
						style="padding: 10px; border-radius: 10px; border: 1px solid #ccc; background-color: #f9f9f9; outline: none;">

					<label style="font-weight: bold; color: #555;">Reason</label> <input
						type="text" placeholder="Enter reason" name="reason"
						style="padding: 10px; border-radius: 10px; border: 1px solid #ccc; background-color: #f9f9f9; outline: none;">

					<button type="submit"
						style="background: #397ff9; margin-top: 15px; padding: 10px; border: none; border-radius: 10px; color: white; font-weight: bold; cursor: pointer;"
						onmouseover="this.style.background='#2f6de0'"
						onmouseout="this.style.background='#397ff9'">Apply Leave
					</button>
				</form>
			</div>

			<!-- Leave Summary Table -->
			<div>
				<h2 style="color: #333; margin-bottom: 15px; text-align: center;">Leaves
					Summary</h2>
				<%
				List<Leave> leaves = (List<Leave>) request.getAttribute("leaves");
				if (leaves != null && !leaves.isEmpty()) {
				%>
				<table
					style="width: 100%; border-collapse: collapse; text-align: center; font-size: 14px;">
					<tr style="background: #f0f0f0; font-weight: bold; color: #333;">
						<th style="padding: 10px; border: 1px solid #ddd;">ID</th>
						<th style="padding: 10px; border: 1px solid #ddd;">Start Date</th>
						<th style="padding: 10px; border: 1px solid #ddd;">End Date</th>
						<th style="padding: 10px; border: 1px solid #ddd;">Reason</th>
						<th style="padding: 10px; border: 1px solid #ddd;">Status</th>
					</tr>
					<%
					for (Leave leave : leaves) {
					%>
					<tr style="background: #fafafa;">
						<td style="padding: 8px; border: 1px solid #ddd;"><%=leave.getId()%></td>
						<td style="padding: 8px; border: 1px solid #ddd;"><%=leave.getStartDate()%></td>
						<td style="padding: 8px; border: 1px solid #ddd;"><%=leave.getEndDate()%></td>
						<td style="padding: 8px; border: 1px solid #ddd;"><%=leave.getReason()%></td>
						<td style="padding: 8px; border: 1px solid #ddd;"><%=leave.getStatus()%></td>
					</tr>
					<%
					}
					%>
				</table>
				<%
				} else {
				%>
				<p style="text-align: center; color: #777;">No leave
					applications found.</p>
				<%
				}
				%>
			</div>
		</div>

	</div>

</body>
</html>
