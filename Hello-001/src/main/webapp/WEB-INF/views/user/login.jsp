<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form method="POST">
		<div><input placeholder="USERNAME" name="username"/></div>
		<div><input placeholder="PASSWORD" name="password"/></div>
		<div><input type="submit" value="로그인"/></div>
	</form>
	<div>
		<p>${username}</p>
		<p>${password}</p>
	</div>
	
</body>
</html>


