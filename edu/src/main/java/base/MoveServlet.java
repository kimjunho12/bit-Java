package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String webname = request.getParameter("action");

		String reURL = "";

		switch (String.valueOf(webname)) {
		case "null":
			PrintWriter out = response.getWriter();
			out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");
			out.close();
			return;
		case "naver":
			reURL = "http://naver.com";
			break;
		case "daum":
			reURL = "http://daum.net";
			break;
		case "google":
			reURL = "http://google.com";
			break;
		default:
			reURL = "http://localhost:8080/edu/move";
		}
		response.sendRedirect(reURL);

	}
}