<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%!
	public Random rd =new Random();
	public String title="메인페이지";
	public String getTitle(){
		return this.title;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=getTitle()%></title>
<c:url var="staticUrl" value="/static"/>
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Hello JSP/Servlet</h1>
	<p>사용자 요청에 Servlet의 메서드가 동작하여 JSP페이지를 실행하고 최종 응답이 되었습니다.</p>
	<form action="./main" method="get">
		<input type="text" name="count" value="<%=rd.nextInt(10) %>">
	</form>
	<p>
		<%=request.getParameter("count") %> 값을 받았습니다.
	</p>
	<ul>
	<% for(int i=0; i<(Integer)request.getAttribute("iCnt");i++){ %>
		<li><%=i%>번째 목록</li>
	<%} %>
	</ul>
</body>
</html>