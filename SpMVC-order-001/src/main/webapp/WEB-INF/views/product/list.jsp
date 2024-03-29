<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<!DOCTYPE html>
<html lang="ko">
  <%@ include file="/WEB-INF/views/includes/head.jspf" %>
  <style>
  	table.w3-table-all {
  		width: 70%;
  		margin:10px auto;
  		tr:hover {
  			cursor:pointer;
  		} 
  	}
  	
  	div.btn_box {
  		display:block;
  		width: 70%;
  		margin:5px auto;
  		text-align: right;
  		padding:0;
  	}
  </style>
  <script>
  	const rootPath = "${rootPath}"
  </script>
  <script src="${rootPath}/static/js/customer.js?2024-03-29-003"></script>
  <body>
  	<%@ include file="/WEB-INF/views/includes/header.jspf" %>
  	<div class="w3-container w3-padding-24 w3-center">
  	  	<div class="w3-container btn_box">
  			<a href="${rootPath}/product/insert" class="w3-button w3-blue w3-round-large">상품추가</a>
  		</div>
  	
  		<table class="w3-table-all w3-striped w3-hoverable">
  			<thead>
	  			<tr>
	  				<th>상품코드</th>
	  				<th>상품명</th>
	  				<th>품목</th>
	  				<th>가격</th>
	  			</tr>
  			</thead>
  			<tbody class="product_body">
	  			<c:forEach items="${PRODUCT_LIST}" var="PRODUCT" varStatus="VAR">
		  			<tr data-ccode="${PRODUCT.p_code}">
		  				<td>${PRODUCT.p_code}</td>
		  				<td>${PRODUCT.p_name}</td>
		  				<td>${PRODUCT.p_item}</td>
		  				<td>${PRODUCT.p_price}</td>
		  			<tr>
	  			</c:forEach>
  			</tbody>
  		</table>

  		
  		
  	</div>
  </body>
</html>