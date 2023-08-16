<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page isELIgnored="false" import="java.util.*,com.nt.beans.*"%>

	<%
	//setMIME type
	response.setContentType("application/vnd.ms-excel");
	//make the output of this jsp page as the downloadable file
	response.setHeader("Content-Disposition", "attachment;fileName=empsinfo.xls");
	//read the request attribute value
	List<Employee> list = (List<Employee>) request.getAttribute("emplinfo");
	//read the request param value
	String desg = request.getParameter("desg");
	if (list.size() != 0 && list != null) {
	%>
	<!-- Display the details in the form of html table -->
	<table>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>salary</th>
			<th>gross salary</th>
			<th>Netsalary</th>
		</tr>
		<%
		for (Employee emp : list) {
		%>
		<tr>
			<td><%=emp.getEmpNo()%></td>
			<td><%=emp.getEmpName()%></td>
			<td><%=emp.getDesg()%></td>
			<td><%=emp.getSalary()%></td>
			<td><%=emp.getGrossSalary()%></td>
			<td><%=emp.getNetSalary()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} //if
	else {
	%>
	<h1 style="color: red; text-align: center">No Employees are found</h1>
	<%
	}
	%>
</body>
</html>