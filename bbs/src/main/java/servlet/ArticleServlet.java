package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		String action = request.getParameter("action");
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		ArticleVO article = new ArticleVO();
		ArticleDAO dao = new ArticleDAO();
		String dest = "/jspsrc/index.jsp";
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("login_user");
		switch (action) {
		case "delete":
			dao.deleteArticle(article_id);
			break;
		case "read":
			if (user == null) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('로그인이 필요합니다.'); location.href='/bbs/auth/login.html'</script>");
				out.close();
				return;
			}
			article = dao.readOneArticle(article_id);
			request.setAttribute("article", article);
			dest = "/jspsrc/articleDetails.jsp";
			break;
		case "update":
			article = dao.readOneArticle(article_id);
			request.setAttribute("article", article);
			dest = "/jspsrc/updateForm.jsp";
		default:
			List<ArticleVO> aList = dao.readAllArticles();
			request.setAttribute("aList", aList);
		}
		request.getRequestDispatcher(dest).forward(request, response);
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
		case "update":
			article.setArticle_id(Integer.parseInt(request.getParameter("article_id")));
			dao.updateArticle(article);
			break;
		}
		response.sendRedirect("/bbs/jspsrc/index.jsp");
	}

}
