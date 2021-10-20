<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- edition 가져오기 --%>
<%-- <c:forEach items="${}"> --%>
	<div id="editionFrame" class="bg-primary">
		<div id="edtioncard" class="bg-danger m-3">
			edition thumbnail
			<%-- edition thumbnail 가져오기 -> 클릭 시 디테일로 넘어감 --%>
			<%-- <a href="/edition/detail/{editionId}">${edition.thumbnailPath}</a> --%>
		</div>
	</div>
<%-- </c:forEach> --%>