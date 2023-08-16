package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransationMgmtTest {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement st=con.createStatement();
				Scanner sc=new Scanner(System.in);
				){
			//read input values
			int srcAcno=0,destAcno=0;
			float amount=0.0f;
			if(sc!=null) {
				System.out.println("Enter Sourse account number::");
				srcAcno=sc.nextInt();
				System.out.println("Enter Dest account number::");
				destAcno=sc.nextInt();
				System.out.println("Enter amount to transfer::");
				amount=sc.nextFloat();
			}
			if(con!=null && st!=null) {
				//begin Trasaction
				con.setAutoCommit(false);
				//add queries to the batch
				st.addBatch("UPDATE JDBC_TX_ACCOUNT1 SET BALANCE=BALANCE-"+amount+"WHERE ACNO="+srcAcno);
				st.addBatch("UPDATE JDBC_TX_ACCOUNT1 SET BALANCE=BALANCE+"+amount+"WHERE ACNO="+destAcno);
				//execute the batch
				int result[]=st.executeBatch();
				//perform txMgmt
				boolean flag=false;
				for(int i=1;i<result.length;++i) {
					if(result[i]==0) {
						flag=true;
						break;
					}
				}
				if(flag) {
					con.rollback();
					System.out.println("Money is not transfered(Transaction is rolled back)");
				}
				else {
					con.commit();
					System.out.println("Money is transfered(Transaction is Commited)");
					//System.out.println("You have "+amount+"available");
				}
				
			}//if
			String query="select balance from JDBC_TX_ACCOUNT1 where acno="+srcAcno+"";
			try(ResultSet rs=st.executeQuery(query)) {
				if(rs.next())
				{
					System.out.println("Total available balance is"+rs.getFloat(2)+"");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
