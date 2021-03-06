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
                
                <c:choose>
                	<c:when test="${mode eq 'normal'}">
                		<!-- 댓글  -->
                		<c:forEach items="${answerList}" var="varAnswerList">
		                	<div class="user_response">
		                	<div class="title">
		                        <p><c:out value='${varAnswerList.userId}' />님의 답변</p>
		                        <span><c:out value='${varAnswerList.answerDate}' /> 작성</span>
		                    </div>
		                    <div class="response_content">
		                        <p>${varAnswerList.answerContent}</p>
		                    </div>
		                    <div class="good_bad">
		                            <button type="button" style="width: 100px; margin: 10px; background: #3985dd; float: left;">채택하기</button>
		                            <a href="/quest/${questId}?mode=update&answerContent=${varAnswerList.answerContent}">수정/삭제</a>
		                    </div>
		                </div>
		                </c:forEach>
		                
		                <!-- 답변 폼 -->
		                <div class="response_form">
		                   <div class="title" style="background: none;">
		                       <p>답변하기</p>
		                   </div>
		                    <form:form class="submit" modelAttribute="answerVO" >
		                    	<form:hidden path="userId" value="yunyc1010" />
		                        <form:textarea path="answerContent" id="ckeditor" style="width: 100%; height: 400px;"></form:textarea>
		                        <script>
									CKEDITOR.replace("ckeditor", {
										filebrowserUploadUrl: "<c:url value='/file?${_csrf.parameterName}=${_csrf.token}'/>"
									});
								</script>
		                        <button class="post" type="button">제출</button>
		                    </form:form>
		                </div>
                	</c:when>
                	<c:otherwise>
                		 <!-- 수정 및 삭제 -->
                		 <jsp:include page="/WEB-INF/views/quest/questUpdate.jsp">
                		 	<jsp:param name="answerContent" value="${answerVO.answerContent}"/>
                		 </jsp:include>
                	</c:otherwise>
                </c:choose>
                
            </div>
            
         
</body>
</html>