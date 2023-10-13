
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="info w-100 m-auto">
	<table class="table striped">
		<tbody>
			<tr>
				<th scope="row">profile</th>
				<td><img src="${pageContext.request.contextPath }/upload/${infoMember.profile}"></td>
			</tr>
			<tr>
				<th scope="row">ID</th>
				<td>${loggedID }</td>
			</tr>
			
			<tr>
				<th scope="row">password</th>
				<td>${infoMember.password }</td>
			</tr>
			<tr>
				<th scope="row">name</th>
				<td>${loggedName }</td>
			</tr>
			<tr>
				<th scope="row">post code</th>
				<td>${infoMember.postCode }</td>
			</tr>
			<tr>
				<th scope="row">address</th>
				<td>${infoMember.address }</td>
			</tr>
			<tr>
				<th scope="row">regdate</th>
				<td>${infoMember.regDate }</td>
			</tr>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-center">
		<a href="../member/delete" class="btn btn-primary">회원탈퇴</a>
		<a href="../member/modify" class="btn btn-secondary mx-1">정보수정</a>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>