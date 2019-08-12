<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
	            <div class="container">
	                <div class="logo_image">
	                	<a href="<c:url value='/main'/>"><p>로고</p></a>
	                </div>
	                <ul class="right_menu">
	                	<sec:authorize access="isAnonymous()">
	                		<li><a href="<c:url value='/login'/>">로그인</a></li>
	                	</sec:authorize>
	                	<sec:authorize access="isAuthenticated()">
	                		<li><a href="#"><c:out value="${userId}님 환영합니다"/></a>
	                	</sec:authorize>
	                    <li><a href="<c:url value='/product'/>">상품보기</a></li>
	                    <li><a href="<c:url value='/quest'/>">질문</a></li>
	                    <li><a href="<c:url value='/board'/>">문의사항</a></li>
	                </ul>
	            </div>
	        </header>
	
</body>
</html>