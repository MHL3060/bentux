<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="catalog.heading" /></h1>

<display:table name="tuxBaseObjectList" id="tuxBaseObjectList" pagesize="25" class="table" requestURI="catalogform.html">
        <display:column property="id" titleKey="lookup.id" />
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
		<display:column property="description" titleKey="catalog.description" sortable="false" />
		<display:column titleKey="catalog.view.product">
			<c:url var="url" value="/productlist.html">
				<c:param name="catalogId" value="${list.id}" />
			</c:url>
			<a href="${url }"><fmt:message key="catalog.view.product" /></a>
		</display:column>
</display:table>