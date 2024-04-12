<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>Hello!! Korea</h1>
    <h2>The time on the Today is ${serverTime}</h2>
    <h3><a href="${rootPath}/user/login">로그인</a></h3>
    <h3><a href="${rootPath}/home">홈으로 가기</a></h3>
    <sec:authorize access="isAuthenticated()">
    	<f:form action="${rootPath}/logout">
    		<button>로그아웃</button>
    	</f:form>
    </sec:authorize>
  </body>
</html>
