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
			<%-- edition alter, delete btns --%>
			<div>
				<div class="mt-3">
					<a href="/edition/update_view?editionId=${editionInfo.id}&userId=${editionInfo.userId}" id="editionAltBtn" type="button" class="btn btn-dark">수정</a>
				</div>
				<div class="mt-3">
					<a href="#" id="editionDelBtn" type="button" class="btn btn-dark" data-edition-id="${editionInfo.id}">삭제</a>
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
				<div><small>${likeCount}</small></div>
				<%-- full heart img --%>
				<div>
					<c:if test="${likeCount < 0}">
						<img src="/static/images/emptyHeartIcon.png" alt="emptyheart" width="30" height="30">
					</c:if>
					<%-- full heart img (좋아요o) --%>
					<c:if test="${likeCount >= 1}">
						<img src="/static/images/fullHeartIcon.png" alt="fullheart" width="30" height="30">
					</c:if>
				</div>
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
		<c:forEach var="subscriber" items="${subscriberList}">
			<div class="d-flex justify-content-around mt-3">
				<div><strong>${subscriber.userLoginId}</strong></div>
				<%-- 날짜 형식 고치기! --%>
				<div>${subscriber.createdAt}</div>
			</div>
		</c:forEach>
		<%-- publication list --%>
		<div class="d-flex justify-content-around mt-3">
			<div>
				<small class="font-weight-bold">발행글 리스트</small>
			</div>
			<%-- publication create 버튼(클릭시 publication create 화면이동) --%>
			<div>
				<a href="/publication/create_view" id="createPublicationBtn" type="button" class="btn btn-dark">글쓰기</a>
			</div>
		</div>
		<%-- publication subject + state (상태가 임시저장의 경우 클릭가능 -> publication update 화면이동 --%>
		<div>
			Publication List
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		
		// 삭제
		$('#editionDelBtn').on('click', function(e){
			e.preventDefault(); 
			
			
			// 어떤 edition을 삭제하는지에 대한 정보
			let editionId = $(this).data('edition-id');
			// alert(editionId); 
			
			// 서버에 요청
			$.ajax({
				type: 'delete'
				, url: '/edition/delete'
				, data: {'editionId': editionId}
				, success: function(data){
					if(data.result == 'success'){
						// 삭제 후 timeline 이동
						alert("발행물 삭제가 완료되었습니다.");
						location.href= '/timeline/view';
					}
				}
				, error: function(e){
					
				}
				
			}); // edition delete ajax close
			
			
		}); // editionDelBtn close
		
		
		
	}); // document close

</script>
