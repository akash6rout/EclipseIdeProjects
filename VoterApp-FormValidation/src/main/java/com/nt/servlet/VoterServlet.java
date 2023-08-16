package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class VoterServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
				System.out.println("VoterServlet.doPost(-,-)");
				//get PrintWriter obj
				PrintWriter pw=res.getWriter();
				//set response content type
				res.setContentType("text/html");
				
				//read form data(req param values from request obj)
				String name=req.getParameter("pname");
				String tage=req.getParameter("page");
				int age=Integer.parseInt(tage);
				
				//write b.logic
				if(age>=18) {
					pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+"You are eligible for Voting</h1>");
				
				}else {
					pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+"You are not eligible for Voting</h1>");

				}
				//graphical hyperlinks(image as the hyperlink)
				pw.println("<a href='details_form.html'><img src='image/home.png' width='100' height='200'></a>");
				
				pw.println("<br><b>request obj class name::"+req.getClass()+"</b></br>");
				pw.println("<br><b>request obj class name::"+res.getClass()+"</b></br>");
				
				//close stream
				pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet.doGet()");
		doGet(req, res);
	}

}
