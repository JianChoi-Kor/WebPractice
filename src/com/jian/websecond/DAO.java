package com.jian.websecond;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public static List<HobbyEntity> selHobbyList() {
		List<HobbyEntity> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "Select i_hobby, nm From hobby order by i_hobby";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_hobby = rs.getInt("i_hobby");
				String nm = rs.getString("nm");
				
				HobbyEntity vo = new HobbyEntity();
				vo.setI_hobby(i_hobby);
				vo.setNm(nm);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	
	public static int insHobby(HobbyEntity param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO hobby (i_hobby, nm) VALUES (?, ?)";
		
		System.out.println("sql : " + sql);
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, param.getI_hobby());
			ps.setString(2, param.getNm());
			System.out.println(ps);
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
 		
		return 0;
	}
	
	public static int udpHobby(HobbyEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE hobby SET nm = ? WHERE i_hobby= ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getNm());
			ps.setInt(2,  param.getI_hobby());
			System.out.println(ps);
			return ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int delHobby(HobbyEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM hobby WHERE i_hobby= ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_hobby());
			System.out.println(ps);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
	
	
	
	
	
	
	
}
