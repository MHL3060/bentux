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





<display:table id="list" name="list" class="table" requestURI="imageform.html">
	<display:column titleKey="image.id">
                <c:url value="/imageform.html" var="imageUrl">
                        <c:param name="id" value="${list.id}" />
                        <c:param name="pid" value="${param.pid }" />
                </c:url>
                <a href="${imageUrl }"> ${list.id }</a>
        </display:column>
        <display:column property="product.name" titleKey="product.name" />
        <display:column property="name" titleKey="lookup.name"/>
        <display:column titleKey="image.thumbnail">
                <img src="<c:url value="${list.thumbPath}" />" />
        </display:column>
</display:table>



<form:form commandName="image" method="post" action="imageform.html" enctype="multipart/form-data"
    onsubmit="return validateFileUpload(this)" id="imageForm">
    <form:hidden path="id"/>
    <form:hidden path="product" />
	<ul>
	    
	    <li>
	    	<appfuse:label key="image.product" styleClass="desc"/>
	    	<form:errors path="product" cssClass="fieldError" />
	    	<input type="text" id="productName" name="productName" value="${image.product.name }" onblur="handleAdd()" />
	    	<div id="productList" class="auto_complete"></div>
           	<script type="text/javascript">
               	new Autocompleter.DWR('productName', 'productList', updateList,{ valueSelector: nameValueSelector, partialChars: 3 });
           	</script>
        	
	    </li> 
       	<li>
	        <appfuse:label key="image.name" styleClass="desc"/>
	        <form:errors path="name" cssClass="fieldError"/>
	        <form:input path="name" id="name" cssClass="text medium"/>
	    </li>
        <li>
	        <appfuse:label key="image.file" styleClass="desc"/>
	        <form:errors path="file" cssClass="fieldError"/>
	        <input type="file" name="file" id="file" class="file medium"/>
		   
	    </li>
	    <li class="info">
	        <fmt:message key="upload.message"/>
	    </li>
	    <li class="buttonBar bottom">
	        <input type="submit" name="save" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.save"/>" />
	        <input type="submit" name="cancel" class="button"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	</ul>
</form:form>