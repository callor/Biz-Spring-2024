<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기는 제목</title>
</head>
<body>
	<form method="POST">
		<div><input placeholder="USERNAME" name="username"/></div>
		<div><input placeholder="PASSWORD" name="password"/></div>
		<div><input placeholder="이름" name="name"></div>
		<div><input placeholder="이메일" name="email"/></div>
		<div><input placeholder="전화번호" name="tel"/></div>
		<div><input type="submit" value="회원가입"/></div>
	</form>
</body>
</html>