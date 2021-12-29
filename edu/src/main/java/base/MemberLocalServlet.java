package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;				// 객체 생성 시 메모리 할당 (모든 클라이언트가 공유) / 서버 중단 or Reload전 까지 유지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;			// 메소드 실행 시 메모리 할당 후 메소드 종료 시 사라짐
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		member_v += 10;
		local_v += 10;
		out.print("<ul>");
		out.print("<li>멤버변수 : "+ member_v +"</li>");
		out.print("<li>지역변수 : "+ local_v +"</li>");
		out.print("</ul>");
		out.close();		
	}
	
	
}
