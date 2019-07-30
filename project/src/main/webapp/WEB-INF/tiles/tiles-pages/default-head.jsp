<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	    <title>이름</title>
	    
	    <link rel="stylesheet" href="<c:url value='/resources/css/reset.css' />" />
	    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" />
	    
	    <meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
		
		<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>
		
</head>
<body>
	
</body>
</html>