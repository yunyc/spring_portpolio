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
                    <p>관리자 페이지</p>
               </div>
               <ul class="admin_tab">
                   <li><a href="/admin/user">사용자 관리</a></li>
                   <li><a href="/admin/product">상품 관리</a></li>
                   <li><a href="/admin/quest">질문 관리</a></li>
                   <li><a href="/admin/board">문의사항 관리</a></li>
               </ul>
               <div class="board">
                   <table>
                       <tbody>
                       	   <c:forEach items="${userList}" var="userList">
	                       	   	<tr>
	                               <td><c:out value='${userList.userId}'/></td>
	                               <td><c:out value='${userList.userPoint}'/></td>
	                               <td><c:out value='${userList.userLevel}'/></td>
	                               <td style="width: 100px;"><c:out value='${userList.userDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       	   <c:forEach items="${productList}" var="productList">
	                       	   	<tr>
	                       	   	    <td>
	                       	   	   	   <a href="<c:url value='/product/${productList.productId}'/>">
	                       	   	   	       <c:out value='${productList.productTitle}'/>
	                       	   	   	   </a>
	                       	   	   </td>
	                               <td><c:out value='${productList.productGood}'/></td>
	                               <td><c:out value='${productList.productBad}'/></td>
	                               <td style="width: 100px;"><c:out value='${productList.productDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       	   <c:forEach items="${questList}" var="questList">
	                       	   	<tr>
	                                   <td>
	                                   <a href="<c:url value='/quest/${questList.questId}'/>">
	                                        <c:out value='${questList.questTitle}'/>
	                                   </a>
	                                   </td>
	                               
	                               <td><c:out value='${questList.questGood}'/></td>
	                               <td><c:out value='${questList.questBad}'/></td>
	                               <td><c:out value='${questList.userId}'/></td>
	                               <td style="width: 100px;"><c:out value='${questList.questDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       	   <c:forEach items="${boardList}" var="boardList">
	                       	   	<tr>
	                       	   	   
	                                   <td style="width: 500px;">
	                                   <a href="<c:url value='/board/${boardList.boardId}'/>">
	                                       <c:out value='${boardList.boardTitle}'/>
	                                       </a>
	                                   </td>
	                               
	                               <td><c:out value='${boardList.userId}'/></td>
	                               <td style="width: 100px;"><c:out value='${boardList.boardDate}'/></td>
	                           </tr>
                       	   </c:forEach>
                       </tbody>
                   </table>
               </div>
         
	</div>
	
	
</body>
</html>