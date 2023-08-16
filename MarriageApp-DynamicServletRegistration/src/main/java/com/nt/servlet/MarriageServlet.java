package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MarriageServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet(-,-)");
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		res.setContentType("text/html");
		//write b.logic
		pw.println("<h1 style='color:red;text-align:center'>Date and time :::"+new Date()+"</h1>");
		
		//add graphical hyperlinks
		pw.println("<br><a href='input.html'><image src='images/home.jpg' width='50' height='50'></a>");
		//close stream
		pw.close();
		}
		
	

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet::doPost(-,-)method");
		PrintWriter pw=null;
		String name=null,gender=null;
		int age=0;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data...(req param values)
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("gender");
		//write b.logic or request processing logic
		if(gender.equalsIgnoreCase("M")) {
			if(age>=21) {
				pw.println("<h1 style='color:green;text-align:center'>Mr."+name+"You are eligible for Marriange</h1>");
			}
			else {
				pw.println("<h1 style='color:red;text-align:center'>Mr."+name+" You are eligible for Marriage</h1>");
			}
			
		}
		else if(gender.equalsIgnoreCase("F")) {
			if(age>=18) {
				pw.println("<h1 style='color:red;text-align:center'>Miss."+name+" You are eligible for Marriage</h1>");
			}
			else {
				pw.println("<h1 style='color:red;text-align:center'>Miss."+name+" You are not eligible for Marriage</h1>");
			}//else
		}//else if
		else {
			pw.println("<h1 style='color:red;text-align:center'>Unknown Gender</h1>");
		}
		pw.println("<br><a href='input.html'><image src='image/home.jpg' width='50' height='50'/></a>");
		
		//close stream
		pw.close();
		
		doGet(req, res);
	}

}
