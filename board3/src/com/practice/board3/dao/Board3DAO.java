package com.practice.board3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.practice.board3.model.Board3Entity;

public class Board3DAO {
	public static List<Board3Entity> selBoardList() {
		List<Board3Entity> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT i_board, title, writer, r_dt from board3";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String r_dt = rs.getString("r_dt");
				
				Board3Entity vo = new Board3Entity();
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setR_dt(r_dt);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static void insBoard(Board3Entity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO board3 (title, writer, ctnt) VALUES (?, ?, ?);";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getWriter());
			ps.setString(3, param.getCtnt());
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
	}
	
	public static Board3Entity selBoard(Board3Entity param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT title, writer, ctnt, r_dt FROM board3 WHERE i_board= ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String ctnt = rs.getString("ctnt");
				String r_dt = rs.getString("r_dt");
				
				Board3Entity data = new Board3Entity();
				data.setTitle(title);
				data.setWriter(writer);
				data.setCtnt(ctnt);
				data.setR_dt(r_dt);
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
	}
}
