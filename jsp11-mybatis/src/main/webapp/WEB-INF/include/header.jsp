<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/bootstrap.bundle.min.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/font_bootstrap-icons.css">
<link rel="stylesheet" href="../css/layout.css">

<script src="../js/jquery.js"></script>
<script	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<header class="p-3 mb-3 border-bottom">
	<!-- <img src="../icons/arrow-down.svg">
	<i class="bi-arrows-collapse" style="color:#f00; font-size:100px;"></i> -->
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
          <i class="bi bi-emoji-laughing"></i>
        </a>
	<c:choose>
		<c:when test="${empty loggedID }">
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="../member/login" class="nav-link px-2 link-secondary">login</a></li>
          <li><a href="../member/insert" class="nav-link px-2 link-body-emphasis">sign in</a></li>
          <li><a href="../board/list" class="nav-link px-2 link-body-emphasis">board</a></li>
          
        </ul>
		</c:when>
		<c:otherwise>
        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="${pageContext.request.contextPath }/upload/${profile }" alt="mdo" width="64" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small">
            <li><a class="dropdown-item" href="#">New project...</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="../member/logout">Sign out</a></li>
          </ul>
          </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </header>
  <main class="main">
  
  
  
  
  
  
  
  