package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/poolurl")
public class StudentRegistrationServlet extends HttpServlet {

	private static final String INSERT_STUDENT_QUERY="INSERT INTO STUDENT VALUE(SNO_SEQ1.NEXTVAL,?,?,?)";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set Respose cotent type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		float avg=Float.parseFloat(req.getParameter("avg"));
		try(PrintWriter pw=res.getWriter();
				Connection con=getPooledjdbcConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_STUDENT_QUERY)){
			if(ps!=null) {
				//set values to query params
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setFloat(3, avg);
				
				//execute the SQL Query
				int count=ps.executeUpdate();
				
				//process the results
				if(count==0)
					pw.println("<h1 style='color:red;text-align:center'>Student registraion failed </h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'>Student registraion succedded </h1>");
	
			}
			//add home hyperlink
			pw.println("<br><br><br><a href='input.html'>Home</a>");
		}
		catch(SQLException se) {
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		
		}
	//
	private Connection getPooledjdbcConnection()throws Exception{
		//establish the connection with jndi registry
		InitialContext ic=new InitialContext();
		//perform lookup operation and get DataSource object ref
		DataSource ds=(DataSource)ic.lookup("Dsjndi");
		//get pooled jdbc con object
		Connection con=ds.getConnection();
		return con;
		
	}
	
	}


