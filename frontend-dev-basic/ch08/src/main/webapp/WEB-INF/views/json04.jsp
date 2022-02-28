<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		$('button').click(function() {

			var vo = {
				name : '둘리',
				password : '1234',
				message : '권린줄 알아요~'
			}

			$.ajax({
				url : "${pageContext.request.contextPath}/api/post02",
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

					var html = "";
					html += ("<h1>" + response.data.no + "</h1>")
					html += ("<h2>" + response.data.name + "</h2>")
					html += ("<h3>" + response.data.message + "</h3>")

					$("#data").append(html);
				}
			});
		});
	})
</script>
</head>

<body>
	<h1>AJAX Test : JSON Format - $.ajax 함수 사용 (Post, form data)</h1>
	<button>데이터 가져오기</button>
	<div id="data"></div>
</body>

</html>