package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckVotingEligibilityServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		//get PrintWriter stream form res obj
		PrintWriter pw=res.getWriter();
		//SET RESPONSE CONTENT TYPE
		res.setContentType("text/html");
		//READ FORM DATA AS REQ PARAM VALUES
		String name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		String tage=req.getParameter("page");
		int age=Integer.parseInt(tage);
		//WRITE THE B.LOGIC
		if(age>=18)
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" of "+addrs+" u r eligible for Voting</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs."+name+" of "+addrs+" u r not eligible for Voting</h1>");
		
		
		//ADD HOME HYPERLINKS (GRAPHICAL LINK)
		pw.println("<a style='text-align:center' href='input.html'></a>");
		// Close the stream
		pw.close();
	}

}
