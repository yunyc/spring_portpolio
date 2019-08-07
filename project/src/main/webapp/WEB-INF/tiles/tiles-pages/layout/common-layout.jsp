<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
	<tiles:insertAttribute name="head" />
</head>
<body>
	<script src="<c:url value='/resources/ckeditor/ckeditor.js'/>"></script>

	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<script src="<c:url value='/resources/js/form.js'/>"></script>

	<div id="wrapper">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="contents">
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="left" />
		<tiles:insertAttribute name="footer" />
	</div>
	
	
		
	
	
	
	
	
</body>
</html>