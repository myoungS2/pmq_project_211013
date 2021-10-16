<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 --%>

<%-- input --%>
<div>
	<input type="text" id="loginIdInput" name="loginId"
		class="form-control mt-3 w-100" placeholder="ID"> <input
		type="password" id="passwordInput" name="password"
		class="form-control mt-3 w-100" placeholder="PASSWORD">
</div>

<%-- sign in btn --%>
<div class="d-flex justify-content-center mt-3">
	<a type="submit" id="signinBtn" class="btn btn-dark w-100">sign in</a>
</div>

<%-- sign up link --%>
<div class="d-flex justify-content-center mt-3">
	<a id="signupLink" type="button" href="/user/sign_up_view">sign up</a>
</div>