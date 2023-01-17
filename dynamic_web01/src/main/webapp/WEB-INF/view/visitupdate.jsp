<%@page import="model.dto.VisitDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="staticUrl" value="/static"/>
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
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