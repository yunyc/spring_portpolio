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
            	<!--  이벤트 배너  -->
                <div class="event_banner">
                    
                </div>
                <div class="quest_banner">
                	<!--  질문 목록  -->
                   <div class="title">
                       <p>질문/답변 게시판<a>더보기</a></p>
                       <span>질문과 답변해서 포인트를 쌓자!</span>
                   </div>
                   <!--  목록 내용  -->
                   <table>
                   	<c:forEach items="${questList}" var="questList" begin="0" end="6">
                   		<tr>
                           <td width="290px"><c:out value='${questList.questTitle}'/></td>
                           <td><c:out value='${questList.questDate}'/></td>
                       </tr>
                   	</c:forEach>
                   </table>
                </div>
                <!--  상품 목록  -->
                <div class="product_banner">
                    <div class="title">
                       <p>상품 목록<a>더보기</a></p>
                        <span>쌓은 포인트로 원하는 상품을 구입하자!</span>
                   </div>
                   <!--  목록 내용  -->
                   <div class="flex_list">
                       <c:forEach items="${productList}" var="productList" begin="0" end="3">
                   		    <div class="product">
                   		    	<img src="<c:url value='resources/upload/${productList.productThumnail}'/>" />
                        		<div class="product_content">
                        			<p><c:out value='${productList.productTitle}'/></p>
                   		    	</div>
                   		
                       
                        </div>
                   	</c:forEach>
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