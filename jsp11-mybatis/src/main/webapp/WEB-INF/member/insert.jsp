<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	
	<div class="container">
		<form action="../member/insert-process" method="post" class="" id="joinForm" name="member" enctype="multipart/form-data">
			<div class="row d-flex justify-content-center mt-5">
				<div class="col-6">
					<div class="mb-3">
						<div class="row">
							<div class="col-6">
								<label for="userID" class="form-label">ID</label> 
								<input type="text" class="form-control" id="userID"
								placeholder="user id" name="userID" />
							</div>
							<div class="col-6  mt-3 d-flex align-items-baseline px-0">
								<button class="btn btn-primary mt-3" id="btnIDCheck">아이디 중복 확인</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="userPW" class="form-label">password</label> <input
							type="password" class="form-control" id="userPW"
							placeholder="user password" name="userPW" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="userPW02" class="form-label">password Confirm</label>
						<input type="password" class="form-control" id="userPW02"
							placeholder="user password" />
						<div class="invalid-feedback">글자 써보기</div>
					</div>
				</div>
			</div>

			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="userName" class="form-label">Name</label> <input
							type="text" class="form-control" id="userName"
							placeholder="user name" name="userName" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="email" class="form-label">email</label> <input
							type="email" class="form-control" id="email"
							placeholder="user name" name="email" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="tel" class="form-label">HP</label> <input
							type="text" class="form-control" id="tel"
							placeholder="user name" name="tel" />
					</div>
				</div>
			</div>
			
			
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<div class="row">
							<div class="col-6">
								<label for="postCode" class="form-label">ZipCode</label> <input
									type="text" class="form-control" id="postCode"
									placeholder="post code" name="postCode" />
							</div>
							<div class="col-6 mt-3 align-items-baseline px-0">
								<button class="btn btn-primary mt-3" id="btnPostcode">우편번호
									확인</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="address" class="form-label">Address</label> <input
							type="text" class="form-control" id="address" name="address"
							placeholder="address" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="detailAddress" class="form-label">Detail
							Address</label> <input type="text" class="form-control"
							id="detailAddress" placeholder="detail address"
							name="detailAddress" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="detailAddress" class="form-label">profile</label> 
						<input type="file" class="form-control"
							id="profile" placeholder="png,jpg" name="profile" accept="image/gif, image/jpeg, image/png" />
					</div>
				</div>
			</div>
			
			<div class="mt-5 mb-5 d-flex justify-content-center">
				<div class="">
					<button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
					<button type="submit" class="btn btn-primary" id="btnSubmitAjax">Ajax회원가입</button>
					<button type="reset" class="btn btn-secondary">취소</button>
				</div>
			</div>
		</form>
	</div>

	<script>
		let isIDCheck=false;
		function postcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					const roadAddr = data.roadAddress; // 도로명 주소 변수
					const extraRoadAddr = ""; // 참고 항목 변수

					document.querySelector("#postCode").value = data.zonecode;
					document.querySelector("#address").value = roadAddr;
					
				},
			}).open();
		}

		$("#btnPostcode").on("click", function() {
			postcode();
			return false;
		});
		
		/*
		$("#btnSubmit").on("click", function(e) {
			if ($("#userID").val().trim() === "") {
				alert("id는 필수입력 사항입니다.");
				$("#userID").val("");
				$("#userID").focus();
				return false;
			} else if ($("#userPW").val().trim() === "") {
				alert("password는 필수입력 사항입니다.");
				$("#userPW").val("");
				$("#userPW").focus();
				return false;
			} else if ($("#userPW02").val().trim() === "") {
				alert("password 확인");
				$("#userPW02").val("");
				$("#userPW02").focus();
				return false;
			} else if(!isIDCheck) {
				alert("아이디 중복 체크를 해주세요.");
				return false;
			}
		});
		*/
		$("#userPW02").on("keyup", function() {
			if ($("#userPW").val() !== $("#userPW02").val()) {
				$(".invalid-feedback").show();
				$(".invalid-feedback").text("password가 맞지 않습니다.");
			} else {
				$(".invalid-feedback").hide();
				$(".invalid-feedback").text("");
			}
		});
		
		$("#btnSubmitAjax").on("click",function(){
			$.ajax({
				url:"../member/insert-member-ajax-process.jsp",
				data:$("#joinForm").serialize(),
				success:function(response) {
					if(response.isMemberInsert==="success") {
						alert("회원가입 되었습니다.");
						location.href="../index/index.jsp";
					} else {
						alert("서버 오류입니다.");
						history.back();
					}
				}
			});
		})
		
		/*
		$("#btnIDCheck").on("click", function() {
			$.ajax({
				url : "../member/id-check",
				data : {
					userID : $("#userID").val(),
				},
				//method: "get",
				success : function(data) {
					//console.log("success");
					//console.log(data);
					if(data.count>0) {
						alert("쓸 수 없는 아이디입니다.");
						$("#userID").val("");
					} else {
						const useID = confirm("쓸 수 있는 아이디 입니다. 사용하시겠어요?");
						if(useID) {
							$("#userID").attr("readonly", true);
							isIDCheck=true;
						}
					}
				},
				fail : function(error) {
					console.log(error);
				},
				complete : function(data) {
					console.log("complete");
					console.log(data);
				}
			});
			return false;
		});
		*/
		 // 2. 아이디 중복체크
		   //let isIDCheck = false; // 아이디중복을 확인했는지 체크하는 전역변수
		   $('#btnIDCheck').on('click', function(){
		       $.ajax({
		          url:"../member/id-check",
		          data: {
		             userID: $("#userID").val()
		          },
		          method: "get",  //없어도 get으로 처리됨
		          
		          success: function(data){
		             if(data.count>0){
		                alert("쓸 수 없는 아이디");
		                $("#userID").val("");
		                $("#userID").focus();
		             }else{
		                const useID = confirm("쓸 수 있는 아이디. 사용하시겠어요?");
		                if(useID) $("#userID").attr("readonly", true);
		                isIDCheck = true;
		             }
		          },
		          fail:function(error){
		             console.log(error);
		          },
		          
		          complete:function(data){
		             
		          }
		       });
		       
		       return false;
		    });
		   
		// 이미지 미리보기  
  		   $("#profile").on("change",function(e){
				const file = e.target.files[0];
				console.log(e.target.files);
				console.log(file.name);
				const ext = file.name.substring(file.name.lastIndexOf(".")+1);
				console.log(ext);
				if(!(ext==="png" || ext==="jpg" || ext==="gif")) {
					alert("png,jpg,gif만 쓸 수 있습니다.");
					$("#profile").val("");
					return false;
				} else {
					const reader = new FileReader();
					reader.onload = function(e) {
						$(".preview").html(`<img src="\${e.target.result}">`);
					}
					reader.readAsDataURL(file);
				}
		   });

	</script>
<%@ include file="../include/footer.jsp" %>