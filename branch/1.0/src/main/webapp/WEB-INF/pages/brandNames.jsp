<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="brandName.heading" /></h1>


<c:set var="button">
	<input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/brandNameform.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:if test="hasPermission">
	<c:out value="${button }" escapeXml="false" />
</c:if>
<display:table name="list" id="list" pagesize="25" class="table" requestURI="brandNameform.html">
        <display:column property="id" titleKey="lookup.id" />
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
		<display:column property="description" titleKey="brandName.description" sortable="false" />
</display:table>

<c:if test="hasPermission">
	<c:out value="${button }" escapeXml="false" />
</c:if>
