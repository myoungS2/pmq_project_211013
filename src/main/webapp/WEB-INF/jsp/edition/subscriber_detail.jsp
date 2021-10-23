<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<div id="editionDetailDiv" class="d-flex justify-content-center">
	<div>
		<%-- edition subject --%>
		<div class="text-center ml-4 mb-3">
			<h1>${editionInfo.subject}</h1>
		</div>
		<%-- 수정/삭제 버튼 , publisher 프로필사진 + nickname, 좋아요 --%>
		<div class="d-flex justify-content-between align-items-center mr-3">
			<%-- 구독신청버튼/ 구독취소버튼(신청이 기존에 되었을 때 노출) --%>
			<div>
				<a href="#" id="startSubscribeBtn" type="button" class="btn btn-dark">구독시작</a>
				<a href="#" id="cancelSubscribeBtn" type="button" class="btn btn-dark d-none">구독취소</a>
			</div>
			<%-- publisher info --%>
			<div class="text-center">
				<%-- 프로필 사진이 없을 때 --%>
				<c:if test="${empty publisherInfo.profileImgPath}">
					<div><img src="/static/images/profileIcon.png" alt="프로필아이콘" width="80" height="80"></div>
				</c:if>
				<%-- 프로필 사진이 있을 때 --%>
				<c:if test="${not empty publisherInfo.profileImgPath}">
					<div><img src="${publisherInfo.profileImgPath}" alt="userProfileImg"></div>
				</c:if>
				<div><span class="font-weight-bold">by ${publisherInfo.nickname}</span></div>
			</div>
			<%-- 좋아요(토글) --%>
			<div class="text-center">
				<%-- 좋아요 수 (발행인은 클릭x) --%>
				<div><small>123</small></div>
				<%-- full heart img --%>
				<div><img src="/static/images/fullHeartIcon.png" alt="fullheart" width="30" height="30"></div>
			</div>
		</div>
		<%-- edition thumbnail --%>
		<div class="mt-3">
			<img src="${editionInfo.thumbnailPath}" alt="editionTumbnailImg" width="390" height="400">
		</div>
		<%-- edition content --%>
		<div class="mt-3">
			${editionInfo.content}
		</div>
	</div>
</div>