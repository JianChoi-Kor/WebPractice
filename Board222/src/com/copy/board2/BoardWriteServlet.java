package com.copy.board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.copy.board2.dao.Board2DAO;
import com.copy.board2.model.Board2Entity;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "WEB-INF/jsp/write.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		Board2Entity param = new Board2Entity();

		param.setTitle(title);
		param.setCtnt(ctnt);
		
		Board2DAO.insBoard(param);
		
		response.sendRedirect("/board2/list");
	}

}
