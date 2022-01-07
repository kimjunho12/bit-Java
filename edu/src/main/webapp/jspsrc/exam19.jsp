<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="jspbean.Today"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Poor+Story:400"
	rel="stylesheet">
</head>
<body>
	<h1 style="font-family: 'Poor Story';">
		지금은
		<%
	pageContext.setAttribute("obj", new Today());
	%>
		${obj.year}년 ${obj.month}월 ${obj.date}일 ${obj.hour}시 ${obj.minute}분
		입니당
	</h1>
</body>
</html>