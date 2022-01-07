<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
	<h1>선택된 상품 정보는 다음과 같습니다.</h1>
	<hr>
	선택된 사과의 개수 : ${ prod.appleCnt }<br>
	선택된 바나나의 개수 : ${ prod.bananaCnt }<br>
	선택된 한라봉의 개수 : ${ prod.halabongCnt }<br><br>
	<hr>
	<a href="/edu/htmlexam/product.html">상품 선택화면</a>

</body>
</html>