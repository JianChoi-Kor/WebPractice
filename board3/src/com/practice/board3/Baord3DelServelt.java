package com.practice.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.board3.dao.Board3DAO;
import com.practice.board3.model.Board3Entity;


@WebServlet("/del")
public class Baord3DelServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		
		Board3Entity param = new Board3Entity();
		param.setI_board(i_board);
		
		Board3DAO.delBoard(param);
		
		response.sendRedirect("/list");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
