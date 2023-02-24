<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<form action="loginurl" method="post">
			id:<input type="text" name="n1"> 
			<br>
			pw:<input type="password" name="n2">
			<br>
			<button type="submit">로그인하기</button>
			<button type="button" class="btn enroll">회원가입</button>
		</form>
	</section>
	
	<script>
	$(".btn.enroll").on("click", handlerClickBtnEnroll);
	function handlerClickBtnEnroll(){
		console.log("btnEnroll눌림");
		location.href="<%=request.getContextPath()%>/enroll"
	}
	</script>
</body>
</html>