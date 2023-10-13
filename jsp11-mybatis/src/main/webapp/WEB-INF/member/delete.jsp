
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>



<div class="info w-100 m-auto">
	<form action="../member/delete-process" method="post">
		<input type="hidden" name="userID" value="${loggedID }"> 
		<table class="table striped">
			<tbody>
				<tr>
					<th scope="row">ID</th>
					<%-- <td><input type="text" class="form-control" 
					name="userID" value="<%= loggedID %>" readonly></td> --%>
					<td>${loggedID }</td>
				</tr>
				<tr>
					<th scope="row">password</th>
					<td><div class="mb-3">
							<input
								type="password" class="form-control" id="userPW"
								placeholder="user password" name="userPW" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div class="d-flex justify-content-center">
			<button class="btn btn-primary">회원탈퇴</button>
			<a href="javascript:history.back();" class="btn btn-secondary mx-1">돌아가기</a>
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>