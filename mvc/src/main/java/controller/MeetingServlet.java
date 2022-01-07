package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Meeting;
import dao.MeetingDAO;
import vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");

		Meeting dao = new MeetingDAO();
		if(keyword == null) {
			if(action != null) {
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "글이 성공적으로 삭제되었습니다.");
				} else {
					request.setAttribute("msg", "글이 삭제되지 않았습니다.");
				}				
			} 		
			request.setAttribute("list", dao.listAll());
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if (list != null && list.size() == 0) {
				request.setAttribute("msg", keyword + "(이)가 포함된 글이 없습니다.");
			} else {
				request.setAttribute("list", dao.search(keyword));
			}
		}
		request.getRequestDispatcher("/jspsrc/meetingView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");
		Meeting dao = new MeetingDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			if (result) {			
				request.setAttribute("msg", name + "님의 글이 성공적으로 입력되었습니다.");			
			} else {
				request.setAttribute("msg", name + "님의 글이 입력되지 않았습니다.");
			}
		} else {
			vo.setId(Integer.parseInt(action));
			boolean result = dao.update(vo);
			if (result) {			
				request.setAttribute("msg", name + "님의 글이 성공적으로 수정되었습니다.");			
			} else {
				request.setAttribute("msg", name + "님의 글이 수정되지 않았습니다.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspsrc/meetingView.jsp").forward(request, response);
	}
}
