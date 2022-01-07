package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ProductVO;

@WebServlet("/cart")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("prod") == null)
			session.setAttribute("prod", new ProductVO());
		
		ProductVO prod = (ProductVO) session.getAttribute("prod");
		
		String pid = request.getParameter("pid");
		switch (pid) {
		case "p001" : 
			prod.setAppleCnt();
			break;
		case "p002" :
			prod.setBananaCnt();
			break;
		case "p003" :
			prod.setHalabongCnt();
			break;
		default : 
			System.err.println("부정확한 상품코드 전달 : " + request.getRequestURI() + "?" + request.getQueryString());
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('정확한 상품을 선택하세요.'); location.href='/edu/htmlexam/product.html';</script>");
			writer.close();
		}
		
		session.setAttribute("prod", prod);
		request.getRequestDispatcher("/jspsrc/productViewEL.jsp").forward(request, response);		
	}

}
