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
	<form:form modelAttribute="questVO">
		<form:hidden path="userId" value="${userId}"/>
		<p>질문 제목</p>
		<form:input path="questTitle" value="${questVO.questTitle}"/>
		<p>질문 내용</p>
		<form:textarea path="questContent" value="${questVO.questContent}"/>
		
		<c:choose>
			<c:when test="${method eq 'post'}">
				<a class="button" href="javascript:fn_submit('post');">생성</a>
			</c:when>
			<c:otherwise>
				<a class="button" href="javascript:fn_submit('patch');">수정</a>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="_method" value=""/>
	</form:form>
	
	<form:form action="/quest/post?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="submit" value="제출"/>
	</form:form>
	
</body>
</html>