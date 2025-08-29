<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>I am a component</p>
	<p><%= request.getAttribute("date") %> from component</p>
	
	<% 
		List<Integer> list1 = (List<Integer>) request.getAttribute("list");
		for(int n : list1){
	%>
			<p><%= n%></p>
	<%} %>
	
</body>
</html>