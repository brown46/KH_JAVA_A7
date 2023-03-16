<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cPath" value="${pageContext.request.contextPath }"/>
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
	
	<div>
	<img alt="" src="${cPath }${board.boardRenameFilename }">
	</div>
	<!-- 첨부 파일들 모두 표시 -->
	<div>	
	
	<c:forEach varStatus="vs" items="${board.boardFileList }" var="boardfile">
		<p>${boardfile.originalFilename } </p>
		<img alt="" src="${cPath }${boardfile.renameFilename }">	
	</c:forEach>
	
		<img alt="" src="${cPath }/1번이미지">
		<img alt="" src="${cPath }/3번이미지">
		<img alt="" src="${cPath }/4번이미지">
	</div>
	
	
	
	<hr>
	
	<form  id="frmReply" enctype="multipart/form-data">
	<fieldset>
	<legend>답글 작성 </legend>
		<div>제목<input type="text" name="boardTitle" ></div>
		<div>내용<input type="text" name="boardContent"></div>
		<div>파일 <input type="file" name="report"></div>
		<input type="hidden" name="boardNum" value="${board.boardNum}">
		<button class="btn reply" type="button">답글 작성</button>
	</fieldset>
	</form>
	
<hr>
<h4>답글</h4>
<table border="1">
	<thead>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${replyList }" var="reply">
		<!-- 제목을 누르면 글읽기 화면으로 이동 -->
		<tr>
			<td>${reply.boardNum }</td>
			<td><a href="<%=request.getContextPath()%>/board/read?boardNum=${reply.boardNum }">${reply.boardTitle }</a></td>
			<td>${reply.boardWriter }</td>
			<td>${reply.boardDate }</td>
			<td>${reply.boardReadcount }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

	
	
<script type="text/javascript">
	$(".btn.reply").on("click",replyClickHandler);
	
	function replyClickHandler(){
		console.log(this);	//this(DOM)
		console.log($(this)); //jQuery 형태로 변경
		console.log($("#frmReply").serialize()); 
		
		var formdata= new FormData();
		formdata.append("boardTitle", $("[name=boardTitle]").val());
		formdata.append("boardContent",$("[name=boardContent]").val() );
		formdata.append("report", $("[name=report]").files[0]);
		formdata.append("boardNum", $("[name=boardNum]").val());

		
		console.log(formData);
		
		$.ajax({
			url:"${pageContext.request.contextPath}/board/insertReplyAjax",
			type:"post",
			contentType:"multipart/form-data",
			data: formData,
			dataType:"json", //받아오는 데이터타입은 json이고 js object로 변형해서 result에 전달
			//data:{boardTitle:$("#a").val(),boardContent:$("#b").val(), boardNum: '${board.boardNum}'}, //따옴표 필요!!
			success:function(result){
				console.log(result);
				//$("#frmReply")[0].reset();//작성된 글 초기화
				frmReply.reset();//자바스크립트
				if(result.length>0){
					alert("답글이 작성되었습니다.");
				}else{
					alert("답글이 작성되지 않았습니다.");
				}
				//답글 부분 화면 업데이트
				displayReply(result);
			}
			,error: function(){
				
			}
		});
	}
	
	function displayReply(result){
		console.log(result[0]);
		console.log(result[0].boardDate);
		
		var htmlVal= '';
		for(i = 0 ; i<result.length;i++){
			var reply = result[i];	
			htmlVal+='<tr>';
			htmlVal+='<td>'+reply.boardNum+'</td>';
			htmlVal+='<td><a href="<%=request.getContextPath()%>/board/read?boardNum='+reply.boardNum+'">'+reply.boardTitle+'</a></td>';
			htmlVal+='<td>'+reply.boardWriter +'</td>';
			htmlVal+='<td>'+reply.boardDate +'</td>';
			htmlVal+='<td>'+reply.boardReadcount +'</td>';
			htmlVal+='</tr>';
		
		}
		$("tbody").html(htmlVal);		
	}
	
	
</script>

</body>
</html>