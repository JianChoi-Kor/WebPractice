package com.copy.board2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.copy.board2.model.Board2Entity;

public class Board2DAO {
	
	public static List<Board2Entity> selBoardList() {
		List<Board2Entity> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT i_board, title, r_dt from copy_board";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String r_dt = rs.getString("r_dt");
				
				Board2Entity vo = new Board2Entity();
				
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setR_dt(r_dt);
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static void insBoard(Board2Entity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO copy_board (title, ctnt) VALUES (?, ?)";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
	}
}
