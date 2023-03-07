<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>${board.boardNum } 게시글</h1>
	<div>
	<p>${board.boardTitle }</p>
	</div>
	게시글 작성자:${board.boardWriter} <br>
	게시글 작성일:${board.boardDate} <br>
	게시글 내용:${board.boardContent} <br>

	
	
	
	
	<form  id="frmReply">
	<fieldset>
	<legend>답글 작성 </legend>
		<div>제목<input type="text" name="boardTitle" ></div>
		<div>내용<input type="text" name="boardContent"></div>
		<input type="hidden" name="boardNum" value="${board.boardNum}">
		<button class="btn reply" type="button">답글 작성</button>
	</fieldset>
	</form>
	
<script type="text/javascript">
	$(".btn.reply").on("click",replyClickHandler);
	
	function replyClickHandler(){
		console.log(this);	//this(DOM)
		console.log($(this)); //jQuery 형태로 변경
		console.log($("#frmReply").serialize()); 
		
		$.ajax({
			url:"<%=request.getContextPath()%>/board/insertReplyAjax",
			type:"post",
			data:$("#frmReply").serialize(),
			//data:{boardTitle:$("#a").val(),boardContent:$("#b").val(), boardNum: '${board.boardNum}'}, //따옴표 필요!!
			success:function(result){
				console.log(result);
				//$("#frmReply")[0].reset();//작성된 글 초기화
				frmReply.reset();//자바스크립트
				if(result=="ok"){
					alert("답글이 작성되었습니다.");
				}else{
					alert("답글이 작성되지 않았습니다.");
				}
			}
			,error: function(){
				
			}
		});
	}
</script>

</body>
</html>