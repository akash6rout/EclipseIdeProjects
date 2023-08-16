<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page isELIgonred="false" import="java.util.*,com.nt.beans.*"%>
	<%
	//read the request attribute value
	List<Employee> list = (List<Employee>) request.getAttribute("emplinfo");
	//read the request param value
	String desg = request.getParameter("desg");
	if (list.size() != 0 && list != null) {
	%>
	<!-- Display the details in the form of html table -->
	<table border="1" bgcolor="cyan" align="center">
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
	} //IF
	else {
	%>
	<h1 style="color: red; text-align: center">No Employee are found</h1>
	<%
	}
	%>

	<br>
	<br>
	<script language="JavaScript">
		function showPrint() {
			frames.focus();			//frames in java script built-in object
			frames.print();			
		}
	</script>
	<h1 style="color: red; text-align: center">
		<a href="JavaScript:showPrint()">Print</a>
	</h1>
</body>
</html>