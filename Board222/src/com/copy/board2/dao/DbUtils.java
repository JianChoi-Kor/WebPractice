package com.copy.board2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	
	public static void main(String[] args) {
		try {
			getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() throws Exception {
		
		final String URL = "jdbc:mysql://localhost/JavaBoard?serverTimezone=UTC";
		final String USERNAME = "root";
		final String PASSWORD = "9269";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("DB 연결 성공");
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch(Exception e) { }
		}
		close(con, ps);
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		if(ps != null) {
			try { ps.close(); } catch(Exception e) { }
		}
		if(con != null) {
			try { con.close(); } catch(Exception e) { }
		}
	}
	
	
	
	
	
		
}
