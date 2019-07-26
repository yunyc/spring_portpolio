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
	
		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>분류</td>
					<td>날짜</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="varBoardList">
					<tr>
						<td>${varBoardList.boardId}</td>
						<td><a href="/board/${varBoardList.boardId}">
							${varBoardList.boardTitle}</a></td>
						<td>${varBoardList.userId}</td>
						<td>${varBoardList.boardType}</td>
						<td>${varBoardList.boardDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul>
			<c:forEach items="${boardPageVO}" var="boardPage" begin="0" end="10" step="1" varStatus="status">
				<li><a href="/board?currentPage=${status.count}">${status.count}</a></li>
			</c:forEach>
		</ul>
		
		<script>
			
		</script>
		
		<form method="get" action="/board/newboard">
			<input type="hidden" name="method" value="post"/>
			<input type="submit" value="새 글 쓰기"/>
		</form>
		
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
</body>
</html>