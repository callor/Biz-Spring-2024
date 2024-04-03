<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>	
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    
<table class="iolist list">
	<thead>
		<tr>
			<th>No</th>
			<th>일자</th>
			<th>시각</th>
			<th>상품명</th>
			<th>매입단가</th>
			<th>판매단가</th>
			<th>수량</th>
			<th>매입합계</th>
			<th>매출합계</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${IOLIST}" var="IO" varStatus="INDEX">
			<tr>
				<td>${INDEX.count}</td>
				<td>${IO.io_date}</td>
				<td>${IO.io_time}</td>
				<td>${IO.io_pname}</td>
				
				<td>${IO.io_input eq "1" ? IO.io_price : 0 }</td>
				<td>${IO.io_input eq "2" ? IO.io_price : 0 }</td>
				
				<td>${IO.io_quan}</td>

				<td>${IO.io_input == "1" ? IO.io_price * IO.io_quan : 0 }</td>
				<td>${IO.io_input == "2" ? IO.io_price * IO.io_quan : 0 }</td>
				
			</tr>
		</c:forEach>
	
	</tbody>
</table>
<div class="iolist btn_box">
	<a href="${rootPath}/iolist/insert">추가하기</a>
</div>


