<%@ include file="/common/taglibs.jsp" %> 

<h1><fmt:message key="brandName.heading" /></h1>

<display:table name="list" id="list" pagesize="25" class="table" requestURI="brandNameform.html">
        <display:column property="id" titleKey="lookup.id" url="/brandNameform.html" paramId="id" paramProperty="id" />     
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
</display:table>

<c:set var="id" value="${brandName.id}" />

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


<form:form commandName="brandName" method="post" action="brandNameform.html" onsubmit="return onFormSubmit(this)" id="brandNameForm">
        <form:hidden path="id"/>
        <ul>
                 <li>
                	<appfuse:label key="brandName.id" styleClass="desc" />
                	<form:errors path="id" cssClass="fieldError" />
                	<form:textarea path="id" cols="80" rows="5"  />
                </li>
                <li>
                        <appfuse:label key="brandName.name" styleClass="desc" />
                        <form:errors path="name" cssClass="fieldError"/>
                        <form:input path="name" cssStyle="text medium"/>
                </li>
        </ul>
		
        <c:out value="${buttons}" escapeXml="false" />

</form:form>

