package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
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
	
	Map<String, Boolean> sMap = new HashMap<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("passwd");
		ServletContext context = getServletContext();

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
			sMap.put(user.getName(), true);
			context.setAttribute("smap", sMap);
			response.sendRedirect("/bbs/jspsrc/index_auth.jsp");
		} else {
			out.printf("<h1>로그인 실패</h1><hr>");
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		sMap.remove(((UserVO) session.getAttribute("login_user")).getName());
		context.setAttribute("smap", sMap);
		session.invalidate();
		response.sendRedirect("/bbs/jspsrc/index.jsp");
	}

}
