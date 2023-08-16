package com.nt.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn=null;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentpractice","root","123456789");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return conn;
	}
}
