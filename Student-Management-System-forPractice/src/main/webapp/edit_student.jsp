<%@page import="com.nt.entities.Student"%>
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

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<p class="fs-3 text-center">Edit Student</p>
					<%
					int id=Integer.parseInt(request.getParameter("id"));
					StudentDAO dao=new StudentDAO(DBConnect.getConnection());
					Student s=dao.getStudentById(id);
					%>
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Enter Your Name</label> <input
									type="text" class="form-control" name="name" value=<%=s.getName() %> required="required">
							</div>
							<div class="mb-3">
								<label class="form-label">Enter Your Address</label> <input
									type="text" class="form-control" name="address" value=<%=s.getAddress() %> required="required">
							</div>
							<div class="mb-3">
								<label class="form-label">Enter Your Email</label> <input
									type="email" class="form-control" name="email" value=<%=s.getEmail() %> required="required">
							</div>
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>