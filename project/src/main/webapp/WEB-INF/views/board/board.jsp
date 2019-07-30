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
				<c:forEach items="${boardList}" var="varBoardList" begin="${pagingVO.startIndex}" end="${pagingVO.endIndex}">
					<tr>
						<td><c:out value="${varBoardList.boardId}"/></td>
						<td>
							<a href="/board/${varBoardList.boardId}">
								<c:out value="${varBoardList.boardTitle}"/>
							</a>
						</td>
						<td><c:out value="${varBoardList.userId}"/></td>
						<td><c:out value="${varBoardList.boardType}"/></td>
						<td><c:out value="${varBoardList.boardDate}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul>
			<li><a href="/board?currentPage=${pagingVO.currentPage - 1}">이전</a></li>
			<c:forEach var="page" begin="${pagingVO.startPage}" end="${pagingVO.endPage}">
				<li><a href="/board?currentPage=${page}">${page}</a></li>
			</c:forEach>
			<li><a href="/board?currentPage=${pagingVO.currentPage + 1}">다음</a></li>
		</ul>
		
		<a href="/board/post">새 글 쓰기</a>
		
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
</body>
</html>