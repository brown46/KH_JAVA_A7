<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.BookmarkDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 수정</title>
</head>
<body>
	<div>
		<a href="../bookmark">돌아가기</a>
	</div>
	<h2>수정 폼</h2>
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
</body>
</html>