<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<div>
	<div class="d-flex justify-content-around align-items-center mt-3">
		<%-- 검색창 --%>
		<div class="input-group col-4">
			<input type="text" id="keywordInput" name="keyword"  class="form-control" placeholder="검색어를 입력하세요.">
			<button id="searchBtn" type="button" class="input-group-btn btn-dark">검색</button>
		</div>
		<%-- 로고 --%>
		<div class="col-4">
			<div class="text-center">
				<a id="timelineLogo" href="/timeline/view">pmq</a><br>
				<span>The month between people</span>
			</div>
		</div>
		<%-- sign in / uSser 정보 --%>
		<div class="col-4 d-flex justify-content-center align-items-center">
			<%-- 로그인 시 --%>
			<c:if test="${not empty userId}">
				<div>
					<span>${userNickname}님 안녕하세요.</span><br>
					<%-- userRole 검사 -> publiser만 보이게 --%>
					<a href="/edition/create_view" id="editionCreateBtn" class="btn btn-dark w-100">발행시작</a>
				</div>
			</c:if>
			<%-- 비로그인 시 --%>
			<c:if test="${empty userId}">
				<div>
					<a href="/user/sign_in_view" id="signInUpUrl">로그인/회원가입</a>
				</div>
			</c:if>
		</div>
	</div>
</div>	