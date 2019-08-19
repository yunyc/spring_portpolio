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
                    	<form:form action="/login/check">
                        	<input type="text" name="userId" placeholder="아이디" />
                        	<input type="password" name="password" placeholder="비밀번호" />
                        	<input type="submit" value="로그인" />
                    	</form:form>
                    <label>
                    	<a id="signup" href="#" style="float:left; margin:7px;">회원가입</a> 
                    	<a id="find" href="#" style="float:left; margin:7px;">  정보 찾기</a>
                    </label>
                    </div>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
	                		<div class="login_success">
                       <img src="<c:url value='/resources/upload/kakao_1.jpg'/>" class="profile">
                           
                       </img>
                        <ul style="float: left;">
                            <li style="float: none;margin: 4px;">${userId}님</li>
                            <li id="level"style="float: none;margin: 4px;">${userLevel}등급</li>
                            <li id="point" style="float: none;margin: 4px;">${userPoint}포인트</li>
                        </ul>
                    </div>
                    <div class="option">
                    	<form:form action="/logout">
                    	<sec:authorize access="hasAuthority('ROLE_USER')">
                    		<a href="<c:url value='/mypage/user'/>" style="margin: 0; padding: 0;"><span style="float:right; color:#000">마이페이지</span></a>
                    		</sec:authorize>
                    		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
                    			<a href="/admin/user" style="margin: 0; padding: 0;"><span style="float:right; color:#000">관리자 페이지</span></a>
                    		</sec:authorize>
                        	<input type="submit" style="width:100px; float:left; color:#000" value="로그아웃"/>
                    	</form:form>
                            
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