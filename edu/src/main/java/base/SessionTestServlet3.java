package base;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessiontest3")
public class SessionTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
	    String action = request.getParameter("action");
	    HttpSession session = null;
	    String msg = "action=create 또는 action=destroy를 전달하시오."; 
	    if(action != null && action.equals("create")) {
	    	session = request.getSession();	// getSession(true)와 동일
	    	if(session.isNew())				// 새로 생성 된 것인지 확인
	    		msg = "세션 객체가 생성됨";
	    	else 
	    		msg = "세션 객체는 이미 생성되어 있었음";    	
	    } else if (action != null && action.equals("destroy")) {
	    	session = request.getSession(false);	// 생성 없이 추출만 (없으면 null 리턴)
	    	if(session != null) {
	    		session.invalidate();
	    		msg = "세션 객체가 삭제됨";
	    	} else 
	    		msg = "삭제할 세션 객체가 없음";    	
	    }
		 
		out.print("<h2>"+msg+"</h2>");
		out.close();
	}
}








