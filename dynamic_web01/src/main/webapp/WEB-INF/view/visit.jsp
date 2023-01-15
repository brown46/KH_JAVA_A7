<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.VisitDTO, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<a href="./">메인</a>
	<h2>방명록</h2>
	<form action="./visit" method="post" >
		<div>
			<textarea rows="1" cols="25" name="context" placeholder="닉네임 입력"></textarea>
		</div>
		<div>
			<textarea rows="3" cols="25" name="nickname" placeholder="내용 입력"></textarea>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	<ul>
	<%SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 a hh시 mm분 ss초"); %>
	<% for(VisitDTO data:(List<VisitDTO>)request.getAttribute("dataList")){ %>
		<li><%= data.getNickname() %> | <%= data.getContext() %> | <%= dateFormat.format(data.getCreateDate()) %>
			<form action="./visit/delete" method="post" id="deleteForm<%=data.getCreateDate()%>">
				<input type="hidden" name="createdate" value=<%=data.getCreateDate().getTime()%>>
			</form>
			<button onclick="location.href='./visit/update?createdate=<%=data.getCreateDate().getTime()%>'">수정</button>
			<button type="submit" form="deleteForm<%=data.getCreateDate()%>">삭제</button>
		</li>
	<% } %>
	</ul>
</body>
</html>