<%@page import="model.dto.VisitDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% VisitDTO d=(VisitDTO)request.getAttribute("data");%>
	<div>
		<a href="../visit">돌아가기</a>
	</div>
	<form action="./update" method="post">
		<label>닉네임 수정</label>
		<input name="nickname" type="text" value=<%= d.getNickname()%>>
		<label>내용 수정</label>
		<input name="context" type="text" value=<%=d.getContext() %>>
		<input name="createdate" type="hidden" value=<%=d.getCreateDate().getTime()%>>
		<button type="submit" >수정</button>
	</form>
</body>
</html>