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
	read.jsp <br>
	게시글 번호:${param1 } <br>
	<c:forEach var="list" items="${boardList }">
		<c:if test="${list.boardNum eq param1 }">
			${list } <br>
		</c:if>
	</c:forEach>
<br>


</body>
</html>