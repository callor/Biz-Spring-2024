<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>여기는 제목</title>
<link rel="stylesheet" href="${rootPath}/static/css/main.css">
</head>
<body>
	<section class="main">
		<article class="image list">
		</article>
		<div class="image button">
			<a href="${rootPath}/insert" class="insert">갤러리 작성</a>
		</div>
	</section>
</body>
</html>