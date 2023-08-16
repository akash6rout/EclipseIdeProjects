//RegistrationServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrationurl")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter object
		PrintWriter pw=res.getWriter();
		//set response Content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		if(ms==null)
			ms="single";
		String qlfy=req.getParameter("qlfy");
		if(qlfy==null)
			qlfy="no qualification is selected";
		long contactNo=Long.parseLong(req.getParameter("contactNo"));
		String email=req.getParameter("email");
		String hobies[]=req.getParameterValues("hb");
		if(hobies==null) {
			hobies=new String[]{"no-hobies"};
		}
		String favColors[]=req.getParameterValues("favColors");
		if(favColors==null) {
			favColors=new String[] {"no fav-colors"};
		}
		String petName=req.getParameter("petname");
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String monthInfo=req.getParameter("mob");
		String weekInfo=req.getParameter("wob");
		String fburl=req.getParameter("fburl");
		String sColor=req.getParameter("scolor");
		String ss=req.getParameter("ss");
		int favNumber=Integer.parseInt(req.getParameter("favNo"));
		long expSalary=Long.parseLong(req.getParameter("salrange"));
		
		//display the form data
		pw.println("<b>name::"+name+"</b><br>");
		pw.println("<b>addrs::"+addrs+"</b><br>");
		pw.println("<b>gender::"+gender+"</b><br>");
		pw.println("<b>martial status::"+ms+"</b><br>");
		pw.println("<b>Qualification::"+qlfy+"</b><br>");
		pw.println("<b>ContactNo::"+contactNo+"</b><br>");
		pw.println("<b>email::"+email+"</b><br>");
		
		pw.println("<b>hobbies::"+hobies+"</b><br>");
		pw.println("<b>FavColors::"+favColors+"</b><br>");
		pw.println("<b>DOB::"+dob+"</b><br>");
		pw.println("<b>TOB::"+tob+"</b><br>");
		pw.println("<b>PetName::"+petName+"</b><br>");
		pw.println("<b>MonthInfo::"+monthInfo+"</b><br>");
		pw.println("<b>Week Info::"+weekInfo+"</b><br>");
		pw.println("<b>FbUrl::"+fburl+"</b><br>");
		pw.println("<b>Sentimental Color::"+sColor+"</b><br>");
		pw.println("<b>Search String::"+ss+"</b><br>");
		pw.println("<b>Salary::"+expSalary+"</b><br>");
		pw.println("<b>Favorite Number::"+favNumber+"</b><br>");
		
		//add home hyper link
		pw.println("<br><a href='student_register.html'>home</a>");
		
		//close stream
		pw.close();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
