
<%@page import="com.nt.entities.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.nt.conn.DBConnect"%>
<%@page import="com.nt.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="allcss.jsp"%>
</head>
<body style="background-color: orange">



	<%@include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">

				<p class="text-center fs-1">All Student Details</p>
				<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-success">${errorMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Full Name</th>
							<th scope="col">Address</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					
					<%
					StudentDAO dao=new StudentDAO(DBConnect.getConnection());
					List<Student> list=dao.getAllStudent();
					for(Student s:list)
					{
					%>
						<tr>
							<th scope="row"><%=s.getId()%></th>
							<td><%=s.getName() %></td>
							<td><%=s.getAddress() %></td>
							<td><%=s.getEmail() %></td>
							<td><a href="edit_student.jsp?id=<%=s.getId() %>" class="btn-sm btn-primary">Edit</a>
								<a href="delete?id=<%=s.getId() %>" class="btn-sm btn-danger">Delete</a></td>
						</tr>
						<%
					}
						%>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>