package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERT_SUNITA_QUERY="INSERT INTO login VALUES(?,?)";   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunita","root","123456789");
				PreparedStatement ps=con.prepareStatement(INSERT_SUNITA_QUERY)
				){
			PrintWriter out=response.getWriter();
			String n=request.getParameter("txtname");
			String p=request.getParameter("txtpass");
			
			ps.setString(1, n);
			ps.setString(2, p);
			
			ps.executeUpdate();
			if(ps!=null) {
				out.println("<font color=red size=18>Registration Sucessfull!!<br><a href=login.jsp>Go To Login Page</a>");
				//RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				//rd.forward(request, response);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
