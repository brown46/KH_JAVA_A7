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
<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
<c:forEach items="${boardList }" var="board">
		<tr>
			<td>${board.boardNum }</td>
			<td><a href="<%=request.getContextPath()%>/board/read?boardNum=${board.boardNum}"> ${board.boardTitle }</a></td>
			<td>${board.boardWriter }</td>
			<td>${board.boardDate }</td>
			<td>${board.boardReadcount }</td>
		</tr>
		
</c:forEach>		
		
</table>


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