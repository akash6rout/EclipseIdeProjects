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
import com.nt.entities.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		
		
		Student student=new Student(name,address,email);
		StudentDAO dao=new StudentDAO(DBConnect.getConnection());
		
		HttpSession session=req.getSession();
		
		boolean f=dao.addStudent(student);
		
		if(f)
		{
			session.setAttribute("succMsg", "Student Details Update Successfully..");
			res.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "Something Went Wrong on server..");
			res.sendRedirect("index.jsp");
		}
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
