<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<header class="main">
	<img src="${rootPath}/static/images/logo.png" width="100px" alt="logo">
	<h1>이미지 갤러리(Gallery) 2024</h1>
	<div>
		<a href="${rootPath}/user/login">로그인</a>
		<a href="${rootPath}/user/join">회원가입</a>
	</div>
</header>