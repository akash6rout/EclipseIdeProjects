package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/testurl")
//@WebServlet(urlPatterns = {"/testurl1","/testurl2"})
//@WebServlet(value = {"/testurl1","/testurl2"})
//@WebServlet({"/testurl1","testurl2"})
//@WebServlet(value="/testurl1",loadOnStartup=1,name="test")
public class TestServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getfPrintWriter
		PrintWriter pw=response.getWriter();
		//set rsponse content type
		response.setContentType("text/html");
		//write b.logic
		Date date=new Date();
		pw.println("<h1 style='color:red;text-align:center'>Date and Time::"+date+"</h1>");
		
		//close stream
		pw.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
