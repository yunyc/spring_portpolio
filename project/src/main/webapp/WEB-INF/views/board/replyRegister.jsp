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
	<form:form modelAttribute="replyVO" action="/board/boardDetail/replyRegister/submit.do?boardId=${replyVO.boardId}&mode=${mode}&replyId=${replyVO.replyId}" method="post">
		<p>글내용</p>
		<form:input path="replyContent"/>
		<form:input path="userId" value="yunyc"/>
		<input type="submit" value="${mode}"/>
	</form:form>
	
	
	
</body>
</html>