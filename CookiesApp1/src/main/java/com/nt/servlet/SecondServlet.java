package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=response.getWriter();
		//set response content type
		response.setContentType("text/html");
		//read form1/req1 data form cookies request2 (Session Tracking)
		Cookie cks[]=request.getCookies();
		String name=cks[0].getValue();
		String addrs=cks[1].getValue();
		int age=Integer.parseInt(cks[2].getValue());
		String ms=cks[3].getValue();
		
		//read form2/req2 data
		String f2val1=request.getParameter("f2t1");
		String f2val2=request.getParameter("f2t2");
		
		pw.println("<h2 style='color:red'>Form1/request1 data::"+name+"....."+addrs+"....."+age+"....."+ms+"</h2>");
		pw.println("<h2 style='color:blue'>Form2/request2 data::"+f2val1+"....."+f2val2+"</h2>");
		
		pw.println("<br><br><a href='person_details.html'>Home::</a></h2>");
		//close stream
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
