<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up</title>
	<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />

</head>
<body>

<div class="box">
		<form autocomplete="off" action="adduser" >
			<h2>Sign-up</h2>
			<div class="inputBox">
				<input type="text" required="required" name="user">
				<span>TheatreName</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="password" required="required" name="pass">
				<span>Password</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="text" required="required" name="add">
				<span>Address</span>
				<i></i>
			</div>

			<div class="links">
			    <a href="#"></a>
				<a href="index">Signin</a>
			</div>
			<input type="submit" value="SignUp">
		</form>
		</div>
		</center>
</body>
</html>