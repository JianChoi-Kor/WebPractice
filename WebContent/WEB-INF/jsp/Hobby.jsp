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
</head>
<body>
	<h1>hobby</h1>
	
	<div>
		<form action="/WebSecond/hobby" method="post">
			<label> i_hobby : <input type="text" name="i_hobby"></label>
			<label> nm : <input type="text" name="nm"></label>
			<input type ="submit" value="등록">
		</form>
	</div>
	<table>
		<tr>
			<th>i_hobby</th>
			<th>nm</th>
		</tr>
			
	<% for(HobbyEntity vo : list) { %>
		<tr>
			<td><%=vo.getI_hobby() %></td>
			<td><%=vo.getNm() %></td>
		</tr>		
	<% } %>	
	</table>
</body>
</html>