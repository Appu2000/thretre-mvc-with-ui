<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<meta charset="ISO-8859-1">
<title>Sign-in</title>
<head>

	<title>Animated Login Form</title>
	<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
	<div class="box">
		<form autocomplete="off" action="login" >
			<h2>Sign in</h2>
			<div class="inputBox">
				<input type="text" required="required" name="user">
				<span>Userame</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="password" required="required" name="pass">
				<span>Password</span>
				<i></i>
			</div>
			<div class="links">
				<a href="#"></a>
				<a href="signup">Signup</a>
			</div>
			<input type="submit" value="Login">
		</form>
	</div>
</body>





</html>