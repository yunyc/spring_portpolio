<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	    
	   
</head>
<body>
<script>
	if ("${param.error}" === "loginError") {
		alert("아이디와 비밀번호가 일치하지 않습니다");
	}
</script>
            <div class="main_content">
                <div class="quest_banner">
                	<!--  질문 목록  -->
                   <div class="title">
                       <p>질문/답변 게시판<a href="<c:url value='/quest'/>">더보기</a></p>
                       <span>질문과 답변해서 포인트를 쌓자!</span>
                   </div>
                   <!--  목록 내용  -->
                   <table>
                   	<c:forEach items="${questList}" var="questList" begin="0" end="8">
                   		<tr>
                           <td>
                               <a href="<c:url value='/quest/${questList.questId}'/>">
                                   <c:out value='${questList.questTitle}'/>
                               </a>
                           </td>
                           <td><c:out value='${questList.questDate}'/></td>
                       </tr>
                   	</c:forEach>
                   </table>
                </div>
                <!--  상품 목록  -->
                <div class="product_banner">
                    <div class="title">
                       <p>상품 목록<a href="<c:url value='/product'/>">더보기</a></p>
                        <span>쌓은 포인트로 원하는 상품을 구입하자!</span>
                   </div>
                   <!--  목록 내용  -->
                   <div class="flex_list">
                       <c:forEach items="${productList}" var="productList" begin="0" end="5">
                   		    <div class="product">
                   		    <a href="<c:url value='/product/${productList.productId}'/>">
                   		    	<img class="product_img" src="<c:url value='resources/upload/${productList.productThumnail}'/>" />
                        		<div class="product_content">
                        			<p style="width: 184px"><c:out value='${productList.productTitle}'/></p>
                   		    	</div>
                   		</a>
                       
                        </div>
                   	</c:forEach>
                   </div>
                </div>
                <div class="good_banner">
                    <div class="title">
                       <p>문의사항<a href="<c:url value='/quest'/>">더보기</a></p>
                   </div>
                   <!--  목록 내용  -->
                   <table>
                   	<c:forEach items="${boardList}" var="boardList" begin="0" end="6">
                   		<tr>
                           <td>
                               <a href="<c:url value='/board/${boardList.boardId}'/>">
                                   <c:out value='${boardList.boardTitle}'/>
                               </a>
                           </td>
                           <td><c:out value='${boardList.boardDate}'/></td>
                       </tr>
                   	</c:forEach>
                   </table>
                </div>
            </div> 
</body>
</html>