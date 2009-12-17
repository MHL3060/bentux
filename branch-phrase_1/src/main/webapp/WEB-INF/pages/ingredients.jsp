<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="ingredient.heading" /></h1>


<c:set var="button">
	<input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/ingredientform.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:if test="hasPermission">
	<c:out value="${button }" escapeXml="false" />
</c:if>
<display:table name="list" id="list" pagesize="25" class="table" requestURI="ingredientform.html">
        <display:column property="id" titleKey="lookup.id" />
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
		<display:column property="description" titleKey="ingredient.description" sortable="false" />
		<display:column titleKey="ingredient.view.product">
			<c:url var="url" value="/productlist.html">
				<c:param name="ingredientId" value="${list.id}" />
			</c:url>
			<a href="${url }"><fmt:message key="ingredient.view.product" /></a>
		</display:column>
</display:table>

<c:if test="hasPermission">
	<c:out value="${button }" escapeXml="false" />
</c:if>
