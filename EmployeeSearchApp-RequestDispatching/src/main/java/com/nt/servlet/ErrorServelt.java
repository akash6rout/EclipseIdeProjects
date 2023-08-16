package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/errorurl")
public class ErrorServelt extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Error servlet::doGet(-,-)");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response Content type
		res.setContentType("text/html");
		//write non-technical guiding message to endusers
		pw.println("<h1 style='color:red;text-align:center'>Internal problem --Try again</h1>");
		pw.println("<br><a href='input.html'>Home</a>");
		
		//close stream
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
