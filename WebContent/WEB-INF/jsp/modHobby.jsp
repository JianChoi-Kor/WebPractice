<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modHobby</title>
<script defer src="js/common.js"></script>
</head>
<body>
	<div>
		<form id="frm" action="/WebSecond/modHobby" method="post" onsubmit="return hobbyChk();">
			<label>i_hobby : <input type="text" name="i_hobby" value="${param.i_hobby}" readonly></label>
			<label>취미 : <input type="text" name="hobby"></label>
			<input type="submit" value="등록">
		</form>
		${param}
	</div>
</body>
</html>