<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#create").click(function() {
			var vo = {
				name : "둘리",
				email : "dooly@gmail.com",
				password : "1234",
				gender : "male"
			}

			$.ajax({
				url : "${pageContext.request.contextPath}/api/user",
				async : true,
				type : 'post', // 요청 메소드
				dataType : "json", // 응답 포맷
				contentType : "application/json",
				data : JSON.stringify(vo),
				success : function(response) {
					if (response.result !== "success") {
						console.error(response.message);
						return;
					}
					console.log(response);
				}
			});

		});

		$("#read").click(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/api/user",
				async : true,
				type : 'get', // 요청 메소드
				dataType : "json", // 응답 포맷
				contentType : "application/json",
				success : function(response) {
					if (response.result !== "success") {
						console.error(response.message);
						return;
					}
					console.log(response);
				}
			});

		});

		$("#update").click(function() {
			var vo = {
				name : "둘리2",
				email : "dooly2@gmail.com",
				password : "1234",
				gender : "male2"
			}

			$.ajax({
				url : "${pageContext.request.contextPath}/api/user/10",
				async : true,
				type : 'put', // 요청 메소드
				dataType : "json", // 응답 포맷
				contentType : "application/json",
				data : JSON.stringify(vo),
				success : function(response) {
					if (response.result !== "success") {
						console.error(response.message);
						return;
					}
					console.log(response);
				}
			});

		});

		$("#delete").click(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/api/user/10",
				async : true,
				type : 'delete', // 요청 메소드
				dataType : "json", // 응답 포맷
				contentType : "application/x-www-form-urlencoded",
				data : "password=1234",
				success : function(response) {
					if (response.result !== "success") {
						console.error(response.message);
						return;
					}
					console.log(response);
				}
			});

		});
	})
	
</script>
</head>

<body>
	<h1>AJAX Test : RESTful API</h1>
	<button id="create">Create(POST)</button>
	<br>
	<br>
	<button id="read">Read(GET)</button>
	<br>
	<br>
	<button id="update">Update(PUT)</button>
	<br>
	<br>
	<button id="delete">Delete(DELETE)</button>
	<br>
	<br>
</body>
</html>