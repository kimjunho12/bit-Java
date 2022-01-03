<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate, java.time.LocalDateTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
</head>
<body>
	<%
	LocalDate ld = LocalDate.now();
	%>
	<%=ld.getYear()%>년
	<%=ld.getMonthValue()%>월
	<%=ld.getDayOfMonth()%>일
	<hr>
	<%
	LocalDateTime ldt = LocalDateTime.now();
	%>
	<%=ldt.getYear()%>년
	<%=ldt.getMonthValue()%>월
	<%=ldt.getDayOfMonth()%>일
	<%=ldt.getHour()%>시
	<%=ldt.getMinute()%>분
	<%=ldt.getSecond()%>초
</body>
</html>


