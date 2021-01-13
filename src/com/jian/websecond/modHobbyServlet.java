package com.jian.websecond;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modHobby")
public class modHobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_hobby = Integer.parseInt(request.getParameter("i_hobby"));
		System.out.println("i_hobby : " + i_hobby);
		
		String jsp = "/WEB-INF/jsp/modHobby.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_hobby = Integer.parseInt(request.getParameter("i_hobby"));
		System.out.println("i_hobby : " + i_hobby);
		
		String nm = request.getParameter("hobby");
		System.out.println("nm : " + nm);
		
		HobbyEntity param = new HobbyEntity();
		param.setI_hobby(i_hobby);
		param.setNm(nm);
		
		int result = DAO.udpHobby(param);
		
		response.sendRedirect("/WebSecond/hobby");
	}

}
