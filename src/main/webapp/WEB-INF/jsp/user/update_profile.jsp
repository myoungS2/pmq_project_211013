<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<%-- 프로필 사진 --%>
	<div class="d-flex justify-content-center">
		<div class="w-50">
			<%-- input file을 d-none으로 숨겨둠 --%>
			<input type="file" id="file" class="d-none" accept=".jpg,.jpeg,.png,.gif"> 
				<a href="#" id="fileUploadBtn">
					<img src="/static/images/profileIcon.png"alt="프로필아이콘">
				</a>
		</div>
	</div>
	<%-- 닉네임 / 중복확인 --%>
	<div class="d-flex">
		<input type="text" id="nicknameInput" name="nickname" class="form-control mt-3 col-8" value="${userInfo.nickname}"> 
		<a id="nicknameCheckHref" type="button" class="btn mt-3 ml-3 col-4"><small>중복확인</small></a>
	</div>
	<%-- 중복확인 메세지 --%>
	<div>
		<span id="nicknameCheckDuplicated" class="small text-danger d-none">사용중인 닉네임입니다.</span> 
		<span id="nicknameCheckOk" class="small text-success d-none">사용가능한 닉네임입니다.</span>
	</div>
	<%-- 이메일 --%>
	<div class="d-flex">
		<input type="text" id="emailInput" name="email" class="form-control mt-3" value="${userInfo.email}">
	</div>
	<%-- 주소 --%>
	<div class="d-flex">
		<input type="text" id="addressInput" name="address" class="form-control mt-3" value="${userInfo.address}">
	</div>
	<%-- 웹사이트 --%>
	<div class="d-flex">
		<input type="text" id="websiteInput" name="website" class="form-control mt-3" value="${userInfo.website}">
	</div>
	<%-- 자기소개 --%>
	<div class="d-flex">
		<input type="text" id="introduceInput" name="introduce" class="form-control mt-3" value="${userInfo.introduce}">
	</div>

	<%-- alter profile btn --%>
	<div class="d-flex justify-content-center mt-3">
		<a id="updateProfileBtn" class="btn btn-dark w-100">프로필수정</a>
	</div>

	<%-- sign out btn --%>
	<div class="d-flex justify-content-center mt-3">
		<a id="signOutBtn" class="btn btn-dark w-100">로그아웃</a>
	</div>
</div>