<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<style>
	.admin_tab a {
		padding: 10px;
    	border: 1px solid #ccc;
    	margin: 10px;
	}
</style>
</head>
<body>
	<div class="main_content">
               <div class="title">
                    <p>마이 페이지</p>
               </div>
               <ul class="admin_tab">
                   <li><a href="/mypage/user">내 정보</a></li>
                   <li><a href="/mypage/order">내 주문</a></li>
                   <li><a href="/mypage/quest">내 질문</a></li>
                   <li><a href="/mypage/board">내 문의사항</a></li>
               </ul>
               <div class="board">
                   <table>
                       <tbody>
                       	   <c:forEach items="${userList}" var="userList">
	                       	   	<tr>
	                               <td><c:out value='${userList.userId}'/>사용자</td>
	                               <td><c:out value='${userList.userPoint}'/>포인트</td>
	                               <td><c:out value='${userList.userLevel}'/>등급</td>
	                               <td style="width: 100px;"><c:out value='${userList.userDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       	 
                       	   <c:forEach items="${questList}" var="questList">
	                       	   	<tr>
	                                   <td>
	                                   <a href="<c:url value='/quest/${questList.questId}'/>">
	                                        <c:out value='${questList.questTitle}'/>
	                                   </a>
	                                   </td>
	                               
	                               <td>좋아요<c:out value='${questList.questGood}'/>개</td>
	                               <td>싫어요<c:out value='${questList.questBad}'/>개</td>
	                               <td><c:out value='${questList.userId}'/>사용자</td>
	                               <td style="width: 100px;"><c:out value='${questList.questDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       	   <c:forEach items="${orderList}" var="orderList">
	                       	   	<tr>
	                               <td><c:out value='${orderList.orderTitle}'/></td>
	                               <td style="width: 100px;"><c:out value='${orderList.orderDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       	   <c:forEach items="${boardList}" var="boardList">
	                       	   	<tr>
	                       	   	   
	                                   <td style="width: 500px;">
	                                   <a href="<c:url value='/board/${boardList.boardId}'/>">
	                                       <c:out value='${boardList.boardTitle}'/>
	                                       </a>
	                                   </td>
	                               
	                               <td><c:out value='${boardList.userId}'/>사용자</td>
	                               <td style="width: 100px;"><c:out value='${boardList.boardDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       </tbody>
                   </table>
               </div>
         
	</div>
	
	
</body>
</html>