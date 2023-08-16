package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DateServlet2 extends HttpServlet {
	
  
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		PrintWriter out=res.getWriter();
		
		Date d=new Date();
		
		out.println("<h1 style='color:red;text-align:center'>"+d+"</h1>");
		out.println("<h1>WELCOME TO SERVLET COMPENENT</h1>");
		out.println("<br>OUR SERVLET COMP CLASS OBJECT::"+this.hashCode());
		out.close();
		
	}

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
