<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>

<body style="height:100vh; width:100%; background:#f5f6f8; display:flex; align-items:center; justify-content:center; font-family:Arial, sans-serif;">

	<div style="background:white; display:flex; flex-direction:column; padding:40px 50px; border-radius:15px; border:1px solid #d3d3d3; box-shadow:0 4px 12px rgba(0,0,0,0.1); width:350px;">
		
		<h1 style="font-weight:bold; text-align:center; margin-bottom:25px; color:#333;">Login</h1>
		
		<form action="LoginController" method="post" style="display:flex; flex-direction:column; gap:12px;">
			
			<label style="font-weight:bold; color:#555;">Email ID</label>
			<input type="text" placeholder="Enter your email" name="email"
				style="padding:10px; border-radius:10px; border:1px solid #ccc; background-color:#f9f9f9; outline:none;">
			
			<label style="font-weight:bold; color:#555;">Password</label>
			<input type="password" placeholder="Enter your password" name="password"
				style="padding:10px; border-radius:10px; border:1px solid #ccc; background-color:#f9f9f9; outline:none;">
			
			<button type="submit"
				style="background:#397ff9; margin-top:15px; padding:10px; border:none; border-radius:10px; color:white; font-weight:bold; cursor:pointer; transition:0.3s;"
				onmouseover="this.style.background='#2f6de0'" 
				onmouseout="this.style.background='#397ff9'">
				Login
			</button>
		</form>
	</div>

</body>
</html>
