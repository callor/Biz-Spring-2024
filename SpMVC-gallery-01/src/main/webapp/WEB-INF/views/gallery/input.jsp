<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<link rel="stylesheet" href="${rootPath}/static/css/gallery.css?04-22-006">
<script src="${rootPath}/static/js/gallery_input.js?04-22-001"></script>
<section class="gallery">
	<article class="gallery">
		<f:form>
			<fieldset>
				<legend>이미지 업로드</legend>
				<div><input placeholder="작성일자" name="g_date"/></div>
				<div><input placeholder="작성시각" name="g_time"/></div>
				<div><input placeholder="작성자" name="g_author"/></div>
				<div><input placeholder="제목"  name="g_subject"/></div>
				<div><textarea rows="5" placeholder="이미지 설명" name="g_content"></textarea></div>
				<div class="image"><img class="gallery" 
					src="${rootPath}/static/images/no_image.png" width="100px"/></div>
				<input type="file" class="file" accept="image/*"/>
				<div><input type="submit" value="저장"/></div>
				<textarea rows="10" class="base64" name="g_image"></textarea>
			</fieldset>
		</f:form>
	</article>
</section>