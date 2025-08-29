	<%@page import="java.util.Arrays"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Date"%>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>Good morning Karan</h1>
		<%
		Date date = new Date();
		List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 7, 8);
		
		request.setAttribute("date", date);
		request.setAttribute("list", list);
		%>
		<p>
			<%
			for(int n: list){
				out.print(n+" ");
			}
			
			%>
		</p>
		
		<%@ include file="component.jsp" %>
		<jsp:include page="component.jsp"></jsp:include>
		
		<!-- Actions in jsp -->
		
		
		
		
	</body>
	</html>