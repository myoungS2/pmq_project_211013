<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<div>
	<%-- user info --%>
	<div class="d-flex justify-content-around">
		<%-- user profile img --%>
		<div>
			<%-- 프로필 사진이 없을 때 --%>
			<c:if test="${empty userInfo.profileImgPath}">
				<div><img src="/static/images/profileIcon.png" alt="프로필아이콘" width="80" height="80"></div>
			</c:if>
			<%-- 프로필 사진이 있을 때 --%>
			<c:if test="${not empty userInfo.profileImgPath}">
				<div><img src="${userInfo.profileImgPath}" alt="userProfileImg"></div>
			</c:if>
		</div>
		<div>
			<%-- user nickname --%>
			<div>
				<strong>${userInfo.nickname}</strong>
			</div>
			<%-- user website --%>
			<div>
				<a>${userInfo.website}</a>
			</div>
			<%-- user introduction --%>
			<div>
				${userInfo.introduce}
			</div>
			<%-- update profile btn(화면이동) --%>
			<div>
				<a href="/user/profile_update_view" id="updateProfileBtn" class="btn btn-dark w-100">프로필 수정</a>
			</div>
		</div>
	</div>	
	<%-- edition list --%>
	<div>
		<small><strong>발행물 리스트</strong></small>
	</div>
	<c:forEach var="edition" items="${editionList}">
	<div>
		<img src="${edition.thumbnailPath}" alt="발행물썸네일"  width="150" height="200"> 
	</div>
	</c:forEach>
</div>