<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 수정</h1>

	<form action="update" method="post">
		<input value="${memberVO.id } " type="text" name="id" placeholder="id" readonly="readonly"><br>
		<input value="${memberVO.passwd } " type="password" name="passwd" placeholder="pass"><br>
		<input value="${memberVO.name } " type="text" name="name" placeholder="name" readonly="readonly"><br>
		<input value="${memberVO.email } " type="text" name="email" placeholder="email"><br>
		<button type="submit">제출</button>
	</form>
</body>
</html>