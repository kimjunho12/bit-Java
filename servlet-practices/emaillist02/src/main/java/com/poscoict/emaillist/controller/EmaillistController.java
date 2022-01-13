package com.poscoict.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.emaillist.dao.EmaillistDao;
import com.poscoict.emaillist.vo.EmaillistVo;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = String.valueOf(request.getParameter("a"));

		switch (actionName) {
		case "form":
			request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
			break;
		case "add":

			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");

			EmaillistVo vo = new EmaillistVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);

			boolean result = new EmaillistDao().insert(vo);
			response.sendRedirect(request.getContextPath() + "/el");
			break;
		default:
			EmaillistDao dao = new EmaillistDao();
			List<EmaillistVo> list = dao.findAll();

			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
