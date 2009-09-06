<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="catalog.heading" /></h1>
<display:table name="list" id="list" pagesize="25" class="table">

	<display:column property="id" titleKey="lookup.id" />
	<display:column property="name" titleKey="lookup.name" sortable="true"/>

</display:table>

<c:set var="buttons">
    <input type="submit" style="margin-right: 5px"
        
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/products.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>


<form:form commandName="catalog" method="post" action="catalogform.html" onsubmit="return onFormSubmit(this)" id="catalogForm">
	<form:hidden path="id"/>
	<ul>
		<li>
			<appfuse:label key="catalogy.name" styleClass="desc" />
			<form:errors path="name" cssClass="fieldError"/>
			<form:input path="name" cssStyle="text medium"/>
		</li>
	</ul>
	
	<c:out value="${buttons}" escapeXml="false" />
	
</form:form>