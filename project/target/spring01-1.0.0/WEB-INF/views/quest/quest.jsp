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
                    <div class="search_bar">
                        <a href="/quest/post">질문하기</a>
                        <form action="" method="post">
                            <input type="text" name="textfield" placeholder="검색 단어를 입력하세요">
                            <input type="submit" />
                       </form>
                    </div>
                    <ul class="tab">
                        <li><a href="#">답변을 기다리는 질문</a></li>
                        <li><a href="#">답변이 완료된 질문</a></li>
                        <li><a href="#">내가 찜한 질문</a></li>
                    </ul>
                </div>
                <div id="questList" class="quest_list">
                    <c:forEach items="${questList}" var="varQuestList" begin="0" end="5">
                    	<div class="quest">
                           <a href="/quest/${varQuestList.questId}">
                            <div class="title">
                                <p><c:out value='${varQuestList.questTitle}' /></p>
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
				<button id="questLoad" type="button">더보기</button>

            </div>
		
			<script>
				$(function() {
					// 질문 로딩 버튼
					$("#questLoad").click(function() {
						$.ajax({
							url: "<c:url value='/quest' />",
							type: "post",
							success: function(data) {
								$.each(data.questList, function(i, item) {
									
									if (i > 2) {
										$("#questList").append("<div class='quest'><a href='#'>" +
												"<div class='title'><p>" + item.questTitle + "</p></div>" +
												"<div class='content'><p>" + item.questContent + "</p></div>" +
												"<div class='response'> <div class='response_list'><p>답변 0개" +
												"</p></div><div class='response_list'><p>추천" + 
												item.questGood + "개</p></div></div></a></div>");
									}
									
								});
								
							},
							error: function(data, errorThrown) {
								alert(errorThrown);
								
							},
							beforeSend: function(xhr) {
								xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
							}
							
						});
					});	
				});
			</script>
</body>
</html>