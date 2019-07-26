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
	<form:form method="post" modelAttribute="userVO">
		<p>아이디</p>
		<form:input path="userId" />
		<form:errors path="userId" cssClass="err" />
		<input type="button" value="아이디 중복 확인" />
		<p>비밀번호</p>
		<form:input path="password"/>
		<form:errors path="password" />
		<p>비밀번호 확인</p>
		<form:input path="passwordConfirm"/>
		<p>이메일</p>
		<form:input path="emailPrefix"/>@<form:input path="emailSuffix"/>
		<p>닉네임</p>
		<form:input path="userNickname"/>
		<form:errors path="userNickname" />
		<input type="submit" />
	</form:form>

</body>
</html>