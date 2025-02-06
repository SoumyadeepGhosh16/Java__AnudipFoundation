package com.jdbc.bookmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String url = "jdbc:mysql://localhost:3306/practice6";

		try {
			Connection con = DriverManager.getConnection(url, "root", "Root1234");// url,uname.password
			//Statement stmt = con.createStatement();
			// int i=stmt.executeUpdate("insert into book values(2,'Intro to Java',500)");
			// System.out.println(i+" records has been inserted.");
			//int i = stmt.executeUpdate("Update salesman set commission=0.20 where city='Paris'");
			//System.out.println(i + "successfully executed");
			
			PreparedStatement pstmt=con.prepareStatement("insert into employees values(?,?,?,?)");
			//PreparedStatement pstmt=con.prepareStatement("delete from book  where bid=?");
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Enter eid:");
			int eid=scan.nextInt();
			
			System.out.println("Enter ename:");
			String ename =scan.next();
			
			System.out.println("Enter contact:");
			String contact=scan.next();
			
			System.out.println("Enter salary:");
			int salary=scan.nextInt();
			
			pstmt.setInt(1, eid);
			pstmt.setString(2, ename);
			pstmt.setString(3, contact);
			pstmt.setInt(4,salary);
			
			int i=pstmt.executeUpdate();
			
			System.out.println(i+ " records has been inserted");
			
			PreparedStatement pstmt2=con.prepareStatement("select * from employees");
			ResultSet rs = pstmt2.executeQuery();
			while (rs.next()) {

				int eid2 = rs.getInt(1);
				String ename2 = rs.getString(2);
				String contact2 = rs.getString(3);
				int salary2 = rs.getInt(4);

				System.out.println("eid :" + eid2);
				System.out.println("ename :" + ename2);
				System.out.println("contact :" + contact2);
				System.out.println("salary :" + salary2);

				System.out.println(".............................");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}