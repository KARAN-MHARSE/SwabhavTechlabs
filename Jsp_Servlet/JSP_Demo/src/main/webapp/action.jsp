<%@page import="org.apache.jasper.compiler.Node.GetProperty"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Actions in jsp -->
	<h1>Action in jsp</h1>
	<!-- useBean -->

	<jsp:useBean id="student" class="com.jsp.model.Student" scope="page"></jsp:useBean>

	<!-- setProperty-->
	<jsp:setProperty name="student" property="marks" value="90"></jsp:setProperty>
	<jsp:setProperty name="student" property="name" value="Karan"></jsp:setProperty>

	<!-- getProperty -->
	<p>
		<jsp:getProperty property="name" name="student" />
	</p>

	<jsp:forward page="index.jsp">
		<% if(student.getName() == null) {%>
		<jsp:forward page="index.jsp">
			<%} %>
		</body>
</html>


