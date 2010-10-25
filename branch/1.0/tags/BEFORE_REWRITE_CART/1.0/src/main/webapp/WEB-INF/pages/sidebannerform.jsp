<%@ include file="/common/taglibs.jsp" %>
<script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
<%-- the order is very important. I have spend a few hours scatching my head to wonder why it doesn't work --%>
<script type='text/javascript' src='<c:url value="/dwr/engine.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js" />'></script>
<script type="text/javascript" src="<c:url value="/scripts/prototype.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/effects.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/controls.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/autocomplete.js" />" ></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/autocomplete.css'/>" />
<script type="text/javascript">
	
	function updateList(autocompleter, token) {
        productManager.search('name',token, function(data) {autocompleter.setChoices(data) });
    }
    function nameValueSelector(tag){
     	return tag.name;
    }
	function handleAdd() {
		var searchString = DWRUtil.getValue('productName');
		if (searchString != null ){
			productManager.getLookUpBaseObject(searchString, function(product){dwr.util.setValue('product',product.id)});
		}
	}
	
</script>
<%-- end ajax add --%>
<h1>
<fmt:message key="image.heading" />
</h1>





<display:table id="list" name="list" class="table" requestURI="sidebannerform.html">
	<display:column titleKey="image.id">
                <c:url value="/sidebannerform.html" var="imageUrl">
                        <c:param name="id" value="${list.id}" />
                </c:url>
                <a href="${imageUrl }"> ${list.id }</a>
        </display:column>
        <display:column property="product.name" titleKey="product.name" />
        <display:column property="name" titleKey="lookup.name"/>
        <display:column titleKey="image.thumbnail">
                <img src="<c:url value="${list.thumbPath}" />" />
        </display:column>
</display:table>



<form:form commandName="sideBanner" method="post" action="sidebannerform.html" enctype="multipart/form-data"
    onsubmit="return validateFileUpload(this)" id="imageForm">
    <form:hidden path="id"/>
	<ul>
       	 <li>
	        <appfuse:label key="image.file" styleClass="desc"/>
	        <form:errors path="file" cssClass="fieldError"/>
	        <input type="file" name="file" id="file" class="file medium"/>
		   
	    </li>
       	<li>
	        <appfuse:label key="sideBanner.name" styleClass="desc"/>
	        <form:errors path="name" cssClass="fieldError"/>
	        <form:input path="name" id="name" cssClass="text medium"/>
	    </li>
	    <li>
	    	<appfuse:label key="sideBanner.url" styleClass="desc" />
	    	<form:errors path="url" cssClass="fieldError" />
	    	 <form:input path="url" id="url+" cssClass="text medium"/>
	    </li>
        <li>
	        <appfuse:label key="sideBanner.file" styleClass="desc"/>
	        <form:errors path="file" cssClass="fieldError"/>
	        <input type="file" name="file" id="file" class="file medium"/>
		   
	    </li>
	    <li class="info">
	        <fmt:message key="upload.message"/>
	    </li>
	    <li class="buttonBar bottom">
	        <input type="submit" name="upload" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.save"/>" />
	        <input type="submit" name="cancel" class="button"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	</ul>
</form:form>