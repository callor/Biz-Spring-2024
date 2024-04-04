<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<form method="POST" class="user login">
	<fieldset>
		<legend>로그인</legend>
		<c:if test="${not empty ERROR && ERROR eq 'needs'  }">
			<div class="error"><h1>로그인이 필요한 서비스 입니다</h1></div>
		</c:if>
		<div><input placeholder="USERNAME" name="username"/></div>
		<div><input placeholder="PASSWORD" name="password" type="password"/></div>
		<div><input type="submit" value="로그인"/></div>
		<div><a href="${rootPath}/user/join">회원가입</a> 
			 | <a href="${rootPath}/user/findId">아이디비번찾기</a></div>
	</fieldset>
</form>
