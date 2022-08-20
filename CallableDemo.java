package com.cg.jdbcpack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CallableDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			//System.out.println("Driver Loaded");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","scott","tiger");
			//System.out.println("Connected to DB");
			
			//String cstr="{ call updateEmp(?,?); }";
			PreparedStatement cst=con.prepareCall("call updateEmp(?,?)");
			
			cst.setInt(1, 104);
			cst.setInt(2, 44444);
			
			cst.execute();
			
			
			cst.close();   con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
