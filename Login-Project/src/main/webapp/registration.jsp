<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="form-container" style="text-align:center">
        <h2>REGISTRATION</h2>
        <form action="RegistrationServleturl" onsubmit="" method=post>
            User Name::<input type="text" placeholder="username" name="txtname"><br><br>
            <p id="usererror" class="error"></p>
            Password::<input type="password" placeholder="password" name="txtpass"><br><br>
            <p id="passerror" class="error"></p>
            <input type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="reset"><br><br>
            <a href="login.jsp"><input type="button" value="Login"></a>
        </form>
    </div>
</body>
</html>