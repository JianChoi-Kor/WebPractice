<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="/board2/list">리스트로 돌아가기</a>
		<a href="/board2/del?i_board=${param.i_board}"><button>삭제</button></a>
		<a href="/board2/update?i_board=${param.i_board}"><button>수정</button></a>
	</div>
	<div>
		<h1>글 번호 : ${param.i_board}</h1>
	</div>
	<div>타이틀 : ${data.title}</div>
	<div>작성일시 : ${data.r_dt}</div>
	<div></div>
	<div>${data.ctnt}</div>
</body>
</html>