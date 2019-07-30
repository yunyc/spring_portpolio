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
	<form:form modelAttribute="BoardVO">
		<form:hidden path="boardId" value="${boardVO.boardId}"/>
		<form:hidden path="userId" value="${userId}"/>
		<p>제목</p>
		<form:input path="boardTitle" value="${boardVO.boardTitle}" />
		<p>글내용</p>
		<form:textarea path="boardContent" value="${boardVO.boardContent}"/>
		<p>글분류</p>
		<form:input path="boardType" value="${boardVO.boardType}"/>
		<a class="button" href="javascript:fn_submit('post');">글 생성</a>
		<a class="button" href="javascript:fn_submit('patch');">글 수정</a>
		<input type="hidden" name="_method" value="" />
	</form:form>
	
	
</body>
</html>