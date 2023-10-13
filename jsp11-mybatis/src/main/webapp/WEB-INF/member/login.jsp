<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="form-signin w-100 m-auto">
  <form action="../member/login-process" method="post" >
    
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="userID" placeholder="userID" name="userID" 
      value="${cookie.saveIDCookie.value}"> 
      <label for="userID">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="userPW" placeholder="Password" name="userPW">
      <label for="userPW">패스워드</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="rememberMe" id="flexCheckDefault" name="saveID"
      	<c:if test="${not empty cookie.saveIDCookie }">checked</c:if>>
      <label class="form-check-label" for="flexCheckDefault">
        로그인 유지
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
    
    <!--  <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>-->
  </form>
  <div>
  <a href="../member/insert.jsp" class="nav-link"><button class="btn btn-primary w-100 pu-2 mt-3" type="submit">회원가입</button></a>
  </div>
</div>

<%@ include file="../include/footer.jsp"%>