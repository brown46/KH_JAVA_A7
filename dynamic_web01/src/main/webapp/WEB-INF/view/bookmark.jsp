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
<title>즐겨찾기</title>
<%@ include file="./module/css_js_import.jsp" %>
</head>
<body>
	<%@ include file="./module/top_nav.jsp" %>
	<h2>즐겨찾기</h2>
	<c:url var="bookmarkUrl" value="/bookmark" />
	<form action="${bookmarkUrl }" method="post">
		<div>
			<label>URL 주소:</label><input type="text" name="url">
		</div>
		<div>
			<label>별칭:</label><input type="text" name="name">
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
		<ul>
			<c:url var="bookmarkDeleteUrl" value="/bookmark/delete"/>
			<c:forEach var="d" items="${requestScope.data }">
				<c:url var="bookmarkUpdateUrl" value="/bookmark/update">
					<c:param name="id" value="${d.id }" />
				</c:url>
					<li>
						<a href="${d.url }">${d.name } </a>
						
						<button type="button" onclick="location.href='${bookmarkUpdateUrl}'">수정</button>
						<button type="submit" form="deleteForm${d.id }">삭제</button>
						<form action="${bookmarkUrl }/delete" method="post" id="deleteForm${d.id }">
							<input type="hidden" name="id" value="${d.id }">
						</form> 
					</li>
			</c:forEach>	
		</ul>
		<div>
			<a href="#">prev</a>
			<c:forEach var="i" begin="${requestScope.start }" end="${requestScope.end }">
				<a href="${bookmarkUrl }?p=${i }">${i }</a>
			</c:forEach>
			<a href="#">next</a>
			
		</div>
	<%--	
		<ul>
			<% for(BookmarkDTO d: (List<BookmarkDTO>)request.getAttribute("data")){ %>
				<li>
					<a href="<%=d.getUrl()%>"> <%=d.getName() %> </a>
					<button type="button" onclick="location.href='./bookmark/update?id=<%=d.getId()%>'">수정</button>
					<button type="submit" form="deleteForm<%=d.getId()%>">삭제</button>
					<form action="./bookmark/delete" method="post" id="deleteForm<%=d.getId()%>">
						<input type="hidden" name="id" value="<%=d.getId()%>">
					</form> 
				</li>
			<%} %>		
		</ul>
		 --%>

		 
		 
</body>
</html>