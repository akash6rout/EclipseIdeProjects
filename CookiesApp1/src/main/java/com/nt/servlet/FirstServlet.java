package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=response.getWriter();
		//set response content type
		response.setContentType("text/html");
		//create cookies
		Cookie ck1=new Cookie("ap","amaravathi");
		Cookie ck2=new Cookie("TS","HYD");
		response.addCookie(ck1);
		response.addCookie(ck2);// in Memory Cookie
		Cookie ck3=new Cookie("MH","Mumbai");
		Cookie ck4=new Cookie("MP","Bhopal");
		ck3.setMaxAge(60);//60secs
		ck4.setMaxAge(120);//120secs
		response.addCookie(ck3);
		response.addCookie(ck4);//Pesistent cookies
		
		pw.println("<h1 style='color:red;text-align:center'>Cookies are sucessfully created </h1>");
		
		//close stream
		pw.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
