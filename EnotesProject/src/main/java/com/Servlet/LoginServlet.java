package com.Servlet;

import java.io.IOException;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
       
    
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails us=new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean f=dao.loginUser(us);
		
		if(f)
		{
			//RequestDispatcher dd=request.getRequestDispatcher("home.jsp");
			//dd.forward(request, response);
			
			response.sendRedirect("home.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("login-failed", "Invalid Username and password");
			response.sendRedirect("login.jsp");
		}
	}

}
