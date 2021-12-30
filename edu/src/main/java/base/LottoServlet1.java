package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNum = (int) (Math.random()*5 + 1);
		int gNum = Integer.valueOf(request.getParameter("num"));
		System.out.printf("전달 된 값 : %d, 추출된 값 : %d\n", gNum, rNum);
		
		RequestDispatcher rd = (rNum == gNum) ? request.getRequestDispatcher("/htmlexam/success.html") : request.getRequestDispatcher("/htmlexam/fail.html");
		rd.forward(request, response);
	}

}
