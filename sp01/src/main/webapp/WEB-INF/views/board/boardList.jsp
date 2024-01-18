<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시글 조회</title>
</head>
<body>
	<div class="container">
		<h1>자유 게시판</h1>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th> <!-- yyyy년MM월dd일 -->
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${boardList}" var="list" varStatus="sts">
				<tr onclick="location.href='boardInfo?bno=${list.bno}'">
					<td>${list.bno}</td>
					<td>${list.title}</td>
					<td>${list.writer}</td>
					<td>
					<fmt:formatDate pattern="yyyy년MM월dd일" value="${list.regdate}" />
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>