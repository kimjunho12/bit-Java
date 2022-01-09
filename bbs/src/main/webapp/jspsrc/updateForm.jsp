<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<h1>글을 수정 중입니다.</h1>
<hr>
<form action="/bbs/article" method="post"> <!-- enctype="multipart/form-data"> -->
	<input type="hidden" name="action" value="update">
	제목 : <input type="text" name="title" required><br>
	내용 : <textarea name="content" rows="10" cols="35" required></textarea><br>
	파일 : <input type="file" name="file_path">
	<input type="submit" value="작성">	
</form>

</body>
</html>