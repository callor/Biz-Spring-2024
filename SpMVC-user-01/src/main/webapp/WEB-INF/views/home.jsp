<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>Hello!! Korea</h1>
    <h2>The time on the Today is ${serverTime}</h2>
    
    <sec:authorize access="isAuthenticated()">
    	<h3><sec:authentication property="principal.username"/></h3>
    	<h3><sec:authentication property="principal.email"/></h3>
    </sec:authorize>
    
  </body>
</html>
