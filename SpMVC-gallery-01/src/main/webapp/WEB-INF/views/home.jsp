<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
  <tiles:insertAttribute name="head"/>
  <body>
  	<tiles:insertAttribute name="header" />
  	<tiles:insertAttribute name="nav" />
    <tiles:insertAttribute name="content"/>
  </body>
</html>
