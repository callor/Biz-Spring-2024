<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
		<div><input placeholder="USERNAME" name="username"/></div>
		<div><input placeholder="비밀번호" name="password"/></div>
		<div><input placeholder="비밀번호 확인" name="re_password"/></div>
		<div><input placeholder="이름"  name="name"/></div>
		<div><input placeholder="이메일" name="email"/></div>
		<div><input placeholder="전화번호" name="tel"/></div>
		<div><input type="submit" value="회원가입"/></div>
	</form>
	<p>${USER.username}
	<p>${USER.password}
	<p>${USER.name}
	<p>${USER.email}
	<p>${USER.tel}
</body>
</html>