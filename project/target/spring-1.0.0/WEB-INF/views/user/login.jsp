<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
	<style>
		#command {
	    	float: none;
		}
		
		.main_content input {
		    width: 300px;
		    display: block;
		    margin: 10px;
		    border: 1px solid #aaa;
		    padding: 7px;
		}
		span a {
			display: inline;
		}
		
	</style>
</head>
<body>
	<div class="main_content">
		<div class="title">
			<p>로그인</p>
		</div>
		<form:form action="/login/check">
		<input type="text" name="userId" placeholder="아이디"/>
		<input type="password" name="password" placeholder="비밀번호"/>
		<input type="submit" />
		<span><a href="<c:url value='/signup'/>">회원가입</a></span>
		<span><a id="find" href="<c:url value='/find'/>">정보 찾기</a></span>
	</form:form>
	</div>
	
	
</body>
</html>