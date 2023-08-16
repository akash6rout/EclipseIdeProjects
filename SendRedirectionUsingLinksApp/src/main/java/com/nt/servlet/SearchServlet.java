package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=response.getWriter();
		//set response context type
		response.setContentType("text/html");
		//read form data
		String ss=request.getParameter("ss");
		String engine=request.getParameter("engine");
		//send hyperlinks to browser supporting the sendRedirection
		if(engine.equalsIgnoreCase("google"))
			pw.println("<a href='https://www.google.com/search?q="+ss+"'>Click here for google search</a>");
			else if(engine.equalsIgnoreCase("bing"))
				pw.println("<a href='https://www.bing.com/search?q="+ss+"'>Click here for Bing search</a>");
			else
				pw.println("<a href='https://search.yahoo.com/search?p="+ss+"'>Click here for yahoo search</a>");
		//close stream
			//close stream
			pw.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
