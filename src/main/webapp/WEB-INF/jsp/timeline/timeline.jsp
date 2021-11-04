<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<%-- (전체 발행물) edition 가져오기 --%>
<c:if test="${empty searchEditionList}">
	<c:forEach var="edition" items="${editionList}">
		<div id="editionFrame">
			<div id="edtioncard" class="m-3">
				<%-- edition thumbnail 가져오기 -> 클릭 시 디테일로 넘어감 --%>
				<a href="/edition/detail_view?editionId=${edition.id}&userId=${edition.userId}"><img src="${edition.thumbnailPath}" alt="editionThumbnail" width="250" height="250"></a>
			</div>
		</div>
	</c:forEach>
</c:if>	
<%-- (검색 발행물) edition 가져오기 --%>
<c:if test="${not empty searchEditionList}">
	<div>
		${keyword}로 검색하신 결과입니다.
	</div>	
	<c:forEach var="searchEdition" items="${searchEditionList}">
		<div>
			<a href="/edition/detail_view?editionId=${searchEdition.id}&userId=${searchEdition.userId}"><img src="${searchEdition.thumbnailPath}" alt="searchEditionThumbnail" width="250" height="250"></a>
		</div>
	</c:forEach>
</c:if>
</div>