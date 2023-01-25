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
<title>게시판 목록 페이지</title>
<%@ include file="../module/css_js_import.jsp" %>
</head>
<body>
	<div>
		<%@ include file="../module/top_nav.jsp" %>
	</div>
	${requestScope.detail.title }
	
</body>
</html>