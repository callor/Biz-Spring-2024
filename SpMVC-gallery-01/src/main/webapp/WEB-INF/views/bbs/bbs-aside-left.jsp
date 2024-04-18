<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<nav class="bbs">
	<ul>
		<li><a href="${rootPath}/bbs/free/write">글쓰기</a></li>
		<li><a href="${rootPath}/bbs/free/like">인기글</a></li>
	</ul>
</nav>