<%@page import="model.dao.ArticleDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.vo.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<style>
div {
	padding: 16px;
	margin: 16px;
	background-color: silver;
	text-align: center;
}

span {
	padding: 8px;
}

.article {
	background-color: #DDDDDD;
	text-align: left;
	width: 80%;
}

td {
	border-bottom: 1px dotted green;
	text-align: center;
	padding-left: 8px;
	padding-right: 8px;
	padding-top: 5px;
	padding-bottom: 5px;
}

#trheader {
	text-align: center;
	background-color: #999999;
}

tr:hover {
	background-color: yellow;
	font-weight: bold;
}

td:nth-child(3) {
	width: 50%;
}
</style>
</head>
<body>
	<%
	if (session.getAttribute("login_user") == null) {
		request.getRequestDispatcher("/bbs/jspsrc/index.html").forward(request, response);
		return;
	}
	List<ArticleVO> aList = new ArticleDAO().readAllArticles();
	List<ArticleVO> popList = new ArticleDAO().readPopArticles();
	%>
	<div>
		<form action="/bbs/jspsrc/searchView.jsp">
			<span style="background-color: green;">게시팥</span> <select name="key">
				<option></option>
				<option value="name">이름</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select> <input type="search" name="search" placeholder="검색어를 입럭하세요">
			<span style="float: right;"> <span>${ sessionScope.login_user.name }님</span>
				<a href="/bbs/login">로그아웃</a> <a href="/bbs/jspsrc/mypage.jsp">마이페이지</a>
			</span>
		</form>
	</div>
	<div>
		main <a style="float: right;" href="/bbs/static/writeForm.html"><span>새
				글 작성</span></a>
		<div class="article">
			최신글
			<table style="width: 100%">
				<tr id="trheader">
					<td><strong>작성자</strong></td>
					<td><strong>작성일</strong></td>
					<td><strong>제목</strong></td>
					<td><strong>조회수</strong></td>
				</tr>
				<%
				for (ArticleVO vo : aList) {
				%>
				<tr
					onClick="location.href='/bbs/article?action=read&article_id=<%=vo.getArticle_id()%>'">
					<td><%=vo.getWriter_name()%></td>
					<td><%=vo.getWrite_date()%></td>
					<td><%=vo.getTitle()%></td>
					<td><%=vo.getView_cnt()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<div class="article">
			인기글
			<table style="width: 100%">
				<tr id="trheader">
					<td><strong>작성자</strong></td>
					<td><strong>작성일</strong></td>
					<td><strong>제목</strong></td>
					<td><strong>조회수</strong></td>
				</tr>
				<%
				for (ArticleVO vo : popList) {
				%>
				<tr
					onClick="location.href='/bbs/article?action=read&article_id=<%=vo.getArticle_id()%>'">
					<td><%=vo.getWriter_name()%></td>
					<td><%=vo.getWrite_date()%></td>
					<td><%=vo.getTitle()%></td>
					<td><%=vo.getView_cnt()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
	<div>footer</div>
</body>
</html>