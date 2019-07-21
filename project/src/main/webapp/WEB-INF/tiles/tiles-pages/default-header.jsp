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
	                    <p>로고</p>
	                </div>
	                <ul class="right_menu">
	                	<sec:authorize access="isAnonymous()">
	                		<li><a href="/common/login.do">로그인</a></li>
	                	</sec:authorize>
	                	<sec:authorize access="isAuthenticated()">
	                		<li><a href="#">안녕하십니까</a>
	                	</sec:authorize>
	                    <li><a href="/product.do">상품보기</a></li>
	                    <li><a href="/question.do">질문</a></li>
	                    <li><a href="/board.do">문의사항</a></li>
	                </ul>
	            </div>
	        </header>
	
</body>
</html>