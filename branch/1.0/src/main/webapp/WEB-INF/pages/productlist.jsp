<%@ include file="/common/taglibs.jsp" %>

<display:table id="tuxBaseObjectList" name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table uutResultList" export="true">

	<display:column titleKey="product.image">
		<img src="<c:url value="${tuxBaseObjectList.image.thumbNailPath }" />" />
	</display:column>
	<display:column property="name" titleKey="product.name" sortable="true" />
	<display:column property="description" titleKey="product.description" maxWords="50" />
	<display:column titleKey="more.info" >
		<c:url var="url" value="/productdetail.html">
			<c:param name="id"  value="${tuxBaseObjectList.id" />
		</c:url>
		<a href="${url }" >more info..</a>
	</display:column>
</display:table>