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
	<h1>회원 정보</h1>
	<hr>
	<div style="display: none;">
	${ t = mlist.size()-1 }
	</div>
	<ul>
		<li>회원 이름 : ${mlist[t].name}</li>
		<li>회원 계정 : ${mlist[t].id}</li>
		<li>회원 암호 : ${mlist[t].pw}</li>
		<li>회원 전화번호 : ${mlist[t].phone}</li>
	</ul>
</body>
</html>