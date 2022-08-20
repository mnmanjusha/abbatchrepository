package com.cg.jdbcpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnectDemo {

	public static void main(String[] args) {
	     Scanner sc=new Scanner(System.in);
	     
		//driver registration
		
		try {
			Class.forName("org.postgresql.Driver");
			//System.out.println("Driver Loaded");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","scott","tiger");
			//System.out.println("Connected to DB");
			PreparedStatement pst=null;
			//con.prepareStatement("insert into emp (ecode,ename,salary,dcode) values(?,?,?,?)");
			
		/*	System.out.println("Enter Code : ");
			int code=sc.nextInt();
			System.out.println("Enter Name :");
			String name=sc.next();
			
			System.out.println("Enter Salary :");
			int salary=sc.nextInt();
			/*System.out.println("Enter Join Date :");
			String jdt=sc.next();
			
			System.out.println("Enter Dept Code :");
			String dcode=sc.next();
			
			pst.setInt(1, code);   pst.setString(2, name);  pst.setInt(3, salary);
			//pst.setString(4, jdt); 
			pst.setString(4, dcode);
			
			pst.executeUpdate();
			*/
			
			pst=con.prepareStatement("select * from emp where dcode=?");
			pst.setString(1, "d6");
			
			ResultSet rs=pst.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			
			System.out.println("Field Details :");
			
			int col=rsmd.getColumnCount();
			
			for (int i=1;i<=col;i++){
				System.out.println(rsmd.getColumnLabel(i)+"\t"+rsmd.getColumnTypeName(i)+"\t"+rsmd.getColumnDisplaySize(i));
			}
			
			/*Statement st=con.createStatement();
			
		    int n=st.executeUpdate("insert into emp values(130,'Kamal',40000,'2003-04-20','d8')");
		    
		    if(n>0){
		    	System.out.println("Record Added...");
		    }
		    else{
		    	System.out.println("Record not added...");
		    }
			
		
			
			System.out.println("Enter Dept Code : ");
			String dept=sc.next();
			
			ResultSet rs=st.executeQuery("select * from emp where dcode='"+dept+"'");
			*/
			System.out.println("Employee Records : ");
			
			while(rs.next()){
				System.out.println("Code : "+rs.getInt(1)+"\nName : "+rs.getString(2)+"\nSalary: "+rs.getInt(3)+"\nDept Code : "+rs.getString(5));
			}

			
			//rs.close();   st.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
