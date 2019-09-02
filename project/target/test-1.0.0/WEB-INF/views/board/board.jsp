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
	<div class="main_content">
               <div class="content_title">
                   문의사항
               </div>
               <div class="board">
                   <table>
                       <thead>
                           <tr width="100px">
                               <td width="40px">번호</td>
                               <td width="500px">제목</td>
                               <td width="200px">작성자</td>
                               <td width="100px">날짜</td>
                           </tr>
                       </thead>
                       <tbody>
                           <c:forEach items="${boardList}" var="varBoardList" begin="${pagingVO.startIndex}" end="${pagingVO.endIndex}">
								<tr>
									<td><c:out value="${varBoardList.boardId}"/></td>
									<td>
										<a href="/board/${varBoardList.boardId}">
											<c:out value="${varBoardList.boardTitle}"/>
											<c:if test="${varBoardList.replyCnt != 0}">
												<span class="replyCnt">[<c:out value='${varBoardList.replyCnt}'/>]</span>
											</c:if>
										</a>
									</td>
									<td><c:out value="${varBoardList.userId}"/></td>
									<td><c:out value="${varBoardList.boardDate}"/></td>
								</tr>
							</c:forEach>
                       </tbody>
                   </table>
               </div>
               <ul class="pagination">
                <li><a href="<c:url value='/board?currentPage=${pagingVO.startPage - 1}'/>">&laquo;</a></li>
                <c:forEach var="page" begin="${pagingVO.startPage}" end="${pagingVO.endPage}">
					<li><a href="<c:url value='/board?currentPage=${page}'/>">${page}</a></li>
				</c:forEach>
                <li><a href="<c:url value='/board?currentPage=${pagingVO.endPage + 1}'/>">&raquo;</a></li>
            </ul> 
            <a class="new_post" href="<c:url value='/board/post'/>">새 글 쓰기</a>    
            </div>	
</body>
</html>