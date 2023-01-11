<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="./main" method="get">
		<div>
			<textarea rows="1" cols="25" name="context" placeholder="즐겨찾기 등록"></textarea>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	<%= request.getParameter("context") %>값 받음
</body>
</html>