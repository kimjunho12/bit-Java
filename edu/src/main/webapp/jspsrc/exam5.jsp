<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>선언문 태그</h1>
<hr>
<%!
	int multiply(int n1, int n2) {
		return n1 * n2;
	}
%>
<%
	int result=0;
	if(request.getMethod().equals("GET")) {
%>
		<h3>숫자 2개를 입력하세요</h3>
		<form method="post" action="/edu/jspsrc/exam5.jsp">
			숫자 1 <input type="number" name="su1"><br>
			숫자 2 <input type="number" name="su2"><br>
			<input type="submit">
		</form>
<%	
	} else {
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		result = multiply(su1, su2);	
%>
		<h2>수행 결과 : <%= result %></h2>
		<a href="<%= request.getHeader("referer") %>"> 입력 화면으로 </a>
<%
	}
%>
</body>
</html>









