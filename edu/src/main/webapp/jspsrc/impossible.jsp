<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You Win</title>
</head>
<body>
	<h2 align="center" style="color: red">
		더 이상 응모할 수 없어요...
		<%=LocalDateTime.now().plusMinutes(30).format(DateTimeFormatter.ofPattern("HH시 mm분"))%>이후에
		응모하거나 브라우저를 재기동한 후에 응모하세요
	</h2>
</body>
</html>