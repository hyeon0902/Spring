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
		<form name="updateForm" enctype="multipart/form-data">
			<table class="table">
				<tr hidden>
					<th>게시글 번호</th>
					<td><input type="text" name="bno" value="${boardInfo.bno}"></td>
				</tr>
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
					<td>
					<img style="width:200px;" src="<c:url value="/resources/${boardInfo.image}"/>">
					<input type="file" name="image" value="${boardInfo.image }">
					</td>
				</tr>
			</table>
			<button type="button">저장</button>
		</form>
		<script>
		$('form > button:contains(저장)').on('click', boardUpdateAjax);

        function boardUpdateAjax(event) {
            // 통신 진행 여부 결정
            if(!validation()) return;

            // 통신하기 위한 데이터 가져오기
            let boardDta = getBoardInfo()
            console.log('boardDta', boardDta);
            $.ajax('boardUpdate', {
                type : 'post',
                contentType : 'application/json',
                data : JSON.stringify(boardDta)
            })
            .then(result => {
                console.log(result)
            })
            .fail(err => console.log(err));
        }

        function validation(){
			let title = $('[name="title"]');
			let writer = $('[name="writer"]');
			
			if(title.val() == ''){
				alert('제목이 입력되지 않았습니다.');
				title.focus();
				return false;
			}

			if(writer.val() == ''){
				alert('작성자가 입력되지 않았습니다.');
				writer.focus();
				return false;
			}
			
			return true;
        }

        function getBoardInfo() {
            let formAry = $('form[name="updateForm"]').serializeArray();
            console.log(formAry);

            let formObj = {};
            $(formAry).each((idx, tag) => {
                console.log(idx, tag);
                formObj[tag.name] = tag.value;
            });

            return formObj;
        }

        function handleFileSelect(event) {
            const file = event.target.files[0];
            const reader = new FileReader();
            
            reader.onload = function(e) {
                const imgElement = document.querySelector('img');
                imgElement.src = e.target.result;
            }
            
            reader.readAsDataURL(file);
        }

        const fileInput = document.querySelector('input[type="file"]');
        fileInput.addEventListener('change', handleFileSelect);
		</script>
	</div>
</body>
</html>