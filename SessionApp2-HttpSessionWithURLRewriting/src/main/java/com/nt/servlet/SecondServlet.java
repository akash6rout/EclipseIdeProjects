package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form2/req2 data 
				String f2val1=req.getParameter("f2t1");
				String f2val2=req.getParameter("f2t2");
		//get accsess to the session obj this method internally reads inMemory Cookie Value
				//to get sessionid and uses that sessionid to access the session obj
		HttpSession ses=req.getSession(false);
				//read form1/req1 data from session obj as session attribute values
		String name=req.getParameter("name");
		String addrs=req.getParameter("addrs");
		String age=req.getParameter("age");
		String ms=req.getParameter("ms");
		
		
		pw.println("<h1 style='color:red'>Form1/request1 data::"+name+"...."+addrs+"...."+age+"...."+ms+"</h1>");
		pw.println("<h2 style='color:blue'>Form2/request2 data::"+f2val1+"...."+f2val2+"</h2>");
		pw.println("<h2><a href='person_details.html'>home::</a></h2>");
		
		pw.println("<br><br><b>Session id of the Session obj::"+ses.getId()+"</b>");
		//invakid the session
		ses.invalidate();
		
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
