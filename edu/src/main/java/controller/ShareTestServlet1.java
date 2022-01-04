package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;

@WebServlet("/sharetest1")
public class ShareTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		CountVO vo = new CountVO();
		vo.setNumber(param);
		request.setAttribute("objreq", vo);
		request.getRequestDispatcher("/jspsrc/share1.jsp").forward(request, response);
	}
}
