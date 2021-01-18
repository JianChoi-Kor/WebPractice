<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.jian.websecond.HobbyEntity" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%
	List<HobbyEntity> list = (List)request.getAttribute("list");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hobby</title>
<script defer src="js/common.js"></script>
</head>
<body>
	<div>
		<form id="frm" action="/WebSecond/hobby" method="post" onsubmit="return hobbyChk();">
			<label> 번호 : <input type="text" name="i_hobby"></label>
			<label> 취미 : <input type="text" name="nm"></label>
			<input type ="submit" value="등록">
		</form>	
	</div>
	<table>
		<tr>
			<th>i_hobby</th>
			<th>취미</th>
		</tr>
			
	<% for(HobbyEntity vo : list) { %>
		<tr>
			<td><%=vo.getI_hobby() %></td>
			<td><%=vo.getNm() %></td>
			<td>
				<button onclick="chkDel(<%=vo.getI_hobby() %>)">삭제</button>
				<a href="/WebSecond/modHobby?i_hobby=<%=vo.getI_hobby() %>"><button>수정</button></a>
			</td>
		</tr>		
	<% } %>	
	</table>
</body>
</html>