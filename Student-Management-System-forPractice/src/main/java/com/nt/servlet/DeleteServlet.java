package com.nt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.nt.conn.DBConnect;
import com.nt.dao.StudentDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		StudentDAO dao=new StudentDAO(DBConnect.getConnection());
		
		HttpSession session = request.getSession();
		boolean f=dao.deleteStudent(id);
		
		if(f)
			
		{
			session.setAttribute("succMsg", "Student Delete Successfully");
			response.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "Something Went Wrong on Server");
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
