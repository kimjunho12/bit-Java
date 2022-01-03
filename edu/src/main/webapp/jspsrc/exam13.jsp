<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 내장 객체들</title>
</head>
<body>
	<h2>JSP의 내장 객체들 점검</h2>
	<h3>[ request ]</h3>
	getMethod() :	<%=request.getMethod()%><br>
	getRequestURI() :	<%=request.getRequestURI()%><br>
	getHeader("user-agent") :	<%=request.getHeader("user-agent")%><br>
	<h3>[ out ]</h3>
	<%
	out.print("<h4>out 내장 객체로 출력!!</h4>");
	%>
	<jsp:scriptlet >Integer num1 = 2315651; out.print(num1);</jsp:scriptlet>
	<jsp:scriptlet >out.print("DD");</jsp:scriptlet>
	<jsp:expression >num1</jsp:expression>
	
	
	<h3>[ session ]</h3>
	getId() :	<%=session.getId()%><br>
	getCreationTime() :	<%=new Date(session.getCreationTime())%><br>
	<h3>[ response ]</h3>
	getStatus() :	<%=response.getStatus()%><br>
	getBufferSize() :	<%=response.getBufferSize()%><br>
	getContentType() :	<%=response.getContentType()%>
	<%
	response.addCookie(new Cookie("myCookie", "myValue"));
	%>
	<h3>[ application ]</h3>
	getContextPath() :	<%=application.getContextPath()%><br>
	getServerInfo() :	<%=application.getServerInfo()%><br>
	getMajorVersion() :	<%=application.getMajorVersion()%><br>
	<H4>Web Application(/edu) 디렉토리의 파일 리스트</H4>
	<%
	java.util.Set<String> list = application.getResourcePaths("/");
	if (list != null) {
		Object obj[] = list.toArray();
		for (int i = 0; i < obj.length; i++) {
			out.print(obj[i] + ", ");
		}
	}
	%>
</body>
</html>