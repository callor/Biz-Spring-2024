<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	   
<script src="${rootPath}/static/js/main_nav.js?2024-04-22-007"></script> 
<nav class="main">
	<ul>
		<li class="home">Home</li>
		<li class="notice">공지사항</li>
		<li class="free">자유게시판</li>
	</ul>
</nav>