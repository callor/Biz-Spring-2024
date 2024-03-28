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
  	}
  	
  	div.btn_box {
  		display:block;
  		width: 70%;
  		margin:5px auto;
  		text-align: right;
  		padding:0;
  	}
  </style>
  <body>
  	<%@ include file="/WEB-INF/views/includes/header.jspf" %>
  	<div class="w3-container w3-padding-24 w3-center">
  		<table class="w3-table-all w3-striped w3-hoverable">
  			<tr>
  				<th>SEQ</th>
  				<th>고객코드</th>
  				<th>고객이름</th>
  				<th>전화번호</th>
  			</tr>
  			<c:forEach items="${CUST_LIST}" var="CUST" varStatus="VAR">
	  			<tr>
	  				<td>${VAR.index}, ${VAR.count}
	  				<td>${CUST.c_code}</td>
	  				<td>${CUST.c_name}</td>
	  				<td>${CUST.c_tel}</td>
	  			<tr>
  			</c:forEach>
  		</table>
  		<div class="w3-container btn_box">
  			<a href="${rootPath}/customer/input" class="w3-button w3-blue w3-round-large">고객추가</a>
  		</div>
  		
  		<ul>
  			<%
  			/*
  			for(intt VAR = 1 ; VAR <=100; VAR += 2) {
  				print(VAR)
  			}
  			*/
  			%>
	  		<c:forEach begin="1" end="100" step="2" var="VAR">
  				<li>${VAR}</li>	
  			</c:forEach>
  		</ul>
  		
  		
  	</div>
  </body>
</html>