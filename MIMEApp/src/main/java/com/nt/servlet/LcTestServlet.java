package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class LcTestServlet extends HttpServlet {
	static {
		System.out.println("LcTestServlet::static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet::0-param constructor");
	}
	
	public void init(ServletConfig cg) {
		System.out.println("LcTestServlet:init(-)method");
	}
	
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		System.out.println("LcTestServlet.service(-,-)");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//Set response content type
		res.setContentType("text/html");
		
		//write b.logic
		Date date=new Date();
		//write the output to response object
		pw.println("<h1 style='color:green;text-align:center'>Date and Time::"+date+"</h1>");
		
		//close the stream
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("LcTestServlet.destroy");
	}
}
