<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You Lose</title>
</head>
<body>
	<div align="center">
		<h2 align="center" style="color: red"> <%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분에 ")) %>실패~~~ 아쉽아쉽</h2>
		<br> <img src="/edu/images/lose.png"><br> <a
			href="/edu/htmlexam/lottoForm2.html" style="color: red">로또 응모</a>
	</div>
</body>
</html>