package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitorget")
public class VisitorGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("<h1>%s 님이 %s에 남긴 글입니다.</h1>",
				request.getParameter("name"),
				LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일", Locale.KOREAN)));
		out.print("<hr>");
		out.printf("내용 : %s<br>", request.getParameter("op"));
		out.print("<a href='/edu/htmlexam/visitorForm.html'>" + "입력화면으로</a>");

		out.close();

	}

}
