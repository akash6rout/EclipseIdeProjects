package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1 data form hidden boxes of form2(session tracking)
		String name=req.getParameter("hname");
		String addrs=req.getParameter("haddrs");
		String age=req.getParameter("hage");
		String ms=req.getParameter("hms");
		//read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		
		pw.println("<h1 style='color:red'>Form1/request1 data::"+name+"...."+addrs+"...."+age+"...."+ms+"</h1>");
		pw.println("<h2 style='color:blue'>Form2/request2 data::"+f2val1+"...."+f2val2+"</h2>");
		pw.println("<h2><a href='person_details.html'>home::</a></h2>");
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
