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
						<td><a href="/board/boardDetail.do?boardId=${varBoardList.boardId}">
							${varBoardList.boardTitle}</a></td>
						<td>${varBoardList.userId}</td>
						<td>${varBoardList.boardType}</td>
						<td>${varBoardList.boardDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul>
			<c:forEach items="${boardPageVO}" var="boardPage" begin="1" end="10" step="1" varStatus="status">
			<li><a href="/board.do?currentPage=${status.index + 1}">${status.index + 1}</a></li>
			</c:forEach>
		</ul>
		
		<a href="/common/boardInsert.do">글쓰기</a>
	
</body>
</html>