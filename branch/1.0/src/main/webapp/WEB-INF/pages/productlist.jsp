<%@ include file="/common/taglibs.jsp" %>

<c:set var="button">
	<input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/productform.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>

<display:table id="tuxBaseObjectList" name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table uutResultList" export="true" >
	<c:if test="${hasPermission }">
		<display:column titleKey="id" property="id" url="/productform.html" paramName="id" 
			paramProperty="id" />
	</c:if>
	<display:column titleKey="product.image">
		<img src="<c:url value="${tuxBaseObjectList.firstImage.thumbPath}"  />" title="<fmt:message key="click.enlarge" />" />
	</display:column>
	<display:column property="name" titleKey="product.name" sortable="true" />
	<display:column property="description" titleKey="product.description" maxWords="50" />
	<display:column titleKey="more.info" >
		<c:url var="url" value="/productdetail.html">
			<c:param name="id"  value="${tuxBaseObjectList.id}" />
		</c:url>
		<a href="${url }" >more info..</a>
	</display:column>
</display:table>

<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>