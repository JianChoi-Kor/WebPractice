<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.copy.board2.model.Board2Entity" %>   

<% 
	List<Board2Entity> list = (List)request.getAttribute("list");
	int pageLength = (int)request.getAttribute("pageLength");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="/css/common.css">
</head>
<body>
	<div>
		<a href="/board2/write"><button>글쓰기</button></a>
	</div>
	
	<div>
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>등록일시</td>
			</tr>
			<% for(Board2Entity vo : list) { %>
			<tr>
				<td><%=vo.getI_board()%></td>
				<td><a href="/board2/detail?i_board=<%=vo.getI_board()%>"><%=vo.getTitle()%></a></td>
				<td><%=vo.getR_dt()%></td>
			</tr>
			<% } %>
		</table>
		
		<div class="pagingContainer">
			<% for(int i=1; i<=pageLength; i++) { %>
				<span><a href="/board2/list?page=<%=i%>"><%=i%></a></span>
			<% } %>
		</div>	
	</div>
</body>
</html>