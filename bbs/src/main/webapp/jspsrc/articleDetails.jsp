<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.article.title}...</title>
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
</body>
</html>