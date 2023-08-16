package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/arithmeticurl")
public class ArithmeticServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get PrintWriter obj
		PrintWriter pw=response.getWriter();
		//set Response type
		response.setContentType("text/html");
		//read additional req param value
		String s1Val=request.getParameter("s1");
		//read text box values and convert them floating point values when the submit buttons are clicked
		float val1=0.0f,val2=0.0f;
		if(!s1Val.equalsIgnoreCase("link1") && !s1Val.equalsIgnoreCase("link2"))
		{
			val1=Float.parseFloat(request.getParameter("t1"));
			val1=Float.parseFloat(request.getParameter("t2"));
		}
		//get System Date and Time
		LocalDateTime ldt=LocalDateTime.now();
		//differentiate the logic for multiple submit Buttons and hyperlinks
		if(s1Val.equalsIgnoreCase("add"))
		{
			pw.println("<h1 style='color:red;text-align:center'>Addition::"+(val1+val1)+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("sub"))
		{
			pw.println("<h1 style='color:red;text-align:center'>Addition::"+(val1-val1)+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("mul"))
		{
			pw.println("<h1 style='color:red;text-align:center'>Addition::"+(val1*val1)+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("div"))
		{
			pw.println("<h1 style='color:red;text-align:center'>Addition::"+(val1/val1)+"</h1>");
		}
		else if(s1Val.equalsIgnoreCase("link1"))
		{
			int hour=ldt.getHour();
			if(hour<12)
				pw.println();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
