<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>여기는 제목</title>
<style>
	form.login {
		width:50%;
		margin:10px auto;
	}
	
	form.login div {
		display: flex;
	}
	form.login label {
		flex:1;
	}
	
	form.login input {
		flex:2;
	}
	
	form.login button {
		flex:1;
	}

</style>
</head>
<body>
	<f:form class="form login" name="f">
		<c:if test="${param.error != null}">Invalid User.</c:if>
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
			${SPRING_SECURITY_LAST_EXCEPTION.message}
			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION"/>
		</c:if>
		<div><label>UserName</label><input name="u_name"></div>
		<div><label>Password</label><input name="u_password"></div>
		<div><button type="submit">Log in</button></div>		
	</f:form>
</body>
</html>