<%@page import="model.dto.VisitDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./module/css_js_import.jsp" %>
</head>
<body>
	<% VisitDTO d=(VisitDTO)request.getAttribute("data");%>
	<div>
		<a href="../visit">돌아가기</a>
	</div>
	<form action="./update" method="post">
		<label>내용 수정</label>
		<input name="context" type="text" value=<%=d.getContext() %>>
		<input name="createdate" type="hidden" value=<%=d.getCreateDate().getTime()%>>
		<button type="submit" >수정</button>
	</form>
</body>
</html>