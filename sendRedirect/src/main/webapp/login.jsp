<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
  crossorigin="anonymous"
/>
</head>
<body>
<div class="container p-5">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-header text-center fs-4">
            <h1>Login Here</h1>
            </div>
          <div class="card-body">
            <form action="LoginCheck" method="post">
              <div class="mb-3">
                <label>Enter Your Name</label>
                <input
                  type="text"
                  name="uname"
                  placeholder="Enter Your Name"
                  class="form-control"
                />
              </div>
              <div class="mb-3">
                <label>Enter Your Password</label>
                <input type="text" name="password" class="form-control" placeholder="Enter Your Password"/>
              </div>
              <button class="btn btn-primary col-md-12">Login</button>
            </form>
          </div>
        </div>
      </div>
    </div>
</body>
</html>