package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//get PrintWriter Stream obj
		PrintWriter pw=res.getWriter();
		//set Response content type
		res.setContentType("text/html");
		
		//read additional req param value
		String p1Val=req.getParameter("p1");
		Locale locales[]=Locale.getAvailableLocales();
		//write the request processing logic
		if(p1Val.equalsIgnoreCase("link1")) {
			Set<String> langSet=new HashSet();
			for(Locale l:locales) {
				langSet.add(l.getDisplayLanguage());
				
			}
			pw.println("<h1 style='color:green;text-align:center'>All Languages Are</h1>");
			langSet.forEach(lang->pw.println(lang+","));
			//java 8 forEach with Lambda expression
		}
		else if(p1Val.equalsIgnoreCase("link2")) {
			Set<String> CountrySet=new HashSet();
			for(Locale l:locales) {
				CountrySet.add(l.getDisplayCountry());
				
			}
			pw.println("<h1 style='color:green;text-align:center'>All Countries Are</h1>");
			CountrySet.forEach(country->pw.println(country+","));
		}
		
		else {
			//get system and time
			LocalDateTime ldt=LocalDateTime.now();
			
			//get current month
			int month=ldt.getMonthValue();
			if(month>=3 && month<=6) {
				pw.println("<h1 style='color:green;text-align:center'>Summer season</h1>");
				
			}else if(month>=7 && month <=10) {
				pw.println("<h1 style='color:green;text-align:center'>Rainy Season</h1>");
			}else
				pw.println("<h1 style='color:green;text-align:center'>Winter Season</h1>");
		}//else
		//add home hyperlinks
		pw.println("<h1 style='color:green;text-align:center'><a href='links.html'>Home</a></h1>");
		
		//close stream
		pw.close();
	}//doPost(-,-)
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);

}

}