package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet("/registrationurl")
public class registrationServlet extends HttpServlet {
	
	private static final String INSERT_JOB_SEEKER_QUERY="INSERT INTO JOBSEEKER_INFO_ONE VALUES(JSIDNO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";                                          
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String first_name=null; String last_name=null; String email=null; String job_role=null;
		String address=null; String city=null; String pin=null; String jdate=null;
		String upload=null; List<String> fileNames = null; String resumePath = null;
		
		try {
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
			UploadBean upb = new UploadBean();
			upb.setFolderstore("E:/store");
			upb.setOverwrite(false);
			upb.store(nreq);
			
			first_name=nreq.getParameter("first_name");
			last_name=nreq.getParameter("last_name");
			email=nreq.getParameter("email");
			job_role=nreq.getParameter("job_role");
			address=nreq.getParameter("address");
			city=nreq.getParameter("city");
			pin=nreq.getParameter("pin");
			jdate=nreq.getParameter("jdate");
			Hashtable<String, UploadFile> ht = nreq.getFiles();
			Enumeration<UploadFile> e = ht.elements();
			fileNames = new ArrayList();
			while (e.hasMoreElements()) {
				UploadFile file = e.nextElement();
				fileNames.add(file.getFileName());
			}
			resumePath = "E:/store/" + fileNames.get(0);
			pw.println("<br><h1>" + fileNames.get(0) + "," + "uploaded successfully</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<br><h1>Problem in file uploading</h1>");
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				PreparedStatement ps=con.prepareStatement(INSERT_JOB_SEEKER_QUERY);){
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, email);
			ps.setString(4, job_role);
			ps.setString(5, address);
			ps.setString(6, city);
			ps.setString(7, pin);
			ps.setString(8, jdate);
			ps.setString(9, resumePath);
			
			int count=ps.executeUpdate();
			if (count == 0)
				pw.println("<h1>Job Seeker registration failed</h1>");
			else
				pw.println("<h1>Job Seeker registration completed</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(req, res);
	}

}
