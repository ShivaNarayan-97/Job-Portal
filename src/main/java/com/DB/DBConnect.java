package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection con;
	
	public static Connection getCon() {
		
		try {
			
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root", "root");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return con;
	}
	
}
