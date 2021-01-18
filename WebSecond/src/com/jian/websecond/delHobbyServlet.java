package com.jian.websecond;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delHobby")
public class delHobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_hobby = Integer.parseInt(request.getParameter("i_hobby"));
		System.out.println(i_hobby);
		
		HobbyEntity param = new HobbyEntity();
		param.setI_hobby(i_hobby);
		
		int result = DAO.delHobby(param);
		response.sendRedirect("/WebSecond/hobby");
		
	}

}
