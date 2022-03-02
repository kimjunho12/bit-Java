<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script type="text/javascript">
	var render = function(vo) {
		var html =
			"<li data-no='" + vo.no + "'>"
			+ "<strong>" + vo.name + "</strong>"
			+ "<p>" + vo.message + "</p>"
			+ "<a href='' data-no='" + vo.no + "'>삭제</a>"
			+ "</li>"
		return html;
	}

	var fetch = function() {
		$.ajax({
			url : "${pageContext.request.contextPath }/api/guestbook/list",
			type : "get",
			dataType : "json",
			contentType : 'application/json',
			success : function(response) {
				if (response.result !== 'success') {
					console.error(response.message);
					return;
				}
				
				for (var i = 0; i < response.data.length; i++) {
					var vo = response.data[i];
					$("#list-guestbook").append(render(vo));
				}
				
			}
		});
	}

	$(function() {
		// 삭제 다이얼로그 객체 만들기
		var dialogDelete = $("#dialog-delete-form").dialog({
			autoOpen : false,
			modal: true,
			buttons: {
				"삭제" : function() {
					var no = $("#hidden-no").val();
					var password = $("#password-delete").val();
					var url = "${pageContext.request.contextPath }/api/guestbook/delete/" + no;
					
					$.ajax({
						url: url,
						type: 'post',
						dataType: 'json',
						data: "password=" + password,
						success: function(response) {
							if(response.result !== "success"){
								console.error(response.message);		
								return ;
							}
							
							console.log(response.data);
							
							// 삭제 실패 경우(비밀번호 불일치)
							if (response.data === -1) {
								$(".validateTips.error").show();
								$("#password-delete").val("").focus();
								return ;
							}
							
							// 삭제가 된 경우
							$("#list-guestbook li[data-no='" + response.data + "']").remove();
							dialogDelete.dialog('close');							
						}
					});
				},
				"취소" : function() {
					$(this).dialog("close");
				}
			},
			close: function() {
				$(".validateTips.error").hide();
				
				$("#password-delete").val("");
				$("#hidden-no").val("");
			}
			
		});
		
		// 글 삭제 버튼 클릭 이벤트 (Live Event 처리)
		$(document).on("click", "#list-guestbook li a", function(event) {
			event.preventDefault();
			
			var no = $(this).attr("data-no");	// == $(this).data("no")
			$("#hidden-no").val(no);
			
			dialogDelete.dialog("open");
		});
				
		// 최초 리스트 가져오기
		fetch();
	});
</script>
</head>
<body>
	<div id="guestbook">
		<h1>방명록</h1>
		<form id="add-form" action="" method="post">
			<input type="text" id="input-name" placeholder="이름"> <input
				type="password" id="input-password" placeholder="비밀번호">
			<textarea id="tx-content" placeholder="내용을 입력해 주세요."></textarea>
			<input type="submit" value="보내기" />
		</form>
		<ul id="list-guestbook">

		</ul>
	</div>
	<div id="dialog-delete-form" title="메세지 삭제" style="display: none">
		<p class="validateTips normal">작성시 입력했던 비밀번호를 입력하세요.</p>
		<p class="validateTips error" style="display: none">비밀번호가 틀립니다.</p>
		<form>
			<input type="password" id="password-delete" value=""
				class="text ui-widget-content ui-corner-all"> <input
				type="hidden" id="hidden-no" value=""> <input type="submit"
				tabindex="-1" style="position: absolute; top: -1000px">
		</form>
	</div>
	<div id="dialog-message" title="" style="display: none">
		<p></p>
	</div>
</body>
</html>