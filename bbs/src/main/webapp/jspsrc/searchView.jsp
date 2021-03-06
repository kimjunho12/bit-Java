<%@page import="model.dao.ArticleDAO"%>
<%@page import="model.vo.ArticleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
String key = request.getParameter("key");
String word = request.getParameter("search");
ArticleDAO dao = new ArticleDAO();
List<ArticleVO> aList;
switch (key) {
case "name":
	aList = dao.readUserArticles(word);
	break;
case "content":
	aList = dao.readContArticles(word);
	break;
case "title":
	aList = dao.readTitleArticles(word);
	break;
default:
	aList = dao.readConTitleArticles(word);
}
%>
<title><%=word%> 검색 결과</title>
<style>
.article {
	background-color: #DDDDDD;
	text-align: left;
	width: 80%;
	padding: 16px;
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
	<div>
		<div class="article">
			<%
			if (key.equals("name")) {
				out.print(word + "님 글 목록");
			} else {
				if (key.isBlank())
					key = "전체";
				out.print(key + "로 \"" + word + "\" 검색 결과");
			}
			%>
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
		<button onclick="location.href='/bbs/jspsrc/index.jsp'" style="margin-top: 8px">홈
			화면으로</button>
	</div>
</body>
</html>