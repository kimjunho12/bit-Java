<%@page import="vo.VisitorVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
<style>
td {
	border-bottom: 1px dotted green;
}

tr:hover {
	background-color: yellow;
	font-weight: bold;
}

td:nth-child(3) {
	width: 400px;
}
</style>
</head>
<body>
	<%
	ArrayList<VisitorVO> list = (ArrayList<VisitorVO>) request.getAttribute("list");
	if (list != null) {
	%>
	<h2>방명록 글리스트</h2>
	<hr>
	<table>
		<%
		for (VisitorVO vo : list) {
		%>
		<tr>
			<td><%=vo.getName()%></td>
			<td><%=vo.getWriteDate()%></td>
			<td><%=vo.getMemo()%></td>
			<td><a href='/edu/visitordb2?id=<%=vo.getId()%>&action=delete'>
					<img src="/edu/images/delete.png" width="30">
			</a></td>
			<td><a href='/edu/visitordb2?id=<%=vo.getId()%>&action=update'>
					<img src="/edu/images/edit.png" width="30">
			</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<h2>${ msg }</h2>
	<%
	}
	%>
	<hr>
	<a href="/edu/htmlexam/visitorMain.html">방명록 홈 화면으로 가기</a>
</body>
</html>