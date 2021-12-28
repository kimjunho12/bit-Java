package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querytest")
public class QueryTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("stname");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));
		
		String gender = request.getParameter("gender");
		
		String[] hobby = request.getParameterValues("hobby");
		String[] food = request.getParameterValues("food");
		
		String color = request.getParameter("color");
		String op = request.getParameter("op");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h2> 전달된 내용 </h2>"); out.print("<hr>");
		
		
		out.print("<ul>");
		out.print("<li> 이름 : " +name+ "</li>");
		out.print("<li> 암호 : " +pwd+ "</li>");
		out.print("<li> 나이 : " +age+ "</li>");
		
		out.print("<li> 성별 : ");
			if (gender == null) {
				out.print("선택 제대로 하세요 -ㅅ-");	
			}
			else {
				out.print(gender);
			}
		out.print("</li>");
		
		out.print("<li> 취미 : ");
			if (hobby == null) {
				out.print("선택 제대로 하세요 -ㅅ-");	
			}
			else {
				for (int i=0 ; i<hobby.length ; ++i) {
					if (i == hobby.length -1) {
						out.print(hobby[i]);
						break;
					}
					out.print(hobby[i] +",");
				}
			}
		out.print("</li>");
		
		out.print("<li> 좋아하는 색 :" +(color == ""?"없음":color) +"</li>");
		out.print("<li> 좋아하는 음식 : ");
		if (food == null) {
			out.print("선택 제대로 하세요 -ㅅ-");	
		}
		else {
			for (int i = 0; i < food.length; ++i) {
				if (i == food.length - 1) {
					out.print(food[i]);
					break;
				}
				out.print(food[i] +",");
			}
		}
		out.print("</li>");
		
		
		out.print("<li> 의견 : " + op + "</li>");
		out.print("<li> 비밀1 : " + request.getParameter("h_1") + "</li>");
		out.print("<li> 비밀2 : " + request.getParameter("h_2") + "</li>");
		
		
		out.print("</ul>"); out.print("<hr>");
		out.print("<a href='/edu/htmlexam/querytest.html'>"
				+ "입력화면으로</a>");
		
		out.close();
	}

}
