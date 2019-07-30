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
	<form:form modelAttribute="questVO" action="/quest/post/${questVO.questId}">
		<input type="hidden" name="_method" value="" />
		<a class="button" href="javascript:fn_submit('post');">글 수정</a>
		<a class="button" href="javascript:fn_submit('delete');">글 삭제</a>
	</form:form>
<body>
	<p><c:out value="${questVO.questTitle}"/></p>
	<p><c:out value="${questVO.questContent}"/></p>`
	<p><c:out value="${questVO.questTitle}"/></p>
	<p><c:out value="${questVO.questTitle}"/></p>
	<p><c:out value="${questVO.questTitle}"/></p>
	<p>답변 달기</p>
	

	
</body>
</html>