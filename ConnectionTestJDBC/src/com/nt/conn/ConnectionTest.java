package com.nt.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","root");
			if(con!=null)
			{
				System.out.println("Connection established");
			}else {
				System.out.println("Connection not established");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
