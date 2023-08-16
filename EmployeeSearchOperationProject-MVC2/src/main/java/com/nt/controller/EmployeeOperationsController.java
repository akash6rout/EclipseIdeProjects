package com.nt.controller;

import java.io.IOException;
import java.util.List;

import com.nt.beans.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class EmployeeOperationsController extends HttpServlet {
	private IEmployeeMgmtService empService;
	@Override
	public void init() {
		empService = new EmployeeMgmtServiceImpl();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read form data
		String desg=request.getParameter("desg");
		String action=request.getParameter("source");
		//use the service
		try {
			//use service
			List<Employee> list=empService.fetchEmployeeByDesg(desg);
			//Keep the results in request scope
			request.setAttribute("emplinfo", list);
			//forward the control to view jsp page on the button the is used to submit the request
			String target=null;
			if(action.equalsIgnoreCase("html")) {
				target="/html_screen.jsp";
			}
			else {
				target="/excel_screen.jsp";
			}
			//forward the request to target page
			RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.forward(request,response);
		}catch(Exception e){
			RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
