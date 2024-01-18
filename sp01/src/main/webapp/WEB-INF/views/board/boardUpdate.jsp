<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<div class="container">
		<h1>게시글 수정</h1>
		<form action="boardUpdate" method="post" >
			<table class="table">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${boardInfo.title}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="${boardInfo.writer}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="" cols="" name="contents" >${boardInfo.contents }</textarea></td>
				</tr>
				<tr>
					<th>이미지</th> <!-- app.jpg -->
					<td><input type="text" name="image" value="${boardInfo.contents }"></td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
		
	</div>
</body>
</html>