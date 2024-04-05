<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />	    

<div class="iolist btn_box">
	<form:form method="GET" modelAttribute="SEARCH">
		<form:input placeholder="상품명" path="pname"/>
		<form:input placeholder="시작일자" path="sdate"/>
		<form:input placeholder="종료일자" path="edate"/>
		<input type="submit" value="검색"/>
	</form:form>
	<a href="${rootPath}/iolist/insert">추가하기</a>
</div>

<table class="iolist list">
	<thead>
		<tr>
			<th>No</th>
			<th>일자</th>
			<th>시각</th>
			<th>거래구분</th>
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
			<tr data-seq="${IO.io_seq}" 
				class="${IO.io_input eq '1' ? 'output' : 'input' }">
				
				<td>${INDEX.count}</td>
				<td>${IO.io_date}</td>
				<td>${IO.io_time}</td>
				<td>${IO.io_inout}</td>
				<td class="iolist pname">${IO.io_pname}</td>
				
				<td class="number">
					<fmt:formatNumber value="${IO.io_iprice}" pattern="#,###"/>
				</td>
				<td class="number">
					<fmt:formatNumber value="${IO.io_oprice}" pattern="#,###"/>
				</td>
				
				<td class="number">${IO.io_quan}</td>

				<td class="number">
					<fmt:formatNumber value="${IO.io_itotal}" pattern="#,###"/>
				</td>
				<td class="number">
					<fmt:formatNumber value="${IO.io_ototal}" pattern="#,###"/>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>



