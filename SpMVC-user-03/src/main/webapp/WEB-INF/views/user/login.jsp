<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>회원가입 및 로그인 구현</h1>
    <ul>
    	<li>Home</li>
    	<sec:authorize access="isAnonymous()">
	    	<li><a href="${rootPath}/user/join">회원가입</a></li>
	    	<li><a href="${rootPath}/user/login">로그인</a></li>
    	</sec:authorize>
    	<sec:authorize access="isAuthenticated()">
    		<li>
    			<a href="${rootPath}/user/mypage">
    				<sec:authentication property="principal.username"/>
    			</a> 
    		</li>
    		<li>로그아웃</li>
    	</sec:authorize>
    </ul>
  </body>
</html>
 