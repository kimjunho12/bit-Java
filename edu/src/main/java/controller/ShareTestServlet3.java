package controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;

@WebServlet("/sharetest3")
public class ShareTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		ServletContext context = getServletContext();	// ServletContext를 반환하는 팩토리메소드
		if (context.getAttribute("objapp") == null) {
			context.setAttribute("objapp", new CountVO());
		}
		CountVO vo = (CountVO) context.getAttribute("objapp");
		vo.setNumber(param);

		request.getRequestDispatcher("/jspsrc/share3.jsp").forward(request, response);
	}
}
