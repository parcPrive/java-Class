<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div class="container">
		<h2 class="mb-5 mt-5">WRITE</h2>
		<!-- write-process에 매핑되는 controller가 있어야함. -->
		<form action="../board/reply-process" method="post">
			<input type="hidden" name="name" value="정현목">
			<input type="hidden" name="userID" value="mok119">
			<input type="hidden" name="regroup" value="${param.regroup }">
			<input type="hidden" name="relevel" value="${param.relevel }">
			<input type="hidden" name="restep" value="${param.restep }">
			
			
			<div class="form-floating mb-3">
			  <input type="text" class="form-control" id="title" placeholder="제목을 쓰세요." name="title">
			  <label for="title">title</label>
			</div>
			<div class="form-floating">
			  <textarea class="form-control" placeholder="내용을 입력하세요." name="content" id="content" style="height: 300px"></textarea>
			  <label for="content">content</label>
			</div>
			<div class="mt-5 mb-5 d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">확인</button>
				<button type="reset" class="btn btn-secondary mx-1">취소</button>
			</div>
			
		</form>
	</div>
<%@ include file="../include/footer.jsp" %>
    