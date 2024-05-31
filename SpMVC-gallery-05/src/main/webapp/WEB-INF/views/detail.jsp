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
	<div><img src="${rootPath}/upload/${GALLERY.g_image}" width="200px" /></div>
	<div>
		<c:forEach items="${GALLERY.g_images}" var="IMG">
			<img src="${rootPath}/upload/${IMG.i_up_image}" width="100px">
		</c:forEach>	
	</div>
	<a href="${rootPath}/delete/${GALLERY.g_id}">삭제</a>
	
</body>
</html>