<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center">
	<div class="mt-2">
		<%-- 썸네일 --%>
		<div>
		  	<%-- input file을 d-none으로 숨겨둠 --%>
			<input type="file" id="file" class="d-none"  accept=".jpg,.jpeg,.png,.gif">
			<a href="#" id="fileUploadBtn"><img src="/static/images/ImgUploadIcon.png" alt="이미지파일업로드아이콘" width="350" height="250"></a>
		</div>
		<%-- 제목 --%>
		<div class="mt-2">
			<input type="text" id="subjectInput" name="subject" class="form-control" placeholder="발행물 이름">
		</div>
		<%-- 카테고리 --%>
		<div class="mt-2">
			<select name="editionType" class="form-control">
				<option value="cartoon">만화</option>
				<option value="crafts">공예</option>
				<option value="art">예술</option>
				<option value="food">푸드</option>
				<option value="music">음악</option>
				<option value="publishing">출판</option>
				<option value="tech">테크</option>
				<option value="journalism">저널리즘</option>
				<option value="game">게임</option>
				<option value="movie">영화</option>
				<option value="photo">사진</option>
				<option value="fashion">패션</option>
			</select>
		</div>	
		<%-- 발행일자 --%>
		<div class="d-flex mt-2 align-items-center">
			<span>발행일자 매월</span><input type="text" id="publishDateInput" name="date" class="form-control col-5 ml-4" placeholder="                일">
		</div>
		<%-- 발행물소개 --%>
		<textarea class="form-control mt-2" cols="20" rows="15" ></textarea>
		<%-- 발행물 등록 버튼 --%>
		<div class="d-flex justify-content-center mt-3">
				<a id="createBtn" class="btn btn-dark w-100">등록하기</a>
		</div>
	</div>	
</div>