<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
	<div class="container">
	<h2 class="mb-5 mt-5">write</h2>
	<form action="../board/write-process" method="post">
	<input type="hidden" name="name" value="정현목">
	<input type="hidden" name="userID" value="mok119">
	<div class="form-floating mb-3">
	  <input type="text" class="form-control" id="title" placeholder="제목을 쓰세요." name="title">
	  <label for="title">title</label>
	</div>
	<div class="form-floating">
	  <textarea class="form-control" placeholder="내용을 입력하세요." id="content" style="height: 300" name="content"></textarea>
	  <label for="content">Comments</label>
	</div>
	
	<div class="mt-5 mb-5 d-flex justify-content-center">
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="reset" class="btn btn-secondary mx-2">취소</button>
	</div>

	</form>
	</div>
<%@ include file="../include/footer.jsp" %>