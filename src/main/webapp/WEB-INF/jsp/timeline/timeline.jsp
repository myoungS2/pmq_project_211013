<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- edition 가져오기 --%>
<c:forEach var="edition" items="${editionList}">
	<div id="editionFrame">
		<div id="edtioncard" class="m-3">
			<%-- edition thumbnail 가져오기 -> 클릭 시 디테일로 넘어감 --%>
			<a><img src="${edition.thumbnailPath}" alt="editionThumbnail" width="250" height="250"></a>
		</div>
	</div>
</c:forEach>