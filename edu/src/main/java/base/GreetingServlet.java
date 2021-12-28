package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(String.format("<h2> %s 님 반가워요.. 오늘은 %s요일입니다!!</h2>",
				request.getParameter("guestname") == null ? "손님" : request.getParameter("guestname"),
				LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.NARROW, Locale.KOREAN)));
	}

}
