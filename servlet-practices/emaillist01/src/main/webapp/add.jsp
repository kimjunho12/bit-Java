<%@page import="com.poscoict.emaillist.dao.EmaillistDao"%>
<%@page import="com.poscoict.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String firstName = request.getParameter("fn");
String lastName = request.getParameter("ln");
String email = request.getParameter("email");

EmaillistVo vo = new EmaillistVo();
vo.setFirstName(firstName);
vo.setLastName(lastName);
vo.setEmail(email);

boolean result = new EmaillistDao().insert(vo);

response.sendRedirect("/emaillist01/index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (result) {
	%>
	<h1>잘 들어갔습니다.</h1>
	<%
	} else {
	%>
	<h1>잘 안들어갔습니다.</h1>
	<%
	}
	%>
</body>
</html>