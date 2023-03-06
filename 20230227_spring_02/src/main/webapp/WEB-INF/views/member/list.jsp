<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 회원목록</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
<style>
.f-3 {
	display: flex;
	width: 300px;
	height: 50px;
	width: 400px
}

.f-3 div {
	border: 1px black solid;
	width: 33%
}
</style>
</head>
<body>
	<div class="f-3">
		<div>아이디</div>
		<div>이름</div>
		<div>이메일</div>
	</div>
	<c:forEach items="${memberList }" var="member">
			<a href="<%=request.getContextPath()%>/member/info?id=${member.id}">
		<div class="f-3">
				<div>${member.id }</div>
				<div>${member.name }</div>
				<div>${member.email }</div>
		</div>
			</a>
	</c:forEach>
</body>
</html>