<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보 조회</title>
</head>
<body>
	<div class="container">
		<h1>게시글 조회</h1>
			<table class="table">
				<tr hidden>
					<th>게시글 번호</th>
					<td>${boardInfo.bno}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${boardInfo.title}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardInfo.writer}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="3" cols="2" style="width: 400px; height: 300px;" readonly="readonly">${boardInfo.contents}</textarea></td>
				</tr>
				<tr>
					<th>이미지</th> <!-- app.jpg -->
					<td><img style="width:200px;" src="<c:url value="/resources/${boardInfo.image}"/>"></td>
				</tr>
				<tr>
					<th>작성일</th> <!-- app.jpg -->
					<td><fmt:formatDate pattern="yyyy년MM월dd일" value="${boardInfo.regdate}" /></td>
				</tr>
			</table>
			<button onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
			<button onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
	</div>
<script>
</script>
</body>
</html>