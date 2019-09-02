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
               <div class="title">
                   <p><c:out value='${productVO.productTitle}'/>
                	<sec:authorize access="hasRole('ROLE_ADMIN')">
                   <form:form method="delete">
                        <button class="delete" type="button">삭제</button>
                        <a href="/product/regist/${productVO.productId}">수정</a>
                   </form:form>
                   </sec:authorize>
                   </p>
                   <span>관리자</span>
                   <span><c:out value='${productVO.productDate}'/></span>
                   <span><c:out value='${productVO.productPoint}'/>포인트</span>
               </div>
               <div class="product_content">
                  <img class="product_img" src="<c:url value='/resources/upload/${productVO.productThumnail}'/>" />
                   <br/>
                   <div class="description">
                       ${productVO.productDescription}
                   </div>
                   <a class="list" href="<c:url value='/product'/>">상품 목록</a>
                   <a id="purchase" class="list" href="#">상품 구매</a>
                   <div class="button_group" style="float: right;">
                          <button id="good" type="button" style="background: #009a06;">좋아요 <span><c:out value='${productVO.productGood}'/></span></button>
                           <button id="bad" type="button" style="background: #ba0000;">싫어요 <span><c:out value='${productVO.productBad}'/></span></button>
                       </div>
               </div>
            
            </div>
            <script>
                window.config = {
                    "productId": ${productVO.productId},
                    "productTitle": "${productVO.productTitle}",
                    "good": ${productVO.productGood},
                    "bad": ${productVO.productBad},
                    "point": ${productVO.productPoint},
                    "userId": "${userId}",
                    "userPoint": ${userPoint}
                };
            </script>
	
	
</body>
</html>