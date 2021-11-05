<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<div class=" d-flex justify-content-center">
	<div>
		<%-- 기존 임시저장 발행물 제목 --%>
		<div class="mt-2">
			<input type="text" id="subjectInput" name="subject" class="form-control" placeholder="금월 발행물 제목" value="${publication.subject}">
		</div>
		<%-- 기존 임시저장 발행물 내용 --%>
		<textarea class="form-control mt-2" id="contentInput" cols="50" rows="20" placeholder="내용을 입력하세요." >${publication.content}</textarea>
		<%-- 발행 버튼 --%>
		<div class="d-flex justify-content-center mt-3">
				<a id="sendOutBtn" class="btn btn-dark w-100">발행</a>
		</div>
	</div>	
</div>
<script>
	$(document).ready(function(){
		
		// 임시저장 글 발행
		
		
	}); // document close

</script>