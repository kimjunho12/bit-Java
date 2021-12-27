import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>FirstServlet 수행완료</h1>");
		out.print("<hr>");
		out.print("<h2>요청방식 : " + request.getMethod() + "<h2>");
		out.print("<h2>반가워요... : " + request.getParameter("name") + "님!!<h2>");
		out.close();
		System.out.println("서블릿에서의 표준 출력은 어디로 나갈까요?");
		
	}

}
