<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Page</title>
</head>
<body>
	<div><h1>글쓰기</h1></div>
	
	<form action="/write" method="post">
		<div><input type="text" name="title" placeholder="제목"></div>
		<div><input type="text" name="writer" placeHolder="작성자"></div>
		<div><textarea name="ctnt"></textarea></div>
		<div>
			<input type="submit" value="글 등록">
			<input type="reset" value="다시 작성">
		</div>
	</form>
	

</body>
</html>