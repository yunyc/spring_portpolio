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
	<script src="<c:url value='/resources/ckeditor/ckeditor.js'/>"></script>
	

	<div class="main_content">
                <div class="title">
                    <p>상품 등록</p>
                </div>
                <div class="regist">
                    <form:form modelAttribute="productVO" action="?${_csrf.parameterName}=${_csrf.token}" 
                    	  enctype="multipart/form-data">
                       <p>상품 제목</p>
                        <form:input path="productTitle" value="${productVO.productTitle}" style="width: 300px; height: 30px;" placeholder="제목을 입력하세요" />
                        <form:errors path="productTitle"/>
                        <p>상품타입</p>
                        <form:select path="productType" style="width: 150px; height: 30px;">
                            <form:option value="코드">코드</form:option>
                            <form:option value="강의">강의</form:option>
                            <form:option value="책">책</form:option>
                            <form:option value="문화상품권">문화상품권</form:option>
                        </form:select>
                        <p>상품 구매 포인트<p>
                        <form:input path="productPoint" value="${productVO.productPoint}"/>
                        <p>상품 썸네일 이미지</p>
                        <input type="file" name="file" value="${productVO.productThumnail}"/>
                        <p>상품 내용</p>
                        <form:textarea id="ckeditor" path="productDescription" value="${productVO.productDescription}" style="width: 100%; height: 300px;" placeholder="상품 설명을 해주세요"></form:textarea>
                        <script>
							CKEDITOR.replace("ckeditor", {
								filebrowserUploadUrl: "<c:url value='/product/file?${_csrf.parameterName}=${_csrf.token}'/>"
							});
						</script>
						<c:if test="${mode eq 'insert'}">
							<button class="button" type="button">취소</button>
                        	<input class="button" type="submit" value="제출"/>
						</c:if>
                        <c:if test="${mode eq 'update'}">
                            <button class="button delete" type="button">수정</button>
                        </c:if>
                        <input type="hidden" name="_method" value=""/>
                        
                    </form:form>
                </div>
            </div>
</body>
</html>