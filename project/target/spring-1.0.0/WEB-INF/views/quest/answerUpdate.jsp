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
	<div class="main_content">
	<div class="user_quest">
                    <div class="title">
                        <p style="font-size: 30px"><c:out value='${questVO.questTitle}'/></p>
                        <span style="padding: 10px; font-size: 15px;"><c:out value='${questVO.userId}'/></span><span>${questVO.questDate}</span>
                    </div>
                    <div class="quest_content">
                        <p>${questVO.questContent}</p>

                    </div>
                    <div class="good_bad">
                        <button type="button" style="background: #009a06">좋아요 <c:out value='${questVO.questGood}'/></button>
                        <button type="button" style="background: #ba0000">싫어요 <c:out value='${questVO.questBad}'/></button>
                    </div>
                </div>
	<div class="response_form">
		                   <div class="title" style="background: none;">
		                       <p>질문 수정하기</p>
		                   </div>
		                    <form:form modelAttribute="answerVO" method="patch">
		                    	<form:hidden path="userId" value="yunyc1010" />
		                        <form:textarea path="answerContent" id="ckeditor" value="${answerVO.answerContent}" style="width: 100%; height: 400px;"></form:textarea>
		                        <script>
									CKEDITOR.replace("ckeditor", {
									    filebrowserUploadUrl: "<c:url value='/file?${_csrf.parameterName}=${_csrf.token}'/>"
									});
								</script>
		                        <input type="submit" value="수정" />
		                    </form:form>
		                </div>
		                </div>
</body>
</html>