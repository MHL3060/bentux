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
		<display:column titleKey="id" property="id" url="/productform.html" paramId="id" 
			paramProperty="id" />
	</c:if>
	<display:column titleKey="product.image">
		<img src="<c:url value="${tuxBaseObjectList.firstImage.thumbPath}"  />" title="<fmt:message key="click.enlarge" />" />
	</display:column>
	<display:column property="brandName.name" titleKey="product.brandName.name" sortable="true" />
	<display:column property="name" titleKey="product.name" sortable="true" />
	<display:column property="description" titleKey="product.description" maxWords="50" />
	<display:column property="availability" titleKey="product.availability" />
	<c:if test="${hasPermission }">
		<display:column titleKey="product.add.image">
			<c:url var="imageUrl" value="/imageform.html">
				<c:param name="pid" value="${tuxBaseObjectList.id }" />
			</c:url>
			<a href="<c:url value="${imageUrl}" />" /><fmt:message key="add.image" /></a>
		</display:column>
	</c:if>
	<display:column titleKey="more.info" >
		<c:url var="url" value="/productdetail.html">
			<c:param name="id"  value="${tuxBaseObjectList.id}" />
		</c:url>
		<a href="${url }" ><fmt:message key="more.info" /></a>
	</display:column>
	<c:if test="${hasPermission && tuxBaseObject.availability > 0 }">
		<display:column titleKey="add.cart">
			<c:url var="url" value="/additem.html">
				<c:param name="pid" value="${tuxBaseObjectList.id }" />
			</c:url>
			<a href="${url }"><fmt:message key="add.to.cart" /></a>
		</display:column>
	
	</c:if>
	
</display:table>

<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>