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
						<div class="reply" style="min-height: 200px;">
							<p>${varReply.userId}</p>
							<p>${varReply.replyContent}</p>
							<button id="slide">댓글 수정/삭제</button>
						</div>
						<div id="regist" style="display: none;">
					    	<form>
								<textarea id="update_text" rows="" cols=""></textarea>
								<input id="replyId" type="hidden" value="${varReply.replyId}"/>
								<input id="boardId" type="hidden" value="${boardVO.boardId}"/>
								<button id="patch" type="button">수정</button>
								<button type="button">삭제</button>
							</form>
						</div>
						
                   
				</c:forEach>
				<div id="new">
					<form>
						<textarea id="submit" rows="" cols=""></textarea>
						<input id="userId" type="hidden" value="yunyc1010"/>
						<button id="post">댓글 달기</button>
					</form>
				</div>
					
                </div>
            </div>
            
            
     
    
  

</body>
</html>