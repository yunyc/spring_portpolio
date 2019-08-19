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
    	<div class="search_banner">
    	<a href="<c:url value='/quest/post'/>" style="float:left;">질문하기</a>
        	<div class="search_bar" style="float:right; margin-bottom: 10px;">
                <form method="get">
                    <input type="text" name="keyword" placeholder="검색 단어를 입력하세요">
                    <input type="submit" />
                </form>
            </div>
            	<!-- 질문 상태 탭 -->
                    <ul class="tab">
                        <li><a href="<c:url value='/quest'/>">답변을 기다리는 질문</a></li>
                        <li><a href="<c:url value='/quest?questState=답변 완료'/>">답변이 완료된 질문</a></li>
                        <li><a href="<c:url value='/quest?questGood=1'/>">좋아요가 높은 질문</a></li>
                    </ul>
                </div>
                <!-- 질문 목록 -->
                <div id="questList" class="quest_list">
                    <c:forEach items="${questList}" var="varQuestList" begin="0" end="4">
                    	<div class="quest">
                           <a href="<c:url value='/quest/${varQuestList.questId}'/>">
                            <div class="title">
                                <label><c:out value='${varQuestList.questTitle}' /></label>
                                <span style="float:right;"><c:out value='${varQuestList.questState}' /></span>
                            </div>
                            <div class="content">
                                <p>${varQuestList.questContent}</p>
                            </div>
                            <div class="response">
                                <div class="response_list">
                                    <p>답변 <c:out value='0' />개</p>
                                </div>
                                <div class="response_list">
                                    <p>추천 <c:out value='${varQuestList.questGood}' />개</p>
                                </div>
                            </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
                
				<button id="questLoad" type="button">5개 더보기</button>
			</div>
</body>
</html>