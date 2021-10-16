<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원가입 --%>

<%-- input --%>
<div>
	<%-- 프로필 사진 --%>
	<div class="d-flex justify-content-center">
		<div class="w-50">
			<%-- input file을 d-none으로 숨겨둠 --%>
			<input type="file" id="file" class="d-none"  accept=".jpg,.jpeg,.png,.gif">
			<a href="#" id="fileUploadBtn"><img src="/static/images/profileIcon.png" alt="프로필아이콘" ></a>
		</div>
	</div>
	<%-- 아이디/ 중복확인 --%>
	<div class="d-flex">
		<input type="text" id="loginIdInput" name="loginId" class="form-control mt-3 col-8" placeholder="ID"> 
		<a id="idCheckHref" type="button" class="mt-3 ml-3 col-4"><small>중복확인</small></a>
	</div>
	<%-- 중복확인 메세지 --%>
	<div>
		<span id="idCheckDuplicated" class="small text-danger d-none">사용중인 아이디입니다.</span>
		<span id="idCheckOk" class="small text-success d-none">사용가능한 아이디입니다.</span>
	</div>
	<%-- 비밀번호 --%>
	<div>
		<input type="password" id="passwordInput" name="password" class="form-control mt-3" placeholder="PASSWORD">
	</div>
	<%-- 비밀번호확인 --%>
	<div>
		<input type="password" id="confirmPassword" name="confirmPassword" class="form-control mt-3" placeholder="CONFIRM PASSWORD">
	</div>
	<%-- 비밀번호확인 메세지(일치하지 않을때만) --%>
	<div id="pwCheck" class="small text-danger d-none">비밀번호가 일치하지 않습니다.</div>
	<%-- 이름 --%>
	
	<%-- 닉네임 / 중복확인 --%>
	<div class="d-flex">
		<input type="text" id="nicknameInput" name="nickname" class="form-control mt-3 col-8" placeholder="NICKNAME"> 
		<a id="nicknameCheckHref" type="button" class="mt-3 ml-3 col-4"><small>중복확인</small></a>
	</div>
	<%-- 중복확인 메세지 --%>
	<div>
		<span id="nicknameCheckDuplicated" class="small text-danger d-none">사용중인 닉네임입니다.</span>
		<span id="nicknameCheckOk" class="small text-success d-none">사용가능한 닉네임입니다.</span>
	</div>
	<%-- 이메일 --%>
	<div class="d-flex">
		<input type="text" id="emailInput" name="email" class="form-control mt-3" placeholder="E-MAIL"> 
	</div>
	<%-- 주소 --%>
	<div class="d-flex">
		<input type="text" id="addressInput" name="address" class="form-control mt-3" placeholder="ADDRESS"> 
	</div>
	<%-- 웹사이트 --%>
	<div class="d-flex">
		<input type="text" id="websiteInput" name="website" class="form-control mt-3" placeholder="WEBSITE"> 
	</div>
	<%-- 자기소개 --%>
	<div class="d-flex">
		<input type="text" id="introduceInput" name="introduce" class="form-control mt-3" placeholder="INTRODUCTION"> 
	</div>
	<%-- role(구독자/발행인) --%>
	<div class="d-flex justify-content-around mt-3">
		<div><input type="radio" name="subscriber" value="subscriber">구독자</div>
		<div><input type="radio" name="publisher" value="publisher">발행인</div>
	</div>
</div>
<%-- sign up btn --%>
<div class="d-flex justify-content-center mt-3">
	<a type="submit" id="signupBtn" class="btn btn-dark w-100">sign up</a>
</div>