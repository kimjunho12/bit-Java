package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String pid = request.getParameter("pid");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if (pid == null) {
			session.invalidate();
			out.print("상품이 모두 삭제되었습니다.<br>");
			out.print("<br><a href='/edu/htmlexam/productlog2.html'>상품 선택화면</a>");
			out.close();
			return ;
		}		
		if (session.getAttribute("pid") == null)
			session.setAttribute("pid", new int[11]);
		int index = Integer.parseInt(pid.replace("p", ""));
		int[] data = (int[]) session.getAttribute("pid");
		data[index]++;
		
		out.print("<h3>선택한 상품 리스트</h3>");
		out.print("<hr>");
		out.print("<ul>");
		for (int i = 1; i <= 10; ++i) {
			if (data[i] > 0) 
				out.print("<li> p0" + ((i >= 10) ? "" : "0") +i + " 상품 " + data[i] + "개</li>");
		}		
		out.print("</ul>");
		out.print("<br><a href='" + request.getHeader("referer") + "'>상품 선택화면</a> ");
		out.print("<a href='/edu/basket2'>상품비우기</a>");
		out.close();
	}
}
