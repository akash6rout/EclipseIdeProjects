package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("wishurl")
public class WishMessageServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get PrintWriter from res obj pointing to res object
		PrintWriter pw=response.getWriter();
		//set response content type
		response.setContentType("text/html");
		//write b.logic to generate the wish message
			//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get the current hour of the day
		int hour=ldt.getHour();
		//generate the wish message
		String msg=null;
		if(hour<12)
			msg="GOOD Morning";
		else if(hour<16)
			msg="GOOD AFTERNOON";
		else if(hour<20)
			msg="GOOD EVENING";
		else
			msg="GOOD NIGHT";
		//Display the generated WishMessage
		pw.println("<h1 style='color:green'>"+msg+"</h1>");
		//add home hyperlinks
		pw.println("<br><a href='http://localhost:1434/WishMessageApp2-HtmlToServletCommunicationUsingHyperlinks/page.html'>Home</a>");
			
			//close streams
		pw.close();
		
	}//sevice(-,-)

}//class
