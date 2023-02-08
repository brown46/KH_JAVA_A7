<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/resources/css/reset.css" rel="stylesheet">
<script src="xxx.js"></script>
</head>
<body>
<img src="xxx.png">
<hr>
WebContent - WEB-INF - index.jsp
<hr>
<button type="button" onclick="login();">로그인 페이지로 이동</button>

<script type="text/javascript">
function login(){
	location.href="<%=request.getContextPath()%>/loginurl";
}
</script>
</body>
</html>
