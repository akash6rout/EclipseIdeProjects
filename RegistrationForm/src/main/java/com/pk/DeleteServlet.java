package com.pk;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteservleturl")
public class DeleteServlet extends HttpServlet {
	
	private static final String DELETE_QUERY="delete from gvitechtable where password=?";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gvitech","root","123456789");
				PreparedStatement ps=con.prepareStatement(DELETE_QUERY)
				){
			PrintWriter out=response.getWriter();
			String p=request.getParameter("password");
			ps.setString(2, p);
			
			ps.executeUpdate();
			if(ps!=null) {
				out.println("<font color=red size=18>Delete Sucessfull!!<br><a href=index.html>Go To Login Page</a>");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
