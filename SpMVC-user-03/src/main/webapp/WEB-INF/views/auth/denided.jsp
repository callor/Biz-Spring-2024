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
	<h1>지금 요청한 페이지는 접근 권한이 없습니다</h1>
	
	<h3>누가 : ${AUTH.principal.username}</h3>
	<h3>Email : ${AUTH.principal.email}</h3>
	<h3><c:if test="${AUTH.authenticated}"></c:if></h3>
	<h3>가진 권한은?</h3>
	<ul>
		<c:forEach items="${AUTH.authorities}" var="AU">
			<li>${AU}</li>
		</c:forEach>
	</ul>
	<h3>뭐가문젠데 : ${MESSAGE}</h3>
</body>
</html>




