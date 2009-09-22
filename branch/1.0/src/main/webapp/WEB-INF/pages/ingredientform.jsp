<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="ingredient.heading" /></h1>

<display:table name="list" id="list" pagesize="25" class="table" requestURI="ingredientform.html">
        <display:column property="id" titleKey="lookup.id" url="/ingredientform.html" paramId="id" paramProperty="id" />
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
		<display:column property="description" titleKey="lookup.description" />
		<display:column property="amountPerServing" titleKey="lookup.amountPerServing"/>
        <display:column property="percentage" titleKey="lookup.percentage"/>
</display:table>

<c:set var="id" value="${ingredient.id}" />

<c:set var="buttons" >
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty id}">
        <input type="submit" class="button" name="delete" onclick="return confirmDelete('')" 
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
    </li>
</c:set>


<form:form commandName="ingredient" method="post" action="ingredientform.html" onsubmit="return onFormSubmit(this)" id="ingredientForm">
        <form:hidden path="id"/>
        <ul>
                <li>
                        <appfuse:label key="ingredient.name" styleClass="desc" />
                        <form:errors path="name" cssClass="fieldError"/>
                        <form:input path="name" cssStyle="text medium"/>
                </li>
                <li>
                	<appfuse:label key="ingredient.description" styleClass="desc" />
                	<form:errors path="description" cssClass="fieldError" />
                	<form:textarea path="description" cols="80" rows="5"  />
                </li>
                                      <li>
                	<appfuse:label key="ingredient.amountPerServing" styleClass="desc" />
                	<form:errors path="amountPerServing" cssClass="fieldError" />
                	<form:textarea path="amountPerServing" cssStyle="text medium"  />
                </li>
                <li>
                	<appfuse:label key="ingredient.percentage" styleClass="desc" />
                	<form:errors path="percentage" cssClass="fieldError" />
                	<form:textarea path="percentage" cssStyle="text medium"  />
                </li>
        </ul>
		
        <c:out value="${buttons}" escapeXml="false" />

</form:form>

