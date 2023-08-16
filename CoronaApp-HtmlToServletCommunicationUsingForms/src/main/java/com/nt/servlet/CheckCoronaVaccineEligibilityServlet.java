package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckCoronaVaccineEligibilityServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//get PrintWriterStream obj
		PrintWriter pw=res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
		//Read from data as req param value
		String name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		String age=req.getParameter("page");
		int tage=Integer.parseInt(age);
		//write the b.loginc code
		if(tage>=18)
			pw.println("<h1>Mr/Miss/Mrs."+name+" of "+addrs+" U R Eligible for Corona Vaccination</h1>");
		else
			pw.println("<h1>Mr/Miss/Mrs."+name+" of "+addrs+" U R Not Eligible for Corona Vaccination</h1>");
		
		//ADD HOME HYPER LINKS
		pw.println("<a style='text-align:center' href='input.html'></a>");
		pw.close();
		
	}
}
