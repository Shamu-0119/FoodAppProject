package com.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	private static Connection con;

	public static Connection connect() {
		
		String url="jdbc:mysql://localhost:3306/foodapplication";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
