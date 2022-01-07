<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<div>
		<form action="/bbs/mypage" method="post">
			이름 : <input type="text" name="name" required="required" value="${ sessionScope.login_user.name}" readonly="readonly"><br>
			이메일 : <input type="text" name="email" required="required" value="${ sessionScope.login_user.email}" readonly="readonly"><br>
			비밀번호 : <input type="password" name="passwd" required="required" value="${ sessionScope.login_user.pw}"><br>
			비밀번호 확인 : <input type="password" name="passwdv" required="required"><br>
			전화번호 : <input type="text" name="phone" maxlength='11' value="${ sessionScope.login_user.phone}"><br>
			<input type="submit" value="정보 수정"><br>
		</form>
	</div>

</body>
</html>