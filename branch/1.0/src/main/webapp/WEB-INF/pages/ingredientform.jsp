<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="ingredient.heading" /></h1>

<display:table name="list" id="list" pagesize="25" class="table" requestURI="ingredientform.html">
	<display:column property="id" titleKey="lookup.id" />
	<display:column property="name" titleKey="lookup.name" sortable="true"/>

</display:table>

<c:set var="buttons">
    <input type="submit" style="margin-right: 5px"
        
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/products.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>


<form:form commandName="ingredient" method="post" action="ingredientform.html" onsubmit="return onFormSubmit(this)" id="catalogForm">
	<form:hidden path="id"/>
	<ul>
		<li>
			<appfuse:label key="ingredient.name" styleClass="desc" />
			<form:errors path="name" cssClass="fieldError"/>
			<form:input path="name" cssStyle="text medium"/>
		</li>
	</ul>
	
	<c:out value="${buttons}" escapeXml="false" />
	
</form:form>