<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script src = "<%=request.getContextPath() %>/resources/ckeditor/build/ckeditor.js"></script>
</head>
<style>
  .ck-editor__editable { height: 400px; }
</style>
<body>

들어갈 것들
1. 게시글 id (자동)
2. 유저 id (자동)
3. 게시글 내용(이미지 포함)
4. 생성 시각(자동)
5. 업데이트 시각(자동) 

7. 음식 이름
8. 음식 재료
9. 재료 수량
10. 해쉬태그


  <h1>CKEditor</h1>
    <form action="" method="POST">
    
    <input type="text" name=" " placeholder="재료 이름">
    <input type="text" name=" " placeholder="재료 수량">
    <!-- 
	버튼을 누를 시 재료 입력 칸 추가됨
	 -->
    <button type="button">재료 더 추가하기</button>
      <textarea name="text" id="editor"></textarea>
    <p><input type="submit" value="전송"></p>
    
    
    </form>
















    <script>
      ClassicEditor.create( document.querySelector( '#editor' ) );
    </script>







</body>
</html>