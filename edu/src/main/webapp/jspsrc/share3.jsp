<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.CountVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
</head>
<body>
<h2>서블릿이 전달한 객체(application)</h2>
<hr>
<%
	CountVO vo = (CountVO)application.getAttribute("objapp");
    if(vo != null) {
%>
		추출된 값 : <%= vo.getNumber() %><br>	
<%
    } else {
%>
    	추출된 객체가 없슈!!
<%	
    }
%>
</body>
</html>



