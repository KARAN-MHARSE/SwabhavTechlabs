<%@page import="com.aurionpro.lms.model.Employee"%>
<%@page import="com.aurionpro.lms.properties.LeaveStatus"%>
<%@page import="com.aurionpro.lms.dto.EmployeeLeaveDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding: 0; margin: 0">
	<%
		Employee employee =(Employee) request.getSession().getAttribute("employee");
	if(employee == null){
		response.sendRedirect("Login.jsp");
		return;
	}
		String employeeName = employee.getName();
	%>
	<!-- Navbar -->
	<div style="padding: 5px 10px; background: #f0f0f0; display: flex;align-items:center; justify-content: space-between;">
		<h1 style="font-size: 20px">Hello <%= employeeName%>!</h1>
		<form action="LogOutController" method="post" style="padding: 10px 20px">
				<button style="padding: 7px 20px; border-radius: 10px; font-weight: bold">Log Out</button>
		
		</form>
		
	</div>

	<!-- All Leaves -->
	<div style="padding: 15px">
		<h2 style="color: #333; margin-bottom: 15px; text-align: center;">Leaves
			Summary</h2>
		<%
		List<EmployeeLeaveDTO> employeeLeaves = (List<EmployeeLeaveDTO>) request.getAttribute("employeeLeaves");
		if (employeeLeaves != null && !employeeLeaves.isEmpty()) {
		%>
		<table
			style="width: 100%; border-collapse: collapse; text-align: center; font-size: 14px;">
			<tr style="background: #f0f0f0; font-weight: bold; color: #333;">
				<th style="padding: 10px; border: 1px solid #ddd;">Employee ID</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Employee
					Name</th>

				<th style="padding: 10px; border: 1px solid #ddd;">Available
					Leaves</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Start Date</th>
				<th style="padding: 10px; border: 1px solid #ddd;">End Date</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Reason</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Status</th>
			</tr>
			<%
			for (EmployeeLeaveDTO employeeLeave : employeeLeaves) {
			%>
			<tr style="background: #fafafa;">
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getEmployeeId()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getEmployeeName()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getAvailableLeaves()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getStartDate()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getEndDate()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getReason()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getStatus()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		} else {
		%>
		<p style="text-align: center; color: #777;">No leave applications
			found.</p>
		<%
		}
		%>
	</div>

	<!-- Pending leaves -->
	<div style="padding: 15px">
		<h2 style="color: #333; margin-bottom: 15px; text-align: center;">Pending
			Leaves</h2>
		<%
		if (employeeLeaves != null && !employeeLeaves.isEmpty()) {
		%>
		<table
			style="width: 100%; border-collapse: collapse; text-align: center; font-size: 14px;">
			<tr style="background: #f0f0f0; font-weight: bold; color: #333;">
				<th style="padding: 10px; border: 1px solid #ddd;">Employee ID</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Employee
					Name</th>

				<th style="padding: 10px; border: 1px solid #ddd;">Available
					Leaves</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Start Date</th>
				<th style="padding: 10px; border: 1px solid #ddd;">End Date</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Reason</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Status</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Approved</th>
				<th style="padding: 10px; border: 1px solid #ddd;">Reject</th>


			</tr>
			<%
			for (EmployeeLeaveDTO employeeLeave : employeeLeaves) {
				if (employeeLeave.getStatus() == LeaveStatus.Pending) {
			%>
			<tr style="background: #fafafa;">
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getEmployeeId()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getEmployeeName()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getAvailableLeaves()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getStartDate()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getEndDate()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getReason()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;"><%=employeeLeave.getStatus()%></td>
				<td style="padding: 8px; border: 1px solid #ddd;">
					<form action="AdminLeaveController" method="post">
						<input hidden="true" name="action" value="approved"> <input
							type="hidden"  name="leaveId"
							value=<%=employeeLeave.getLeaveId()%>>
						<button>Approved</button>
					</form>
				</td>
				<td style="padding: 8px; border: 1px solid #ddd;">
					<form action="AdminLeaveController" method="post">
						<input type="hidden" name="action" value="reject"> <input
							hidden="true" name="leaveId"
							value=<%=employeeLeave.getLeaveId()%>>

						<button>Reject</button>
					</form>
				</td>


			</tr>
			<%
			}
			}
			%>
		</table>
		<%
		} else {
		%>
		<p style="text-align: center; color: #777;">No leave applications
			found.</p>
		<%
		}
		%>
	</div>


</body>
</html>