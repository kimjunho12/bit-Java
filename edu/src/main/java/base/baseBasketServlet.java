package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/basket")
public class baseBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
		out.printf("<h1>선택한 상품 : %s</h1>", pid);
		out.printf("<img src='/edu/images/%d.jpg'><hr>", Integer.valueOf(pid.substring(pid.length()-3, pid.length())));
		out.printf("<a href='%s'>상품 선택 화면</a>", request.getHeader("referer"));
	}
}
