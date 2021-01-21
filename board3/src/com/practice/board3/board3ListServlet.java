package com.practice.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.board3.dao.Board3DAO;
import com.practice.board3.dao.Board3DTO;
import com.practice.board3.model.Board3Entity;


@WebServlet("/list")
public class board3ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPage = request.getParameter("page");
		int page =Integer.parseInt(strPage);
		
		int rowCnt = 5;
		Board3DTO param = new Board3DTO();
		param.setRowCountPerPage(rowCnt);
		param.setStartIdx((page-1) * rowCnt);
		
		request.setAttribute("pageLength", Board3DAO.selPageLength(param));
		
		
		List<Board3Entity> list = Board3DAO.selBoardList();
		request.setAttribute("list", list);
		
		String jsp = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
