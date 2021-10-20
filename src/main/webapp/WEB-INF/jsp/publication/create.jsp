<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 발행물 임시저장 버튼 -> 이미 저장 된 글을 클릭해서 수정하러 왔다면, 값이 input에 들어있어야 함 --%>
<div class=" d-flex justify-content-center">
	<div>
		<%-- 발행물 제목 --%>
		<div class="mt-2">
			<input type="text" id="subjectInput" name="subject" class="form-control" placeholder="금월 발행물 제목">
		</div>
		<%-- 발행물 내용 --%>
		<textarea class="form-control mt-2" id="editionIntroduceInput" cols="50" rows="20" placeholder="내용을 입력하세요."></textarea>
		<div class="d-flex justify-content-center mt-3">
				<a id="draftBtn" class="btn btn-dark w-100">임시저장</a>
		</div>
		<%-- 발행 버튼 --%>
		<div class="d-flex justify-content-center mt-3">
				<a id="sendOutBtn" class="btn btn-dark w-100">발행</a>
		</div>
	</div>	
</div>
