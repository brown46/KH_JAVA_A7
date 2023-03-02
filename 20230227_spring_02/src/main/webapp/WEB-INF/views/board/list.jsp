<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판</h1>
<c:forEach items="${boardList }" var="board">
	${board.boardNum } <br>
</c:forEach>
	<br>

	<hr>
	<c:forEach var="list" 
		begin="${pageInfo.startPage }" end="${pageInfo.endPage }" varStatus="idx">
${list }
<c:if test="${pageInfo.endPage !=list}">
,
</c:if>
	</c:forEach>
</body>
</html>