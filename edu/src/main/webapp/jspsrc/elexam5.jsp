<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 객체의 Scope</title>
</head>
<body>
	<h2>저장된 객체 추출</h2>
	<hr>
	<%
	pageContext.setAttribute("msg", "PageContex객체에 저장된 객체");
	request.setAttribute("msg", "HttpServletRequest 객체에 저장된 객체");
	session.setAttribute("msg", "HttpSession 객체에 저장된 객체");
	application.setAttribute("msg", "ServletContext 객체에 저장된 객체");
	%>
	
	pageScope 객체에서 추출 : ${ pageScope.msg }<br>
	requestScope 객체에서 추출 : ${ requestScope.msg }<br>
	sessionScope 객체에서 추출 : ${ sessionScope.msg }<br>
	applicationScope 객체에서 추출 : ${ applicationScope.msg }<br>
	<hr>
	msg 추출 : ${ msg }<br>
	
</body>
</html>