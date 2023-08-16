<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="bean.LoginDao" %>
<jsp:useBean id="obj" class="bean.LoginBean"/>

<jsp:setProperty property="*" name="obj"/>

<%
boolean status=LoginDao.validate(obj);
if(status){
	out.println("You Are Successfully Logged in");
	session.setAttribute("session","true");
}
else{
	out.println("Sorry,email or password error");
	
	%>
	<jsp:include page="index.jsp"></jsp:include>
	<%
}
	%>
</body>
</html>