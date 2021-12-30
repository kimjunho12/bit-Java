<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제 1</title>
</head>
<body>
<h1>JSP 맛보기</h1><hr>
<h3>현재 시간 정보 : <%= LocalDateTime.now() %></h3>	<!-- %= : 표현식 -->

</body>
</html>