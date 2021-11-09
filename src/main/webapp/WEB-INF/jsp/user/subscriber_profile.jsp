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
				<div><img id="profileImg" src="${userInfo.profileImgPath}" alt="userProfileImg" width="80" height="80"></div>
			</c:if>
		</div>
		<div>
			<%-- user nickname --%>
			<div>
				<strong>${userInfo.nickname}</strong>
			</div>
			<%-- user website --%>
			<div>
				<a href="${userInfo.website}">${userInfo.website}</a>
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
	<%-- subscribe list --%>
	<div>
		<small><strong>구독 리스트</strong></small>
	</div>
	<div class="d-flex justify-content-around">
		<%-- <c:forEach var="subscribeEditionList" items="${subscribeEditionList}">
		<div>
			<a><img src="${subscribeEditionList.thumbnailPath}" alt="구독썸네일" width="150" height="200"></a>
		</div>
		</c:forEach> --%>
		<c:forEach var="interestView" items="${interestViewList}">
			<div>
				<a><img src="${interestView.edition.thumbnailPath}" alt="구독썸네일" width="150" height="200"></a>
			</div>
		</c:forEach>
	</div>
	<%-- like list --%>
	<div>
		<small><strong>관심 리스트</strong></small>
	</div>
	<div class="d-flex justify-content-around">
		<c:forEach var="likeEditionList" items="${likeEditionList}">
		<div>
			<a><img src="${likeEditionList.thumbnailPath}" alt="관심썸네일" width="150" height="200"></a>
		</div>
		</c:forEach>
	</div>
</div>