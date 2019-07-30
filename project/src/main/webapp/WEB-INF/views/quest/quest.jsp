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
	<p>질문 목록</p>
	<c:forEach items="${questList}" var="varQuestList">
		<div>
			<a href="/quest/${varQuestList.questId}">
				<p><c:out value="${varQuestList.questTitle}"/></p>
				<p><c:out value="${varQuestList.questContent}"/></p>
				<p><c:out value="${varQuestList.questDate}"/></p>
			</a>
		</div>
	</c:forEach>
	<p><a href="/quest/post">질문하기</a></p>
		
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
</body>
</html>