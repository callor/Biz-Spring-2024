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
</head>
<body>
	<link rel="stylesheet" href="${rootPath}/css/input.css"/> 
	<script src="${rootPath}/js/input.js"></script>
	<form method="POST" class="image input" enctype="multipart/form-data">
		<div><input placeholder="제목" name="g_subject"/></div>
		<div><textarea placeholder="내용" rows="10" name="g_content"></textarea></div>
		<div><input placeholder="작성자" name="g_writer"/></div>
		<div><input placeholder="비밀번호" name="g_password" type="password"/></div>
		<div><input name="files" id="files" type="file" multiple="multiple" accept="image/*"/></div>
		<div class="represent">
			<img src="${rootPath}/images/no_image.png" 
						class="represent"/>
		</div>
		<div class="thumnail"></div>
		<div><input type="submit" value="저장"/></div>
	</form>
</body>
</html>