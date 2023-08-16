package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write message
		pw.println("<h1 style='color:blue;text-align:center'>WishMessageApp -- Home Page</h1>");
		
		//close the stream
		pw.close();
	}
}
