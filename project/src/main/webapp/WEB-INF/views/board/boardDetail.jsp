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
	<script>
		// PATCH, DELETE용 메서드
		function fn_submit(formId, method) {
			$("#" + formId + ">" + "[name=_method]").val(method);
			$("#" + formId).submit();
		}
	</script>
	<form:form id="boardFrm" modelAttribute="boardVO" action="/board/post/${boardVO.boardId}">
			<form:hidden path="boardId" value="${boardVO.boardId}" />
			<form:hidden path="boardTitle" value="${boardVO.boardTitle}" />
			<form:hidden path="boardContent" value="${boardVO.boardContent}" />
			<form:hidden path="boardType" value="${boardVO.boardType}" />			
			<input type="submit" value="글 수정" />
			<a href="javascript:fn_submit('boardFrm', 'delete');">글 삭제</a>
			<input type="hidden" name="_method" value="" />
	</form:form>
		
    <p>댓글</p>
    <a href="javascript:fn_Submit('post')">댓글 달기</a>
      
	<c:forEach items="${replyList}" var="varReplyList">
		<p>사용자 - ${varReplyList.userId}</p>
		<p>댓글 내용- ${varReplyList.replyContent}</p>
		<a href="javascript:fn_Submit('replyFrm', 'patch');">수정</a>
		<a href="javascript:fn_Submit('replyFrm', 'delete');">삭제</a> 
	</c:forEach>
	
	<form:form modelAttribute="replyVO" id="replyFrm" method="post">
		<form:input path="replyContent"/>
		<form:hidden path="userId" value="${boardList.userId}"/>
		<form:hidden path="boardId" value="${boardList.boardId}" />
	</form:form>
	
	
	
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>
</html>