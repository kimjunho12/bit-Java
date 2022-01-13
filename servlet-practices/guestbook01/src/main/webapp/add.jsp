<%@page import="com.poscoict.guestbook.vo.GuestbookVo"%>
<%@page import="com.poscoict.guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
GuestbookDao dao = new GuestbookDao();
GuestbookVo vo = new GuestbookVo();
vo.setName(request.getParameter("name"));
vo.setPassword(request.getParameter("password"));
vo.setMessage(request.getParameter("message"));
boolean result = dao.insert(vo);

response.sendRedirect("/guestbook01/index.jsp");
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