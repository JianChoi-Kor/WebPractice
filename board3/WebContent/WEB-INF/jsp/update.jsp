<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/update" method="post">
		<input type="hidden" name="i_board" value="${param.i_board}">
		<div><input type="text" name="title" placeHolder="제목" value="${data.title}"></div>
		<div><input type="text" name="writer" placeHolder="작성자" value="${data.writer}"></div>
		<div><textarea name="ctnt" placeholder="내용">${data.ctnt}</textarea></div>
		<div>
			<input type="submit" value="글 수정">
			<input type="reset" value="다시 작성">
		</div>
	</form>
</body>
</html>