<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward/Redirect</title>
</head>
<body>

	<%
	String study = request.getParameter("study");
	if (study != null) {
		switch (study) {
		case "javascript" :
			response.sendRedirect("http://www.w3schools.com/js/default.asp");
			break;
		case "dom" :
			response.sendRedirect("http://www.w3schools.com/js/js_htmldom.asp");
			break;
		case "ajax" :
			response.sendRedirect("http://www.w3schools.com/xml/ajax_intro.asp");
			break;
		case "json" :
			response.sendRedirect("http://www.w3schools.com/js/js_json_intro.asp");
			break;
		case "jsp" :
			%> <jsp:forward page="/jspsrc/exam6.jsp?dan=7"></jsp:forward> <%
			break;
		case "html" :
			%> <jsp:forward page="/htmlexam/first.html"></jsp:forward> <%
			break;
		}
	}
	else {
		out.print("<h2>study 라는 이름으로 전달된 쿼리가 존재하지 않습니다.</h2>");
	}
	%>

</body>
</html>