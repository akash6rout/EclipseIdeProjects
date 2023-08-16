<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.nt.service.*,com.nt.beans.*" %>
<!-- Read form data and white it to java bean class object -->
<jsp:useBean id="emp" class="com.nt.beans.Employee" scope="request"/>

<jsp:setProperty property="*" name="emp"/>

<!-- create service class object -->
<jsp:useBean id="service" class="com.nt.service.PayslipGeneratorService" scope="application"/>

<%
//invoke b.method
service.generatePaySlip(emp);
%>
<!-- call getter methods on java beans class obj to display the results -->
employee Id::<jsp:getProperty property="empNo" name="emp"/><br><br>
employee name::<jsp:getProperty property="empName" name="emp"/><br><br>
employee salary::<jsp:getProperty property="empSalary" name="emp"/><br><br>
employee addrs::<jsp:getProperty property="empAddrs" name="emp"/><br><br>
employee grossSalary::<jsp:getProperty property="grossSalary" name="emp"/><br><br>
employee netSalary::<jsp:getProperty property="netSalary" name="emp"/><br><br>

<br><br>

<a href="employee_details.html"></a>
</body>
</html>