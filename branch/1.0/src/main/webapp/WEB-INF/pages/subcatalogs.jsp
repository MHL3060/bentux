<%@ include file="/common/taglibs.jsp" %>

<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>

<h1><fmt:message key="catalog.heading" /></h1>
<style>
div.section { clear: left; }
div.subcatalog { 
    float: left; 
	width: 6em; 
	padding: 40px; 
	margin: 1em;
	height: 6em;
    background: #ccc; 
    color:#000; 
    text-align: center; 
    font: verdana, arial, sans-serif;
}
div.center{
	float: left;
	padding-left: 2em;

}
</style>
<div id="whole" class="center">
<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
	<div class="subcatalog" id="subcatalog_${catalog.id}">
		<img alt="image holder" src="<c:url value="${catalog.image.thumbPath }" />" 
			onclick="new Effect.Puff('subcatalog_${catalog.id}'); 
				window.setTimeout('Effect.Appear(\'subcatalog_${catalog.id}\', {duration:.3})',4000); 
				document.location='<c:url value="/productlist.html?catalogId=${catalog.id}" />'"
		/>
		<a class="product" alt="click here to view all the products related to ${catalog.name }"
				onclick="new Effect.Puff('subcatalog_${catalog.id}'); 
				window.setTimeout('Effect.Appear(\'subcatalog_${catalog.id}\', {duration:.3})',4000); "
				href='<c:url value="/productlist.html?catalogId=${catalog.id}" />' > ${catalog.name}</a>
	</div>

</c:forEach>
</div>

<%--
<display:table name="tuxBaseObjectList" id="tuxBaseObjectList" pagesize="25" class="table" requestURI="catalogform.html">
        <display:column property="id" titleKey="lookup.id" />
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
		<display:column property="description" titleKey="catalog.description" sortable="false" />
		<display:column titleKey="catalog.view.product">
			<c:url var="url" value="/productlist.html">
				<c:param name="catalogId" value="${tuxBaseObjectList.id}" />
			</c:url>
			<a href="${url }"><fmt:message key="catalog.view.product" /></a>
		</display:column>
</display:table>

 --%>