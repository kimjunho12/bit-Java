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
</style>
</head>
<body>
	<%
	if (session.getAttribute("login_user") == null) {
		request.getRequestDispatcher("/static/index.html").forward(request, response);
		return;
	}
	%>
	<div>
		<span style="background-color: green;">게시팔</span> <input type="search">
		<span>${ sessionScope.login_user.name }님</span>
		<a href="/bbs/login">로그아웃</a>
		<a href="/bbs/jspsrc/mypage.jsp">마이페이지</a>
	</div>
	<div>
		main
	</div>
	<div>footer</div>
</body>
</html>