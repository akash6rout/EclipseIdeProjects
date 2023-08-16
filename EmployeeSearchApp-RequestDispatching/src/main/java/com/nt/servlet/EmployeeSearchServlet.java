package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empdburl")
public class EmployeeSearchServlet extends HttpServlet {
	private static final String GET_EMP_INFO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Set response content type
		res.setContentType("text/html");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//read form data
		int eno=Integer.parseInt(req.getParameter("eno"));
		//write jdbc code
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//include header
			RequestDispatcher rd=req.getRequestDispatcher("/headurl");
			rd.include(req, res);
			//pw.println("<b>hello</b>");
			pw.println("<br><br><br>");
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			//create jdbc statement object
			ps=con.prepareStatement(GET_EMP_INFO);
			//set IN param values
			ps.setInt(1, eno);
			//execute the SQL query
			rs=ps.executeQuery();
			//process the ResultSet
			if(rs.next()) {
				pw.println("<h1 style='color:red;text-align:center'>"+eno+"Employee Details are</h1>");
				pw.println("<table border='1' align='center'>");
				pw.println("<tr><td>Empno::</td><td>"+rs.getInt(1)+"</td></tr>");
				pw.println("<tr><td>Emp Name::</td><td>"+rs.getInt(2)+"</td></tr>");
				pw.println("<tr><td>Emp Desg::</td><td>"+rs.getInt(3)+"</td></tr>");
				pw.println("<tr><td>Emp Salary::</td><td>"+rs.getInt(4)+"</td></tr>");
				pw.println("<tr><td>Emp DeptNo::</td><td>"+rs.getInt(5)+"</td></tr>");
				pw.println("</table>");
				
			}
			else {
				pw.println("<h1 style='color:red;text-align:center'>Employee Details are Not found</h1>");

			}
		}
		catch(Exception e) {
			e.printStackTrace();
			/*
			//forward request to Error Servlet
			RequestDispatcher rd=req.getRequestDispatcher("errorurl");
			System.out.println("main servlet::before rd.forward(-,-)");
			pw.println("<br>main servlet::before rd.forward</br>");
			rd.forward(req, res);
			System.out.println("main servlet::after rd.forward(-,-)");
			pw.println("<b>main servlet::after rd.forward(-,-)</b>");
			*/
			RequestDispatcher rd=req.getRequestDispatcher("errorurl");
			rd.forward(req, res);
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null) {
					ps.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		//add home hyperlinks
		pw.println("<h1 style='text-align:center'><a href='input.html'>Home</a></h1>");
		
		//include header
		RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
		rd2.include(req, res);
		//close stream
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
