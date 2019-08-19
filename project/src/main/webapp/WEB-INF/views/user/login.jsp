<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main_content">
		<div class="title">
			<p>로그인</p>
		</div>
		<form:form action="/login/check">
		<p>아이디</p>
		<input type="text" name="userId"/>
		<p>비밀번호</p>
		<input type="password" name="password"/>
		<input type="submit" />
		<a href="<c:url value='/signup'/>">회원가입</a>
		<a id="find" href="<c:url value='/find'/>">정보 찾기</a>
	</form:form>
	</div>
	
	
</body>
</html>