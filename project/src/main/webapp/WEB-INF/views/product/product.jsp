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
                <div class="product_content">
                    <div class="title">
                        <p>상품 목록</p>
                    </div>
                    <div class="option">
                        <form:form modelAttribute="productVO" method="get">
                           <ul class="tab">
                                <li><a href="<c:url value='/product'/>" style="background: #fff; color: #000 ">최신순</a></li>
                                <li><a href="<c:url value='/product?productGood=1'/>" style="background: #fff; color: #000 ">추천순</a></li>
                           </ul>
                            <div class="search">
                                <form:input path="keyword" placeholder="검색 키워드를 입력하세요" />
                                <form:select path="productType">
                                    <form:option value="">없음</form:option>
                                    <form:option value="코드">코드</form:option>
                                    <form:option value="강의">강의</form:option>
                                    <form:option value="책">책</form:option>
                                    <form:option value="문화상품권">문화상품권</form:option>
                                </form:select>
                                <input type="submit" value="검색">
                            </div>
                        </form:form>
                    </div>
                    <div class="product_list">
                    	<c:forEach items="${productList}" var="varProductList" begin="${pagingVO.startIndex}" end="${pagingVO.endIndex}">
	                    	<div class="product">
	                            <a href="/product/${varProductList.productId}">
	                                <p><c:out value="${varProductList.productTitle}"/></p>
	                                <img class="thumnail" src="<c:url value='/resources/upload/${varProductList.productThumnail}'/>" />	                            </a>
	                            <div class="info">
	                                <label>좋아요 <c:out value="${varProductList.productGood}"/></label>
	                                <span><c:out value='${varProductVO.productDate}'/></span>
	                            </div>
	                        </div>
                    	</c:forEach>
                    </div>
                </div>
                <ul class="pagination">
                    <li><a href="<c:url value='/product?currentPage=${pagingVO.startPage - 1}'/>">&laquo;</a></li>
                    <c:forEach var="page" begin="${pagingVO.startPage}" end="${pagingVO.endPage}">
                    	<li><a href="<c:url value='/product?currentPage=${page}'/>">${page}</a></li>
                    </c:forEach>
                    <li><a href="<c:url value='/product?currentPage=${pagingVO.endPage + 1}'/>">&raquo;</a></li>
                </ul>
              
                <a id="new_product" href="/product/regist">새 상품등록</a>
            </div>
</body>
</html>