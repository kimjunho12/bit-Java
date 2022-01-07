<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제 4</title>
</head>
<body>
<h1>Query 문자열 추출(GET&amp;POST)</h1><hr>
	<%
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
		}
	%>
	<h2>당신의 이름은 <%= request.getParameter("name") %> 이군요!!</h2>
	<a href="<%= request.getHeader("referer") %>">입력 화면으로</a>
</body>
</html>