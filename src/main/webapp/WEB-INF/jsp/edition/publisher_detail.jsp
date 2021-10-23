<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<div id="editionDetailDiv" class="d-flex justify-content-center">
	<div>
		<%-- edition subject --%>
		<div class="text-center mb-3">
			<h1>${editionInfo.subject}</h1>
		</div>
		<%-- 수정/삭제 버튼 , publisher 프로필사진 + nickname, 좋아요 --%>
		<div class="d-flex justify-content-between align-items-center">
			<%-- edition alter, delete --%>
			<div>
				<div class="mt-3">
					<a href="#" id="editionAltBtn" type="button" class="btn btn-dark">수정</a>
				</div>
				<div class="mt-3">
					<a href="#" id="editionDelBtn" type="button" class="btn btn-dark">삭제</a>
				</div>
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
			<%-- 좋아요 --%>
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
		<%-- subscriber list --%>
		<div class="d-flex justify-content-around mt-3">
			<div>
				<small class="font-weight-bold">구독자 리스트</small>
			</div>
			<div>
				<a href="#" id="excelDownloadBtn" type="button" class="btn btn-dark">Excel</a>
			</div>
		</div>
		<%-- subscriber 프로필사진 + nickname (클릭시 userProfile 화면이동) --%>
		<div>
			Subscribers List
		</div>
		<%-- publication list --%>
		<div class="d-flex justify-content-around mt-3">
			<div>
				<small class="font-weight-bold">발행글 리스트</small>
			</div>
			<%-- publication create 버튼(클릭시 publication create 화면이동) --%>
			<div>
				<a href="#" id="createPublicationBtn" type="button" class="btn btn-dark">Excel</a>
			</div>
		</div>
		<%-- publication subject + state (상태가 임시저장의 경우 클릭가능 -> publication update 화면이동 --%>
		<div>
			Publication List
		</div>
	</div>
</div>