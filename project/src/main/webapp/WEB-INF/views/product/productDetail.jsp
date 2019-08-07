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
                   <p><c:out value='${productVO.productTitle}'/><a href="#">삭제</a><a href="#">수정</a></p>
                   <span>작성자</span>
                   <span>등급</span>
                   <span>0000-00-00</span>
               </div>
               <div class="product_content">
                  <img class="product_img" src="<c:url value='/resources/upload/${productVO.productThumnail}'/>" />
                   <br/>
                   <div class="description">
                       ${productVO.productDescription}
                   </div>
                   <a href="/product">상품 목록</a>
                   <div class="button_group" style="float: right;">
                          <button type="button" style="background: #009a06;">좋아요 <c:out value='${productVO.productGood}'/></button>
                           <button type="button" style="background: #ba0000;">싫어요 <c:out value='${productVO.productBad}'/></button>
                       </div>
               </div>
            
            </div>
	
	
</body>
</html>