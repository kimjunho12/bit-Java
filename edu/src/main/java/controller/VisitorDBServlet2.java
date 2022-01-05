package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitorDAO;
import vo.VisitorVO;

@WebServlet("/visitordb2")
public class VisitorDBServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		VisitorDAO dao = new VisitorDAO();
		String target = "/jspsrc/visitorView.jsp";
		if (action != null && action.equals("delete")) {
			boolean result = dao.d(Integer.parseInt(id));
			if (result) {
				request.setAttribute("msg", "글이 성공적으로 삭제되었어요!!");
			} else {
				request.setAttribute("msg", "글 삭제를 실패했어요!!");
			}
		} else if (action != null && action.equals("update")) {
			VisitorVO vo = dao.rOne(Integer.parseInt(id));
			request.setAttribute("updatevo", vo);
			target = "/jspsrc/visitorUpdateView.jsp";
		} else {
			List<VisitorVO> list = dao.r();
			for (VisitorVO vo : list) {
				System.out.println(vo.getMemo());
			}
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher(target).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("gname");
		String memo = request.getParameter("gmemo");
		boolean result = false;
		String word = "삽입";
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName(name);
		vo.setMemo(memo);
		if (id == null) {
			result = dao.c(vo);
		} else {
			vo.setId(Integer.parseInt(id));
			result = dao.u(vo);
			word = "수정";
		}
		if (result) {
			request.setAttribute("msg", String.format("%s님의 글이 성공적으로 %s되었어요!!..", name, word));
		} else {
			request.setAttribute("msg", String.format("%s님의 글의 %s에 실패했어요!!", name, word));
		}
		request.getRequestDispatcher("/jspsrc/visitorView.jsp").forward(request, response);
	}
}
