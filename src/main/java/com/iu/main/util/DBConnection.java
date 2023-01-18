package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() throws Exception {
		
		//1. 접속 정보 준비
		
		//1.id
		String username = "hr";
		//2.pw
		String password = "hr";
		//3.url
		String url = "jdbc:oracle:thin:@localhost/XEPDB1";
//		String url = "jdbc:oracle:thin:@ip:port/ServiceName";
//		String url = "jdbc:oracle:thin:@ip:port/SID";
		//4.driver
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		//2.DB 접속 실행
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static void disConnect(ResultSet rs,PreparedStatement st, Connection connection) throws Exception {
		rs.close();
		st.close();
		connection.close();
	}
	
	
	
	
	
}
