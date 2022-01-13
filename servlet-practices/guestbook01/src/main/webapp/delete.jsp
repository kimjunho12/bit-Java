<%@page import="com.poscoict.guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
long no = Long.parseLong(request.getParameter("no"));
String password = request.getParameter("password");
GuestbookDao dao = new GuestbookDao();
boolean result = dao.delete(no, password);
response.sendRedirect(request.getContextPath() + "/guestbook01/index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>