package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.vo.UserVO;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		UserVO user = (UserVO) request.getSession().getAttribute("login_user");
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPw(request.getParameter("passwd"));
		user.setPhone(request.getParameter("phone"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		UserDAO dao = new UserDAO();
		if (dao.updateUser(user)) {
			out.println("<h1>정보수정 성공</h1><hr><a href='/bbs/jspsrc/index.jsp'>홈 화면으로</a>");
		} else {
			out.println("<h1>정보수정 실패</h1><hr><a href='/bbs/jspsrc/index.jsp'>홈 화면으로</a>");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		UserVO user = (UserVO) request.getSession().getAttribute("login_user");
		UserDAO dao = new UserDAO();

		switch (action) {
		case "delete_user":
			if (dao.deleteUser(user.getUid())) {
				System.out.printf("%s %s 삭제완료\n", user.getUid(), user.getName());
				request.getSession().invalidate();
				response.sendRedirect("/bbs/jspsrc/index.jsp");
			} else {
				System.out.printf("%s %s 삭제실패\n", user.getUid(), user.getName());
				response.sendRedirect("/bbs/jspsrc/index.jsp");
			}
			break;
		}

	}

}
