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
	<form:form action="/login/check">
		<p>아이디</p>
		<input type="text" name="userId"/>
		<p>비밀번호</p>
		<input type="password" name="password"/>
		
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" >
		<input type="submit" />
		<a href="/signUp">회원가입</a>
		<a href="/find">정보 찾기</a>
	
	</form:form>
	
</body>
</html>