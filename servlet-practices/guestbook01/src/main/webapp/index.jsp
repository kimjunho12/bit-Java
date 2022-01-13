<%@page import="com.poscoict.guestbook.dao.GuestbookDao"%>
<%@page import="com.poscoict.guestbook.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
GuestbookDao dao = new GuestbookDao();
List<GuestbookVo> list = dao.findAll();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/add.jsp" method="post">
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
		<%
		int i = list.size();
		for (GuestbookVo vo : list) {
		%>
		<tr>
			<td>[<%=i--%>]</td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReg_date()%></td>
			<td><a
				href="<%=request.getContextPath()%>/deleteform.jsp?no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage().replace("\n", "<br>")%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>