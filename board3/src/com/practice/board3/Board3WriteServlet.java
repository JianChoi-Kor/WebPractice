package com.practice.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.board3.dao.Board3DAO;
import com.practice.board3.model.Board3Entity;

@WebServlet("/write")
public class Board3WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String jsp = "WEB-INF/jsp/write.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String ctnt = request.getParameter("ctnt");
		
		Board3Entity param = new Board3Entity();
		param.setTitle(title);
		param.setWriter(writer);
		param.setCtnt(ctnt); 
		
		Board3DAO.insBoard(param);
		
		response.sendRedirect("/list");
	}

}
