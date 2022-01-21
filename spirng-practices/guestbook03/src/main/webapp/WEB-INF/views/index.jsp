<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("newline", "\n");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	<br>

	<table width=510 border=1>
		<c:set var="length" value="${fn:length(list) }" />
		<c:forEach items="${list }" var="vo" varStatus="status">
			<tr>
				<td>${length-status.index }</td>
				<td>${vo.name }</td>
				<td>${vo.reg_date }</td>
				<td><a
					href="${pageContext.request.contextPath }/delete/${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>${fn:replace(vo.message, newline, "<br>") }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>