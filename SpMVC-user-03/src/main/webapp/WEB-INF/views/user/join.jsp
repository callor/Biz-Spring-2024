<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script>
    	const rootPath = "${rootPath}"
    </script>
    <script src="${rootPath}/static/js/user.js?2024-04-16-001"></script>
  </head>
  <body>
    <h1>회원가입 및 로그인 구현</h1>
    <f:form class="join">
    	<div><input placeholder="USERNAME" name="username"></div>
    	<div><input placeholder="PASSWORD" name="password"></div>
    	<div><input placeholder="RE PASSWORD" name="re_password"></div>
    	<div><input placeholder="Email" name="email"></div>
    	<div><button type="button">회원가입</button></div>
    	<a href="${rootPath}/user/login">로그인</a>
    </f:form>
  </body>
</html>



 