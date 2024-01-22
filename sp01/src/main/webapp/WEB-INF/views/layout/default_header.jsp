<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="container">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath }/" class="nav-link active" aria-current="page">메인</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empList" class="nav-link">전체 사원 조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empInsert" class="nav-link">사원 정보 등록</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardList" class="nav-link">게시판 조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardInsert" class="nav-link">게시글 등록</a></li>
      </ul>
    </header>
    
  </div>