package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		if(session.getAttribute("cnt") == null)
			session.setAttribute("cnt", new Cnt(0, false)); // 데이터를 저장할 방을 등록 (저장할 값은 객체로 저장해야함)
		Cnt cntVO = (Cnt) session.getAttribute("cnt");
		System.out.println("응모 횟수 : " + ++cntVO.cnt + " 성공여부 : " + cntVO.isChecked);
		
		if (cntVO.cnt > 3 || cntVO.isChecked) {
			rd = request.getRequestDispatcher("/htmlexam/impossible.html");
			rd.forward(request, response);
			System.out.println("Forwarding to impossible.html");
			return ;
		}	
		
		int rNum = (int) (Math.random()*6 + 1);
		int gNum = Integer.valueOf(request.getParameter("num"));
		System.out.printf("전달 된 값 : %d, 추출된 값 : %d\n", gNum, rNum);
		
		if(rNum == gNum) {
			rd = request.getRequestDispatcher("/htmlexam/success.html");
			cntVO.isChecked = true;
		} else {
			rd = request.getRequestDispatcher("/htmlexam/fail.html");
		}
		rd.forward(request, response);
	}
	
	class Cnt {
		int cnt;
		boolean isChecked;
		
		Cnt(int n, boolean b){
			this.cnt = n;
			this.isChecked = b;
		}
	}

}
