<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<style>
.quest_content {
    padding: 10px;
    width: calc(100% - 20px);
    min-height: 300px;
    margin-top: 70px;
    
}

</style>
</head>
<body>
	<div class="title" style="width: 862px; position: absolute; z-index: 99;">
               <p style="font-size: 30px"><c:out value='${boardVO.boardTitle}'/></p>
               <span style="padding: 10px; font-size: 15px;">
               		<c:out value='${boardVO.userId}'/>
               	</span>
               	<span><c:out value='${boardVO.boardDate}'/></span>
           </div>
           <div class="main_content">
                <div class="user_quest">
                    <div class="quest_content">
                        <p><c:out value='${boardVO.boardContent}'/></p>
                    </div>
                </div>
                <div id="reply" class="response_form">
                   <div class="title" style="background: none;">
                       <p>댓글</p>
                   </div>
                    <c:forEach items="${replyList}" var="varReply">
						<div class="reply" style="min-height: 150px;">
							<p id="userId">${varReply.userId}님의 댓글</p>
							<p id="date">${varReply.replyDate}작성</p>
							<p id="content">${varReply.replyContent}</p>
							<c:if test="${userId eq varReply.userId}">
							<button class="slide">댓글 수정/삭제</button>
							</c:if>
						</div>
						<div class="regist" style="display: none;">
					    	<form>
								<textarea class="update_text"></textarea>
								<input class="replyId" type="hidden" value="${varReply.replyId}"/>
								<button id="patch" type="button">수정</button>
								<button id="delete" type="button">삭제</button>
							</form>
						</div>

				</c:forEach>
				<c:choose>
					<c:when test="${userId eq null}">
						<p id="notify">로그인을 해야 댓글을 달 수 있습니다</p>
					</c:when>
					<c:otherwise>
						<div id="new">
							<form>
								<textarea class="update_text"></textarea>
								<input id="userIdId" type="hidden" value="${userId}"/>
								<input id="boardId" type="hidden" value="${boardVO.boardId}"/>
								<button id="post">댓글 달기</button>
							</form>
						</div>
					</c:otherwise>
				</c:choose>
				
					
                </div>
            </div>
            
            
     
    
  

</body>
</html>