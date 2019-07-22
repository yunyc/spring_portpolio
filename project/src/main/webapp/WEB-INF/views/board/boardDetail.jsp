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
	<p>제목 - ${boardList.boardTitle}, 분류 - ${boardList.boardType}</p>
	<p>글 내용</p>
	<p>${boardList.boardContent}</p>
	<c:forEach items="${replyList}" var="varReplyList">
		<p>사용자 - ${varReplyList.userId}</p>
		<p>댓글 내용- ${varReplyList.replyContent}</p>
		<p><a href="/board/boardDetail/replyRegister.do?boardId=${boardList.boardId}&mode=update">수정</a></p>
		<p><a href="/board/boardDetail/replyRegister.do?boardId=${boardList.boardId}&mode=delete">삭제</a></p>
	</c:forEach>
	<p><a href="/board/boardDetail/replyRegister.do?boardId=${boardList.boardId}&mode=insert">답글 달기</a></p>
	
	
</body>
</html>