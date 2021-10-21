<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<%-- edition subject --%>
	<div>
		${editionInfo.subject}
	</div>
	<%-- 수정/삭제 버튼 , publisher 프로필사진 + nickname --%>
	<div>
		<div>
			<a href="#" type="button" class="btn">삭제</a>
			<a href="#" type="button" class="btn">수정</a>
		</div>
		<div>
			<div><img src="${userInfo.profileImgPath}" alt="userProfileImg"></div>
			<div><span>by ${userNickname}</span></div>
		</div>
	</div>
	<%-- 좋아요 수 (발행인은 클릭x) --%>
	<%-- full heart img --%>
	
	<%-- edition thumbnail --%>
	
	<%-- edition content --%>
	
	<%-- subscriber list --%>
	<%-- excel 다운받기 버튼 --%>
	<%-- subscriber 프로필사진 + nickname (클릭시 userProfile 화면이동) --%>
	
	<%-- publication list --%>
	<%-- publication create 버튼(클릭시 publication create 화면이동) --%>
	<%-- publication subject + state (상태가 임시저장의 경우 클릭가능 -> publication update 화면이동 --%>
</div>