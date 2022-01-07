package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.vo.UserVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("passwd");

		if (email.equals("admin") && pw.equals("admin")) {
			return;
		}

		UserDAO dao = new UserDAO();
		UserVO user = dao.readOneUser(email, pw);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		if (user != null) {
			out.printf("<h1>%s 로그인 성공</h1><hr>", user.getName());
			out.printf("<h1>%s 로그인 성공</h1><hr>", dao.readOneUser(user.getUid()));
			HttpSession session = request.getSession();
			session.setAttribute("login_user", user);
			response.sendRedirect("/bbs/jspsrc/index.jsp");
		} else {
			out.printf("<h1>로그인 실패</h1><hr>");
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/bbs/jspsrc/index.jsp");
	}

}
