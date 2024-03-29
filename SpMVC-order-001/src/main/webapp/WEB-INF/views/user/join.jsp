<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<!DOCTYPE html>
<html lang="ko">
	<%@ include file="/WEB-INF/views/includes/head.jspf" %>
	<style>
		form.w3-container {
			width: 60%;
			margin:10px auto;
			fieldset {
				border-radius:20px;
				padding:16px;
			}
			legend {
				text-align: center;
				font-weight: 900;
				font-size: 1.3rem;
			}
			input {
				margin-bottom:10px;
				border-radius: 10px;
			}
		}
	</style>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jspf" %>
	<form method="POST" class="w3-container">
		<fieldset>
		<legend>회원가입</legend>
		<label class="w3-text-teal">USERNAME</label>
		<input placeholder="USERNAME" name="username" class="w3-input w3-border w3-light-gray"/>
		
		<label class="w3-text-teal">비밀번호</label>
		<input placeholder="PASSWORD" name="password" class="w3-input w3-border w3-light-gray"/>
		
		<label class="w3-text-teal">이름</label>
		<input placeholder="이름" name="name" class="w3-input w3-border w3-light-gray"/>
		
		<label class="w3-text-teal">이메일</label>
		<input placeholder="이메일" name="email" class="w3-input w3-border w3-light-gray"/>
		
		<label class="w3-text-teal">전화번호</label>
		<input placeholder="전화번호" name="tel" class="w3-input w3-border w3-light-gray"/>
		
		<input type="submit" value="회원가입" class="w3-btn w3-blue-gray w3-right"/>
		</fieldset>
	</form>
</body>
</html>