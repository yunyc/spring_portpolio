<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <title>이름</title>
	   
	</head>
	<body>
            <div class="main_content">
                <div class="event_banner">
                    
                </div>
                <div class="quest_banner">
                   <div class="title">
                       <p>질문/답변 게시판<a>더보기</a></p>
                       <span>질문과 답변해서 포인트를 쌓자!</span>
                   </div>
                   <table>
                   	<c:forEach items="${questList}" var="questList" begin="0" end="4">
                   		<tr>
                           <td width="290px"><c:out value='${questList.questTitle}'/></td>
                           <td><c:out value='${questList.questDate}'/></td>
                       </tr>
                   	</c:forEach>
                   </table>
                </div>
                <div class="product_banner">
                    <div class="title">
                       <p>상품 목록<a>더보기</a></p>
                        <span>쌓은 포인트로 원하는 상품을 구입하자!</span>
                   </div>
                   <div class="flex_list">
                           <div class="product"> 
                           dkdk  
                           </div>
                           <div class="product"> 
                       </div>
                           
                       </div>
                </div>
                <div class="good_banner">
                    <div class="title">
                       <p>안녕하하</p>
                   </div>
                </div>
            </div> 
</body>
</html>