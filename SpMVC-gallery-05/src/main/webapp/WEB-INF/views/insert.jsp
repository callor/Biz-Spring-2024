<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
    	form {
    		width: 80%;
    		margin:20px auto;
    		div {
    			width:90%;
    			margin:5px auto;
    		}
    		
    	}
    </style>
  </head>
  <body>
  	<form method="POST" enctype="multipart/form-data">
  		<div><input name="g_subject" placeholder="제목"/></div>
  		<div><textarea name="g_content" rows="10" placeholder="내용"></textarea></div>
  		<div><input name="g_writer" placeholder="작성자"/></div>
  		<div><input name="g_password" placeholder="비밀번호" type="password"/></div>
  		<div><input name="files" type="file" accept="image/*" multiple="multiple"/></div>
  		<div><input type="submit" value="저장"/></div>
  	</form>
  </body>
</html>
