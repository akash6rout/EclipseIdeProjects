package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/processurl")
public class AllFormCompsServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set response content type
		response.setContentType("text/html");
		//get printWriter
		PrintWriter pw=response.getWriter();
		//read form data
		String name=request.getParameter("cname");
		int age=Integer.parseInt(request.getParameter("cage"));
		String addrs=request.getParameter("cadd");
		String gender=request.getParameter("gender");
		String ms=request.getParameter("ms");
		if(ms==null) {
			ms="single";//handling non-checked state for checkbox
		}
		String qlfy=request.getParameter("qlfy");
		if(qlfy==null) 
			qlfy="no qyalification is selected";////handling non-selected state for select boxes
		String hobies[]=request.getParameterValues("hb");
		
		if(hobies==null)
			hobies=new String[] {"no hobbies are selected"};//handling non-selected state for multiple check boxes
		
		String favCousins[]=request.getParameterValues("favCousine");
		if(favCousins==null)
			favCousins=new String[] {"No favourite cousins are selected"};
		
		int luckyNo=Integer.parseInt(request.getParameter("luckyNo"));
		String favColor=request.getParameter("favColor");
		int salary=Integer.parseInt(request.getParameter("salary"));
		String email=request.getParameter("mail");
		String dob=request.getParameter("dob");
		String tob=request.getParameter("tob");
		String doj=request.getParameter("doj");
		String emonth=request.getParameter("eMonth");
		String favWeek=request.getParameter("favWeek");
		long mobileNo=Long.parseLong(request.getParameter("mobileNo"));
		String fbUrl=request.getParameter("fbUrl");
		String ss=request.getParameter("sString");
		
		//write b.logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1>Master."+name+" u r baby boy</h1>");
			else if(age<=12)
				pw.println("<h1>Master."+name+" u r small boy</h1>");
			else if(age<=19)
				pw.println("<h1>Mr."+name+" u r teenage boy</h1>");
			else if(age<=35)
				pw.println("<h1>Mr."+name+" u r young man</h1>");
			else if(age<=50)
				pw.println("<h1>Mr."+name+" u r middle-aged man</h1>");
			else
				pw.println("<h1>Mr."+name+" u r budda</h1>");
		}
		else {
			if(age<5)
				pw.println("<h1>Master."+name+" u r baby girl</h1>");
			else if(age<=12)
				pw.println("<h1>Master."+name+" u r small girl</h1>");
			else if(age<=19) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+" u r teenage married girl</h1");
				else
					pw.println("<h1>Miss."+name+" u r teenage girl<h1>");
			}
			else if(age<=35) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+" u r young married girl</h1");
				else
					pw.println("<h1>Miss."+name+" u r young woman<h1>");
			}
			else if(age<=50) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+" u r married middle aged woman</h1");
				else
					pw.println("<h1>Miss."+name+" u r middle aged woman<h1>");
			}
			else {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+" u r married buddi</h1");
				else
					pw.println("<h1>Miss."+name+" u r buddi<h1>");
			}
		}//else
		//display from form data
		pw.println("<h1>form data is</h1>");
		pw.println("<b>name ::"+name+"</b><br>");
		pw.println("<b>age ::"+age+"</b><br>");
		pw.println("<b>address ::"+addrs+"</b><br>");
		pw.println("<b>gender ::"+gender+"</b><br>");
		pw.println("<b>marital status ::"+ms+"</b><br>");
		pw.println("<b>mobileNo ::"+mobileNo+"</b><br>");
		pw.println("<b>Qualification ::"+qlfy+"</b><br>");
		pw.println("<b>Hobbies ::"+Arrays.asList(hobies)+"</b><br>");
		pw.println("<b>Fav Cousins ::"+Arrays.asList(favCousins)+"</b><br>");
		pw.println("<b>DOB ::"+dob+"</b><br>");
		pw.println("<b>TOB ::"+tob+"</b><br>");
		pw.println("<b>DOJ ::"+doj+"</b><br>");
		pw.println("<b>Alegritic Month ::"+emonth+"</b><br>");
		pw.println("<b>Fav Week day ::"+favWeek+"</b><br>");
		pw.println("<b>Fav color ::"+favColor+"</b><br>");
		pw.println("<b>Email ::"+email+"</b><br>");
		pw.println("<b>FbUrl ::"+fbUrl+"</b><br>");
		pw.println("<b>Google Searching String ::"+ss+"</b><br>");
		
		//add home hyperlink
		pw.println("<br><br><a href='all_form_register.html'>Home</a>");
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
