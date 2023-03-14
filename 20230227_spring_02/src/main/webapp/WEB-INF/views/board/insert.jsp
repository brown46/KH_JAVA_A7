<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/4.20.2/standard/ckeditor.js"></script>
</head>
<body>
	<h1>board insert</h1>
	<!-- file upload : encType -->
	<form action="insert" method="post" enctype="multipart/form-data">
		<input type="text" name="boardTitle" placeholder="제목"><br>
		<textarea name="boardContent" placeholder="내용"></textarea><br>
		<!-- file의 경우 name은 vo와 다른 이름으로 정해야 한다. -->
		<input type="file" name="report" placeholder="첨부파일"><br>
		<input type="file" name="report" placeholder="첨부파일" multiple="multiple"><br>
		<button type="submit">게시글 등록</button>
		<button id="btnCheck" type="button">내용</button>
	</form>
	<script type="text/javascript">
	CKEDITOR.replace('boardContent');// {}으로 옵션 입력 가능
	$("#btnCheck").click(function(){
		console.log(CKEDITOR.instances.boardContent.getData()); //html 형태로 값 반환
	});
	</script>
</body>
</html>