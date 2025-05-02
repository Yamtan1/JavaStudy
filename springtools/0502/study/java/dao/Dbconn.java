package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url= "jdbc:oracle:thin:@localhost:1521:testdb";
			String id = "green";
			String pw = "1234";
			
			Connection conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
				
	}
}
