<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN JSP</title>
<style type="text/css">
body {
	background: url("cute1.jpg") no-repeat;
	background-size: cover;
}

#form-container {
	width: 550px;
	top: 50%;
	left: 50%;
	transform: translate(-100%, -50%);
	position: absolute;
	color: black;
}

#form-container h2 {
	font-size: 40px;
}

.input {
	background: none;
}

#form-container p {
	font-size: 20px;
}

#form-container input {
	transform: translate(+30%, -200%);
	position: absolute;
}
</style>
</head>
<body>
	<div id="form-container" style="text-align: center">
		<h2>Login</h2>
		<form action="LoginServleturl" onsubmit="" method=post>
			<p>User Name::</p>
			<input type="text" placeholder="username" name="txtname"
				class="input"><br>
			<br>
			<p id="usererror" class="error"></p>
			<p>Password::</p>
			<input type="password" placeholder="password" name="txtpass"
				class="input"><br>
			<br>
			<p id="passerror" class="error"></p>
			<input type="submit" class="input">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Reset" class="input">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="registration.jsp"><input type="button"
				value="Registration" class="input"></a>
		</form>
	</div>
</body>
</html>