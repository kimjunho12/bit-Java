<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제 3</title>
</head>
<body>
	<h1>표현식 태그 점검</h1> 
	<hr>
	<% int num = 10; %>
	<ul>
		<li> <%= 100 %> </li>
		<li> <%= num %> </li>
		<li> <%= ++num %> </li>
		<li> <%= num*2 %> </li>
		<li> <%= "가나다".length() %> </li>
		<li> <%= num%2 == 0 %> </li>
		<li> <%= request.getParameter("stname") %> </li>
		<li> <%= new java.util.Date(session.getCreationTime()) %> </li>
		<li> <%= application.getServerInfo() %> </li>
		<li> <%= application.getContextPath() %> </li>
	</ul>
</body>
</html>