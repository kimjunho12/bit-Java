package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.printf("<h1>%s님의 예약 내용</h1><hr>", request.getParameter("rname"));
		out.printf("<li>휴양림 : %s</li>", request.getParameter("rtype"));
		String options = "";
		for (String option : request.getParameterValues("roption")) {
			options += option + ", ";
		}
		out.printf("<li>추가 요청 사항 : %s</li>", options.substring(0, options.length()-2));
		String[] date = request.getParameter("rdate").split("-");
		out.printf("<li>예약날짜 : %s년 %s월 %s일</li>", date[0], date[1], date[2]);
		out.close();
	}

}
