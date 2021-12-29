package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessiontest2")
public class SessionTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		out.print("생성된 세션객체의 ID : "+session.getId());
		out.print("<br>세션 객체가 생성된 시간 : "
				      + new Date(session.getCreationTime()));
		out.print("<br>현재 시간 : " + new Date());
		out.close();
	}
}








