<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.BookmarkDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 수정</title>
<%@ include file="./module/css_js_import.jsp" %>
</head>
<body>
	<div>
		<c:url var="bookmarkUrl" value="/bookmark"></c:url>
		<a href="${bookmarkUrl }">돌아가기</a>
	</div>
	<h2>수정 폼</h2>
	<form action="${bookmarkUrl }/update" method="post">
		<div>
			<input type="hidden" name="id" value="${requestScope.data.id }" %>
			<label>수정할 url</label>
			<input type="text" name="url" value="${requestScope.data.url }">
			<label>수정할 이름</label>
			<input type="text" name="name" value="${requestScope.data.name }" >
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
	<%--
	<form action="./update" method="post">
	<%BookmarkDTO d=(BookmarkDTO)request.getAttribute("data"); %>
		<div>
			<input type="hidden" name="id" value=<%=d.getId() %>>
			<label>수정할 url</label>
			<input type="text" name="url" value=<%=d.getUrl() %>>
			<label>수정할 이름</label>
			<input type="text" name="name" value=<%=d.getName() %> >
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
	 --%>
</body>
</html>