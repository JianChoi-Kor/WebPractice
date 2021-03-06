package com.copy.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.copy.board2.dao.Board2DAO;
import com.copy.board2.model.Board2DTO;
import com.copy.board2.model.Board2Entity;


@WebServlet("/list")
public class BoardListServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strPage = request.getParameter("page");
		int page = strPage == null ? 1 : Integer.parseInt(strPage);
		
		int rowCnt = 6;
		Board2DTO param = new Board2DTO();
		param.setRowCountPerPage(rowCnt);
		param.setStartIdx((page-1)*rowCnt);
		request.setAttribute("pageLength", Board2DAO.selPageLength(param));
		
		List<Board2Entity> list = Board2DAO.selBoardList(param);
		request.setAttribute("list", list);
		
		String jsp = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
