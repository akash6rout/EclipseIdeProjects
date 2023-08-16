package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//get PrintWriter from res obj pointing to res object
		PrintWriter pw=res.getWriter();
		//set response context type
		res.setContentType("text/html");
		//write b.logic to generate the wish message
		//get system data and time
		LocalDateTime ldt=LocalDateTime.now();
		//get the current hour of the day
		int hour=ldt.getHour();
		//generate the wish message
		String msg=null;
		if(hour<12)
			msg="GOOD MORNING";
		else if(hour<16)
			msg="GOOD AFTERNOON";
		else if(hour<20)
			msg="GOOD EVENING";
		else
			msg="GOOD NIGHT";
			
			//Display the generate WishMessage
		pw.println("<h1 style='color:green; text-align:center'>"+msg+"</h1>");
		//add home hyperlink
		pw.println("<br><a href='http://localhost:1434/WishMessageApp-HtmlToServletCommunicationUsingHyperlinks/page.html'>HOME</a>");
	}
}
