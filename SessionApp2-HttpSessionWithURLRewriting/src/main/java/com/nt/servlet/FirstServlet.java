package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1 data
		String name=req.getParameter("name");
		String addrs=req.getParameter("addrs");
		int age=Integer.parseInt(req.getParameter("age"));
		String ms=req.getParameter("ms");
		
		//create HttpSession object
		HttpSession ses=req.getSession(true);
		ses.setAttribute("name", name);
		ses.setAttribute("addrs", addrs);
		ses.setAttribute("age", age);
		ses.setAttribute("ms", ms);
		
		//generate form2 dynamically based on the material status
		if(ms.equalsIgnoreCase("married"))
		{
			pw.println("<h1 style='color:red;text-align:center'>person information gathering - form2</h1>");
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table bgcolor='cyan' align='center'>");
			pw.println("<tr><td>spouse name::</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No of kids::</td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>person information gathering-Form2</h1>");
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table bgcolor='cyan' align='center'>");
			pw.println("<tr><td>When do u want to marry::</td><td><input type='text' name='f2t1'></td></td>");
			pw.println("<tr><td>Why do u want to marry::</td><td><input type='text' name='f2t2'></td></td>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		pw.println("<br><br><b>Session Id of the Session obj::"+ses.getId()+"</b>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
