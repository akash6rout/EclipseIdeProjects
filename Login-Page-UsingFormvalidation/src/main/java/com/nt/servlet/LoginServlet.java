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

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	private static final String INSERT_USER_DATA="INSERT INTO login VALUES(?,?)";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try(PrintWriter pw=res.getWriter();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginProjectHTMLCSSJAVASCRIPT","root","123456789");
				PreparedStatement ps=con.prepareStatement(INSERT_USER_DATA);
				){
			String n=req.getParameter("username");
			String p=req.getParameter("password");
			
			ps.setString(1, n);
			ps.setString(2, p);
			
			ps.executeUpdate();
			
			if(ps!=null) {
				pw.println("<font color=red size=18>Registration Sucessfull!!<br><a href=index.html>Go To Login Page</a>");
				//RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				//rd.forward(request, response);
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
