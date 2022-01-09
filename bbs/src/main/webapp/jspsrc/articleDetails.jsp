<%@page import="model.vo.ArticleVO"%>
<%@page import="model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% ArticleVO article = (ArticleVO) request.getAttribute("article"); %>
<meta charset="UTF-8">
<title>${ requestScope.article.writer_name }님의 ${requestScope.article.title}</title>
</head>
<body>
	<h1>${requestScope.article.title}</h1>
	<hr>
	<p style="text-align: right; color: graytext;">
		작성자 : ${ requestScope.article.writer_name },
		작성일시 : ${requestScope.article.write_date },
		조회수 : ${requestScope.article.view_cnt }</p>
	<div style="margin: 5%; background-color: gray; padding: 3%">
		${requestScope.article.content }</div>
	<% if(((UserVO) session.getAttribute("login_user")).getUid() == article.getWriter_id()) {
		out.print("<button onclick=\"location.href='/bbs/article?action=update&article_id="+article.getArticle_id()+"'\" style=\"margin: 4px\">게시글 수정</button>");
		out.print("<button onclick=\"location.href='/bbs/article?action=delete&article_id="+article.getArticle_id()+"'\" style=\"margin: 4px\">게시글 삭제</button>");
	}
	%>
	<button onclick="location.href='/bbs/jspsrc/index.jsp'">홈 화면으로</button>
	
</body>
</html>