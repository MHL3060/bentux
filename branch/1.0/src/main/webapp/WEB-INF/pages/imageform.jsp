<%@ include file="/common/taglibs.jsp" %>
<script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js" />'></script>
<script type="text/javascript" src="<c:url value="/scripts/prototype.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/effects.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/controls.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/autocomplete.js" />" ></script>
<script type="text/javascript">
	
	function updateList(autocompleter, token) {
         // AddressServiceFacade.findCompletePostalCodes(token, function(data) { autocompleter.setChoices(data) });
        productManager.search('name',token, function(data) {autocompleter.setChoices(data) });
    }
    function nameValueSelector(tag){
     	return tag.name;
    }
	function handleAdd() {
		var searchString = DWRUtil.getValue('productName');
		productManager.getLookUpBaseObject(searchString, function(product){dwr.util.setValue('product',product.id)});
	}
	
</script>
<style>
div.auto_complete {
    width: 350px;
    background: #fff;
}

div.auto_complete ul {
    border: 1px solid #31430f;
    margin: 0;
    padding: 0;
    width: 100%;
    list-style-type: none;
}

div.auto_complete ul li {
    margin: 0;
    padding: 3px;
    text-align: left;
}

div.auto_complete ul li.selected {
    background-color: #dcedad;
}

div.auto_complete ul strong.highlight {
    color: #800;
    margin:0;
    padding:0;
}
</style>




<h1>
<fmt:message key="image.heading" />
</h1>





<display:table id="list" name="list" class="table" requestURI="imageform.html">
	<display:column property="id" titleKey="lookup.id"/>
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
	    	<input type="text" id="productName" name="productName" onblur="handleAdd()" />
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
	        <input type="submit" name="upload" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.upload"/>" />
	        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	</ul>
</form:form>