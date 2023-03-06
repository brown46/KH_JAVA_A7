<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
<h1>내 정보</h1>

	<form id="frmInfo" action="update">
		<input value="${MemberVO.id}" type="text" name="id" placeholder="id" readonly="readonly"><br>
		<input value="${MemberVO.passwd}" type="password" placeholder="pass"readonly="readonly"><br>
		<input value="${MemberVO.name}" type="text" placeholder="name" readonly="readonly"><br>
		<input value="${MemberVO.email}" type="text" placeholder="email"readonly="readonly"><br>
		<button type="button" onclick="frmSubmit('update');" >수정</button>
		<button type="button" onclick="frmSubmit('delete');">탈퇴</button>
<!-- 
 -->
		<button type="button">수정</button>
		<button type="button">탈퇴</button>
	</form>
</body>

<script type="text/javascript">
	console.log($("button").get(2).innerText);
	console.log($("button").eq(3).text());
	$("button").get(2).click('update' , frmSubmit);
	$("button").eq(3).click('delete' , frmSubmit);
	function frmSubmit2(ev) {
		console.log(this);//this: click이 발생한 시점의 element
		frmInfo.action =targetEle;
		frmInfo.submit();
}
	
	function frmSubmit(targetEle) {
		//html에의해 호출됨
		console.log(this);//this: window 객체 
			frmInfo.action =targetEle;
			frmInfo.submit();
	}
</script>

</html>