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
	<div class="response_form">
		                   <div class="title" style="background: none;">
		                       <p>질문 수정/삭제하기</p>
		                   </div>
		                    <form:form class="submit" modelAttribute="answerVO" >
		                    	<form:hidden path="userId" value="yunyc1010" />
		                        <form:textarea path="answerContent" id="ckeditor" value="${answerContent}" style="width: 100%; height: 400px;"></form:textarea>
		                        <script>
									CKEDITOR.replace("ckeditor", {
										filebrowserUploadUrl: "<c:url value='/file?${_csrf.parameterName}=${_csrf.token}'/>"
									});
								</script>
		                        <button class="patch" type="button">수정</button>
		                        <button class="delete" type="button">삭제</button>
		                    </form:form>
		                </div>
</body>
</html>