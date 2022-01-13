package com.poscoict.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.guestbook.dao.GuestbookDao;
import com.poscoict.guestbook.vo.GuestbookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = String.valueOf(request.getParameter("a"));

		switch (actionName) {
		case "deleteform":
			request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp").forward(request, response);
			break;
		case "delete":
			long no = Long.parseLong(request.getParameter("no"));
			String password = request.getParameter("password");
			boolean result = new GuestbookDao().delete(no, password);
			response.sendRedirect(request.getContextPath() + "/gb");
			break;
		case "add":
			GuestbookVo vo = new GuestbookVo();
			vo.setName(request.getParameter("name"));
			vo.setPassword(request.getParameter("password"));
			vo.setMessage(request.getParameter("message"));
			new GuestbookDao().insert(vo);

			response.sendRedirect(request.getContextPath() + "/gb");
			break;
		default:
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.findAll();

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
