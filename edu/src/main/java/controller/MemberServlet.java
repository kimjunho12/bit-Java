package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

@WebServlet("/enroll")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<MemberVO> mList = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = (String) request.getParameter("mname");
		String phone = (String) request.getParameter("mphone");
		String id = (String) request.getParameter("mid");
		String pw = (String) request.getParameter("mpw");		
				
		MemberVO mem = new MemberVO();
		mem.setName(isNull(name));
		mem.setPhone(isNull(phone));
		mem.setId(isNull(id));
		mem.setPw(isNull(pw));
		
		mList.add(mem);
		
		request.setAttribute("mlist", mList);
		request.getRequestDispatcher("/jspsrc/memberView.jsp").forward(request, response);
	}
	
	private String isNull(String s) {
		if (s == null || s.isEmpty())
			return "없음";
		return s;
	}

}
