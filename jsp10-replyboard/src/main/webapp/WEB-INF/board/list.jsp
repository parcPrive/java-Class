<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="mb-5 mt-5">write</h2>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">title</th>
				<th scope="col">writer</th>
				<th scope="col">date</th>
				<th scope="col">hit</th>
				<th scope="col">regroup</th>
				<th scope="col">relevel</th>
				<th scope="col">restep</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="board" varStatus="status"
				begin="0">
				<tr>
					<td>${status.index + 1}</td>
					<td>
					<c:choose>
						<c:when test="${board.available > 0}">
							<c:choose>
								<c:when test="${board.restep > 1 }">
								<a href="../board/view?no=${board.no}" class="step step${board.restep}">
								<c:forEach begin="1" end="${board.restep}">
									[re]
								</c:forEach>
									${board.title }</a>
								</c:when>
							<c:otherwise>
							<a href="../board/view?no=${board.no}">${board.title }
							</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${board.restep > 1 }">
								<span class="step step${board.restep}">
								<c:forEach begin="1" end="${board.restep}">
									[re]
								</c:forEach>
									삭제된 글입니다.</span>
								</c:when>
							<c:otherwise>
							<span>삭제된 글입니다.
							</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</td>
					<td>${board.name }</td>
					<td>${board.regDate }</td>
					<td>${board.hit }</td>
					<td>${board.regroup}</td>
					<td>${board.relevel }</td>
					<td>${board.restep }</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-center mt-3 mb-3">
		<a href="../board/write" class="btn btn-primary">글쓰기</a>
	</div>


</div>
<%@ include file="../include/footer.jsp"%>



