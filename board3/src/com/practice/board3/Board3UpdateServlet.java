package com.practice.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.board3.dao.Board3DAO;
import com.practice.board3.model.Board3Entity;


@WebServlet("/update")
public class Board3UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		
		Board3Entity param = new Board3Entity();
		param.setI_board(i_board);
		
		Board3Entity data = Board3DAO.selBoard(param);
		request.setAttribute("data", data);
		
		String jsp = "WEB-INF/jsp/update.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String ctnt = request.getParameter("ctnt");
		
		Board3Entity param = new Board3Entity();
		param.setI_board(i_board);
		param.setTitle(title);
		param.setWriter(writer);
		param.setCtnt(ctnt);
		
		Board3DAO.updBoard(param);
		
		response.sendRedirect("/detail?i_board="+ strI_board);
	}

}
