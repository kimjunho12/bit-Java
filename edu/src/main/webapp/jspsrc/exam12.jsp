<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
</head>
<body>
	<h2>include 지시자와 액션태그 비교</h2>
	<!-- 지시자 include는 해당 jsp 문서를 이 문서에 포함 (servlet으로 바꾸기전 소스코드가 포함 : 1개의 servlet만 생성) -->
<%-- 	<hr>
	<%@ include file="date.jsp"%>
	<hr>
	<%@ include file="date.jsp"%> --%>
	<hr>
	<!-- 액션 태그 include는 jsp 문서의 실행 결과를 문서에 포함 (새로운 servlet을 실행 시킨 뒤 결과 값만 추출) -->
	<jsp:include page="date.jsp" />
	<hr>
	<jsp:include page="date.jsp" />
</body>
</html>