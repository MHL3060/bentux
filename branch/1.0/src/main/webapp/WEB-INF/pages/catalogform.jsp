<%@ include file="/common/taglibs.jsp" %>
<script type='text/javascript' src='<c:url value="/dwr/interface/imageManager.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js" />'></script>
<script type="text/javascript" src="<c:url value="/scripts/prototype.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/effects.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/controls.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/autocomplete.js" />" ></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/autocomplete.css'/>" />
<script type="text/javascript">
	function submitForm() {
	 handleAdd();
	 document.getElementById('catalogForm').submit();

	}
	function updateList(autocompleter, token) {
         // AddressServiceFacade.findCompletePostalCodes(token, function(data) { autocompleter.setChoices(data) });
        <%--       
        			name: the property of the POJO
        			token: 
        			function(data): the DWR callback
        --%>
        imageManager.search('name',token, function(data) {autocompleter.setChoices(data) });
    }
    function nameValueSelector(tag){
     	return tag.name;
    }
	function handleAdd() {
		var searchString = DWRUtil.getValue('imageName');
		if (searchString != ''){
			imageManager.getByName(searchString, function(LookUpBaseObject){
					dwr.util.setValue('image',LookUpBaseObject.id)
			});
		}
	}
	
</script>


<h1><fmt:message key="catalog.heading" /></h1>

<display:table name="list" id="list" pagesize="25" class="table" requestURI="catalogform.html">
        
        <display:column  titleKey="lookup.id" >
        	<c:choose>
	        	<c:when test="${list.id < 0 }">
	        		${list.id }
	        	</c:when>
	        	<c:otherwise>
	        		<c:url var="url" value="catalogform.html">
	        			<c:param name="id" value="${list.id}" />
	        		</c:url>
	        		<a href="<c:url value="${url }" />" >${list.id }</a>
	        	</c:otherwise>
	        </c:choose>
        </display:column>
        
        <display:column property="name" titleKey="lookup.name" sortable="true"/>
		<display:column property="htmlDisplayName" titleKey="lookup.parent" sortProperty="parent.name" sortable="true" />
		<display:column property="description" titleKey="lookup.description" />
		<display:column sortProperty="displayOrder" titleKey="lookup.displayOrder" >
			<c:url var="url" value="catalogform.html" >
				<c:param name="id" value="${list.id}" />
				<c:param name="displayOrder" value="true" />
			</c:url>
		</display:column>
</display:table>

<c:set var="id" value="${catalog.id}" />

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

<form:form commandName="catalog" method="post" action="catalogform.html" name="catalogForm" id="catalogForm">
        <form:hidden path="id"/>
        <form:hidden path="image" />
        <ul>
                <li>
                	<appfuse:label key="catalog.parent" styleClass="desc" />
                	<form:errors path="parent" cssClass="fieldError" />
                	<spring:bind path ="parent">
                		<select name="parent" id="parent">
                		${pleaseSelect }	
               			<c:forEach var="c" items="${parents}" >
               				<option value="${c.id }" ${c.id == catalog.parent.id ? 'selected' : '' }>${c.htmlOptionName}</option>
               			</c:forEach>
                		 
                		</select>
                	</spring:bind>
                </li>
                
                <li>
                	<appfuse:label key="catalog.image" styleClass="desc" />
                	<form:errors path="image" cssClass="fieldError" />
                	<input type="text" id="imageName" name="imageName" value="${image.product.name }"  />
			    	<div id="imageList" class="auto_complete"></div>
		           	<script type="text/javascript">
		               		new Autocompleter.DWR('imageName', 'imageList', updateList,{ valueSelector: nameValueSelector, partialChars: 3 });
		           	</script>
			<input type="button" onclick="handleAdd()" value="Use this image"/>
                
                </li>
                <li>
                        <appfuse:label key="catalog.name" styleClass="desc" />
                        <form:errors path="name" cssClass="fieldError"/>
                        <form:input path="name" cssStyle="text medium"/>
                </li>
                <li>
                	<appfuse:label key="catalog.description" styleClass="desc" />
                	<form:errors path="description" cssClass="fieldError" />
                	<form:textarea path="description" cols="80" rows="5"  />
                </li>
                <li>
                	<appfuse:label key="catalog.displayOrder" styleClass="desc" />
                	<form:errors path="displayOrder" cssClass="fieldError" />
                	<form:input path="displayOrder"  />
                </li>
        </ul>
		
        <c:out value="${buttons}" escapeXml="false" />

</form:form>

