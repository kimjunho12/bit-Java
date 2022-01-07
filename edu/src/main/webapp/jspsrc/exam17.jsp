<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="jspbean.Today"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Dokdo:400"
	rel="stylesheet">
</head>
<body>
	<h1 style="font-family: 'Dokdo'">
		지금은
		<%
	Today obj = new Today();
	%>
		<%=obj.getYear()%>년
		<%=obj.getMonth()%>월
		<%=obj.getDate()%>일
		<%=obj.getHour()%>시
		<%=obj.getMinute()%>분 입니당
	</h1>
</body>
</html>