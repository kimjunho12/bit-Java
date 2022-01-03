<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You Win</title>
</head>
<body>
	<div align="center">
		<h2 align="center" style="color: red"> <%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분에 ")) %>  당첨~~~ 추카추카</h2>
		<br> <img src="/edu/images/win.png">
	</div>
</body>
</html>