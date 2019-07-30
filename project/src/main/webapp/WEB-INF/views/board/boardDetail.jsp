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
	<form:form modelAttribute="boardVO" action="/board/post/${boardVO.boardId}">	
			<a class="button" href="javascript:fn_submit('post');">글 수정</a>
			<a class="button" href="javascript:fn_submit('delete');">글 삭제</a>
			<input type="hidden" name="_method" value="" />
	</form:form>
		
    <p>댓글</p>
    
    <c:forEach items="${replyList}" var="varReply">
		<p>사용자 - ${varReply.userId}</p>
		<p>댓글 내용- ${varReply.replyContent}</p>
		
		<form:form id="replyFrm" modelAttribute="replyVO" action="/board/${boardVO.boardId}/reply/${varReply.replyId}">
	    	<form:textarea path="replyContent" value="${varReply.replyContent}"/>
	    	<form:hidden path="boardId" value="${boardVO.boardId}"/>
	    	<form:hidden path="userId" value="${session.userId}"/>
	    	<input type="hidden" name="_method" value="" />
	    </form:form>

		<a class="button" href="javascript:fn_submit('patch');">수정</a>
		<a class="button" href="javascript:fn_submit('delete');">삭제</a> 
	</c:forEach>
	
	<form:form id="replyForm" modelAttribute="replyVO" action="/board/${boardVO.boardId}/reply">
	    <form:textarea path="replyContent" value="${varReply.replyContent}"/>
	    <form:hidden path="boardId" value="${boardVO.boardId}"/>
	    <form:hidden path="userId" value="${boardVO.userId}"/>
	    <input type="hidden" name="_method" value="" />
	</form:form>
	
    <a href="javascript:fn_submit('replyForm', '');">댓글 달기</a>
  

</body>
</html>