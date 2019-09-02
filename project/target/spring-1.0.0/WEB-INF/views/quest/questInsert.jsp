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

<style>
    .quest_form p {
        margin: 5px 0;
        margin-top: 20px;
    }
    
    .quest_form input {
        width: 100%;
        height: 30px;
        font-size: 15px;
    }
    
    button {
    float: right;
    margin: 10px;
    width: 100px;
    height: 40px;
    font-size: 20px;
    background: #0877ee;
    border: none;
    color: #fff;
}
    
    </style>
</head>
<body>
	<div class="main_content">
                <div class="title">
                    <p>질문하기</p>
                </div>
                <div class="quest_form">
                    <form:form class="submit" modelAttribute="questVO">
                    <form:hidden path="userId" value="${userId}"/>
                    <p>질문 제목</p>
                    <form:input path="questTitle" value="${questVO.questTitle}" placeholder="제목을 입력하세요" />
                    <form:errors path="questTitle"/>
                    <p>질문 내용</p>
                    <form:textarea id="ckeditor" path="questContent" value="${questVO.questContent}" placeholder="내용을 입력하세요" style="width: 100%; min-height: 300px"></form:textarea>
                    <script >
						CKEDITOR.replace("ckeditor", {
							filebrowserUploadUrl: "<c:url value='/file?${_csrf.parameterName}=${_csrf.token}'/>"
						});
					</script>
                    <input type="hidden" name="_method" value="" />
                    
                        <c:choose>
							<c:when test="${method eq 'post'}">
								<button onclick="fn_point(100)" class="post" type="button">제출</button>
							</c:when>
							<c:otherwise>
								<button class="patch" type="button">수정</button>
							</c:otherwise>
						</c:choose>
						<button onclick="history.back()" type="button">취소</button>
                   
                    </form:form>
                </div>
            </div>
            
	

</body>
</html>