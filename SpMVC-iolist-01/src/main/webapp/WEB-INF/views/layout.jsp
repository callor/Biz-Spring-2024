<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <%@ include file="/WEB-INF/views/include/head.jspf" %>
  <body>
    <%@ include file="/WEB-INF/views/include/header.jspf" %>
    <section class="container">
    	<c:if test="${BODY == 'IOLIST_HOME' }">
    		<%@ include file="/WEB-INF/views/iolist/home.jsp" %>
    	</c:if>
    	<c:if test="${BODY == 'IOLIST_INPUT' }">
    		<%@ include file="/WEB-INF/views/iolist/input.jsp" %>
    	</c:if>
    	<c:if test="${BODY == 'IOLIST_DETAIL' }">
    		<%@ include file="/WEB-INF/views/iolist/detail.jsp" %>
    	</c:if>
    </section>
    <footer class="main">
    	<address>CopyRight &copy; callor@callor.com</address>
    </footer>
  </body>
</html>
