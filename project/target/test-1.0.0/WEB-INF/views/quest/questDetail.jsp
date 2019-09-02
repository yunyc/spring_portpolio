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
                        <c:if test="${userId eq questVO.userId}">
                        	<form:form>
                        		<a href="<c:url value='/quest/post/${questVO.questId}'/>">수정</a>
                        		<button class="delete" type="button">삭제</button>
                        	</form:form>
                        </c:if>
                        
                    </div>
                    <div class="quest_content">
                        <p>${questVO.questContent}</p>

                    </div>
                    <div class="good_bad">
                        <button id="good" type="button" style="background: #009a06">좋아요 <span><c:out value='${questVO.questGood}'/></span></button>
                        <button id="bad" type="button" style="background: #ba0000">싫어요 <span><c:out value='${questVO.questBad}'/></span></button>
                    </div>
                </div>
                
                
          
                		<!-- 답변  -->
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
		                    <c:choose>
		                    	<c:when test="${varAnswerList.answerSelect eq '채택안됨' and userId eq questVO.userId}">
		                    		<button id="select" type="button" style="width: 100px; margin: 10px; background: #3985dd; float: left;">채택하기</button>
		                    	</c:when>
		                    	<c:when test="${varAnswerList.answerSelect eq '채택됨'}">
		                    		<button id="select" disabled="disabled" type="button" style="width: 100px; margin: 10px; background: #000; float: left;">채택됨</button>
		                    	</c:when>
		                    	<c:otherwise>
		                        </c:otherwise>
		                    </c:choose>
		                        <c:if test="${userId eq varAnswerList.userId}">
		                        <form:form action="/quest/${questVO.questId}/answer/${varAnswerList.answerId}">
		                        	<a id="button" href="<c:url value='/quest/${questVO.questId}/answer/${varAnswerList.answerId}'/>">수정</a>
		           					<button id="button" class="delete" type="button">삭제</button>
		                        	<input type="hidden" name="_method" value=""/>
		                        </form:form>
		                        </c:if>
		                    </div>
		                </div>
		                </c:forEach>
		                
		                <c:choose>
		                	<c:when test="${userId eq null}">
		                		<p>로그인을 해야 답변할 수 있습니다</p>
		                	</c:when>
		                	<c:otherwise>
		                		<!-- 답변 입력 폼 -->
				                <div class="response_form">
				                   <div class="title" style="background: none;">
				                       <p>답변하기</p>
				                   </div>
				                    <form:form modelAttribute="answerVO" >
				                    	<form:hidden path="userId" value="${userId}" />
				                        <form:textarea path="answerContent" id="ckeditor" style="width: 100%; height: 400px;"></form:textarea>
				                        <script>
											CKEDITOR.replace("ckeditor", {
												filebrowserUploadUrl: "<c:url value='/file?${_csrf.parameterName}=${_csrf.token}'/>"
											});
										</script>
				                        <button onclick="fn_point(200)" class="post" type="button">제출</button>
				                    </form:form>
		                </div>
		                	</c:otherwise>
		                </c:choose>
		                
		                
                	
                
            </div>
            
            <script>
                    window.config = {
                    	"questId": ${questVO.questId},
                    	"good": ${questVO.questGood},
                    	"bad": ${questVO.questBad},
                    	"state": "${questVO.questState}"
                    };
            </script>
     
            
         
</body>
</html>