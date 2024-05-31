<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link href="${rootPath}/static/css/main.css" rel="stylesheet">
  </head>
  <body>
  	<a href="${rootPath}/insert">겔러리 추가</a>
  	<section class="image list">
  		<c:forEach items="${GALLERYS}" var="G">
	  		<div class="image item">
				<header>
					<h1>${G.g_subject}</h1>
				</header>
				<a href="${rootPath}/detail/${G.g_id}">
					<img src="${rootPath}/upload/${G.g_image}">
				</a>
				<footer>
					<div>작성자:${G.g_writer}</div>
					<div>작성일자:${G.g_date}</div>
					<div>작성시각:${G.g_time}</div>
				</footer>
	  		</div>
  		</c:forEach>
  	</section>
  </body>
</html>



