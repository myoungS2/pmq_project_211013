<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  <%-- 요런애들은 페이지마다 있어야함 --%>      
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
		<%-- sign in / user 정보 --%>
		<div class="col-4">
			<c:if test="${not empty userId}">
				<a href="/user/profile_{userRole}_view">${userNickname}</a><span>님 안녕하세요.</span>
			</c:if>
			<a href="/user/sign_in_view" id="signInUpUrl">로그인/회원가입</a>
		</div>
	</div>
</div>	