<%@page import="java.util.List"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<h1> 회원 정보</h1> <hr>

<%
	List<MemberVO> mList = (List<MemberVO>) request.getAttribute("mlist");
	for (MemberVO mem : mList){
		out.print("<ul>"
				+ "<li> 회원 이름 : " + mem.getName() + "</li><br>"
				+ "<li> 회원 계정 : " + mem.getId() + "</li><br>"
				+ "<li> 회원 암호 : " + mem.getPw() + "</li><br>"
				+ "<li> 회원 전화번호 : " + mem.getPhone() + "</li><br>"
				+ "</ul><br><br>"
				);
	}
%>
</body>
</html>