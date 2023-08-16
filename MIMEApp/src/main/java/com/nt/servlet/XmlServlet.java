//ExcelServlet.java
package com.nt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
	
public class XmlServlet extends HttpServlet{

	//2nd service(-,-)method overriding
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	res.setContentType("text/xml");
	//getPrintWriter stream
	PrintWriter pw=res.getWriter();
	//display the content as db table
	pw.println("<table align='center' border='1' bgcolor='cyan'>");
	pw.println("<tr><th>TeamName</th> <th>year</th><th>place</th></tr>");
	pw.println("<tr><td>India</td><td>2007</td><td>south Africa</td></tr>");
	pw.println("<tr><td>pakistan</td><td>2009</td><td>England</td></tr>");
	pw.println("<tr><td>England</td><td>2010</td><td>WestIndies</td></tr>");
	pw.println("<tr><td>WestIndies</td><td>2012</td><td>Australia</td></tr>");
	//close the stream
	pw.close();
	}
}
	