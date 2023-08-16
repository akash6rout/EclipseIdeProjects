package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckAgeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get PrintWriter Stream obj
		PrintWriter pw=res.getWriter();
	//set Response Content Type
		res.setContentType("text/html");
	//Read from data as request param values
		int age=Integer.parseInt(req.getParameter("year"));
	
	//Write the B.logic

		        int a=788,b=1235;
		        int fage=0;
		        
		        for(int i=1; i<=age; i++){
		            
		            
		            if(age<=100){
		                fage=a-age+b;
		            }
		            else {
		            	pw.println("<h1 style='color:red;text-align:center'>YOU ARE ENTERING WRONG DIGIT</h1>");
		            }
		           
		        }
	            pw.println("<h1 style='color:red;text-align:center'>YOUR DATE OF YEAR IS::"+fage+"<h1>");
	            

		    }
		

		
		

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
