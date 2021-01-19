package com.copy.board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.copy.board2.dao.Board2DAO;
import com.copy.board2.model.Board2Entity;

@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		
		Board2Entity param = new Board2Entity();
		param.setI_board(i_board);
		Board2Entity data= Board2DAO.selBoard(param);
		request.setAttribute("data", data);
		
		
		String jsp = "WEB-INF/jsp/update.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		Board2Entity param = new Board2Entity();
		param.setI_board(i_board);
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		Board2DAO.updBoard(param);
		
		response.sendRedirect("/board2/list");
	}
}
