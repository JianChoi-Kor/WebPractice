package com.jian.websecond;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hobby")
public class HobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<HobbyEntity> list = DAO.selHobbyList();
		request.setAttribute("list", list);

		
		String jsp = "/WEB-INF/jsp/Hobby.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String str_i_hobby = request.getParameter("i_hobby");
		String nm = request.getParameter("nm");
		int i_hobby = Integer.parseInt(str_i_hobby);
		
		System.out.println("i_hobby : " + i_hobby);
		System.out.println("nm : " + nm);
		
		//TODO : 등록처리
		HobbyEntity param = new HobbyEntity();
		param.setI_hobby(i_hobby);
		param.setNm(nm);
		int result = DAO.insHobby(param);
		
		response.sendRedirect("/WebSecond/hobby");
		// 주소로 요청을 하는 것
	}
		
}
