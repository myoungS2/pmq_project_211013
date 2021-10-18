<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-between align-items-center">
	<%-- 로고 --%>
	<div>
		<a id="gnbLogo" href="/timeline/view">pmq</a><br>
	</div>
	<%-- sign in / user 정보 --%>
	<div>
		<c:if test="${not empty userId}">
			<a href="/user/profile_{userRole}_view">${userNickname}</a><span>님 안녕하세요.</span>
		</c:if>
		<a href="/user/sign_in_view" id="signInUpUrl">로그인/회원가입</a>
	</div>
</div>