package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ArticleDAO;
import model.vo.ArticleVO;
import model.vo.UserVO;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		ArticleVO article = new ArticleVO();
		ArticleDAO dao = new ArticleDAO();
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("login_user");

		article.setWriter_id(user.getUid());
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		article.setFile_path(request.getParameter("file_path"));

		System.out.println(article);

		switch (action) {
		case "insert":
			dao.createArticle(article);
			break;
		}
	}

}
