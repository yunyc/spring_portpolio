<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="sidebar">
                <div class="login">
                <sec:authorize access="isAnonymous()">
                    <div class="title">
                        <p>로그인</p>
                    </div>
                    <div class="login_form">
                    	<form:form action="<c:url value='/login/check'/>">
                        	<input type="text" name="userId" placeholder="아이디" />
                        	<input type="password" name="password" placeholder="비밀번호" />
                        	<input type="submit" value="로그인" />
                    	</form:form>
                    <label>자동로그인<input id="remember" type="checkbox" name="checkbox" /></label>
                    <label>
                    	<a href="<c:url value='/signUp'/>">회원가입</a> 
                    	<a href="<c:url value='/find'/>">  정보 찾기</a>
                    </label>
                    </div>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
	                		<div class="login_success">
                       <div class="profile">
                           
                       </div>
                        <ul style="float: left;">
                            <li style="float: none;margin: 4px;">${userId}님</li>
                            <li style="float: none;margin: 4px;">일반등급</li>
                            <li style="float: none;margin: 4px;">00포인트</li>
                        </ul>
                    </div>
                    <div class="option">
                            <p><a href="#"><span style="float: right;">마이페이지</span></a></p>
                        </div>
	                	</sec:authorize>

                </div>
                <div class="recent">
                  <div class="title">
                        <p>Best! 질문/답변</p>
                    </div>
                    <table>
                       <tr>
                           <td width="290px">아아아아아앙아아</td>
                       </tr>
                       <tr>
                           <td>아아아아아앙아아</td>
                       </tr>
                       <tr>
                           <td>아아아아아앙아아</td>
                       </tr>   
                   </table>
                </div>
                <div class="recent">
                  <div class="title">
                        <p>Best! 상품</p>
                    </div>
                </div>
                
            </div>
</body>
</html>