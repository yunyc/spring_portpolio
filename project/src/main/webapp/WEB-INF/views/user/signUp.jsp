<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<style>
	p {
		margin: 0;
	}
	
	#sign {
    	margin: 20px 0;
    	width: 350px;
	}
	
</style>
</head>
<body>
	<script>
		$(function() {
			$("#sign").click(function() {
				$.ajax({
					url: "/signUp",
					type: "post",
					beforeSend : function(xhr) {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
		                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
		            },
		            success: function(data) {
		            	alert("인증 메일을 발송했습니다");
		            },
		            error: function(data) {
		            	alert("입력 양식을 지켜주세요")
		            }
				});
			});
		});
		
	</script>
	<div class="main_content">
                <div class="content_title">
                    <p>회원가입</p>
                </div>
	<form:form method="post" modelAttribute="userVO">
		<p>아이디</p>
		<form:input path="userId" />
		<form:errors path="userId" cssClass="err" />
		<p>비밀번호</p>
		<form:input path="userPassword"/>
		<form:errors path="userPassword" cssClass="err" />
		<p>비밀번호 확인</p>
		<form:input path="passwordConfirm"/>
		<form:errors path="passwordConfirm" cssClass="err" />
		<p>이메일</p>
		<form:input path="emailPrefix"/>@<form:input path="emailSuffix"/>
		<form:errors path="emailPrefix" cssClass="err" />
		<form:errors path="emailSuffix" cssClass="err" />
		<input id="sign" type="submit" />
	</form:form>
	</div>


</body>
</html>