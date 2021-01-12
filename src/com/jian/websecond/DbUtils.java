package com.jian.websecond;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	 
	public static Connection getCon() throws Exception {
		final String URL = "jdbc:mysql://localhost/test?serverTimezone=UTC";
		final String USER = "root";
		final String PW = "9269";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("접속 성공!");
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		if(ps != null) {
			try { ps.close(); } catch(Exception e) {}
		}
		if(con != null) {
			try { con.close(); } catch(Exception e) {}
		}
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch(Exception e) { }
		}
		close(con, ps);
	}
 }
