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
	<form:form modelAttribute="boardVO" action="<c:url value='/board/post/${boardVO.boardId}'/>">	
			<button class="post" type="button">글 수정</button>
			<button class="delete" type="button">글 삭제</button>
			<input type="hidden" name="_method" value="" />
	</form:form>
		
    <p>댓글</p>
    
    <c:forEach items="${replyList}" var="varReply">
		<p>사용자 - ${varReply.userId}</p>
		<p>댓글 내용- ${varReply.replyContent}</p>
		
		<form:form id="replyFrm" modelAttribute="replyVO" action="/board/${boardVO.boardId}/reply/${varReply.replyId}">
	    	<form:textarea path="replyContent" value="${varReply.replyContent}"/>
	    	<form:hidden path="boardId" value="${boardVO.boardId}"/>
	    	<form:hidden path="userId" value="${userId}"/>
	    	<input type="hidden" name="_method" value="" />
	    	<button class="patch" type="button">수정</button>
	    	<button class="delete" type="button">삭제</button>
	    </form:form>
	    
	</c:forEach>
	
	<form:form modelAttribute="replyVO" action="/board/${boardVO.boardId}/reply">
	    <form:textarea path="replyContent" value="${varReply.replyContent}"/>
	    <form:hidden path="boardId" value="${boardVO.boardId}"/>
	    <form:hidden path="userId" value="${userId}"/>
	    <input type="hidden" name="_method" value="" />
	    <button class="post" type="button">댓글 달기</button>
	</form:form>
	
    
  

</body>
</html>