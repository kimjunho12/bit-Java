<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제 2</title>
</head>
<body>
	<%!int member_v = 0;%> <!-- %! : 선언문(변수, 메서드 정의) -->
	<%
		int local_v = 0;
		member_v += 10;
		local_v += 10;
	%>	<!-- 스크립트릿(수행문) 태그 -->
	<h1>JSP의 멤버 변수와 지역 변수</h1> 
	<hr>
	<ul>
		<li> 멤버 변수 : <%= member_v %> </li> 
		<li> 지역 변수 : <%= local_v %> </li>
	</ul>
</body>
</html>