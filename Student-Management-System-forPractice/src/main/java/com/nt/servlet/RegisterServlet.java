package com.nt.servlet;

import java.io.IOException;

import com.nt.conn.DBConnect;
import com.nt.dao.StudentDAO;
import com.nt.entities.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");

		Student student = new Student(name, address, email);
		
		StudentDAO dao=new StudentDAO(DBConnect.getConnection());
		
		HttpSession session = req.getSession();
		
		boolean f=dao.addStudent(student);
		
		if(f)
		{
			session.setAttribute("succMsg", "Student Details added successfully");
			resp.sendRedirect("index.jsp");
			//System.out.println("Student Details submit successfully");
		}else {
			session.setAttribute("errorMsg", "Something went wrong on server");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("Something wrong on server");
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
