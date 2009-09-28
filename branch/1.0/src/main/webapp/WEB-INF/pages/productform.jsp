<%@ include file="/common/taglibs.jsp" %>

<script type='text/javascript' src='<c:url value="/dwr/interface/catalogManager.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/brandNameManager.js" />'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>

<script type="text/javascript">
/**
 * todo : 
 * 
 */
 <%-- 
 	paremeters: fromNode: the id for that html tag.
 				manager: the manager this POJO.
 				fieldKey: the parent's id (eg. in brandName class, the parent is the manufacturer so the parent key is manufacutrer.id
 				toNode: where is the generated options attached to.
 --%>
 function fillChildren(fromNode, manager,fieldKey, toNode) {
	
	var parentId = fromNode.value;
	if (parentId != null ) {
		manager.getRelativeObjects(fieldKey, parentId, function(children) {addOptions(children, toNode)});
	}

}


 function addOptions(array, toDom){
 	dwr.util.removeAllOptions(toDom);
	var multiple = toDom.multiple;
	var nextOptionPosition = 0;
 	if (multiple == false ) {
 		option = document.createElement("option");
 		option.value = "";
 		option.text = "<fmt:message key="please.select" />";
 		toDom.options[0] = option;
 		nextOptionPosition = 1;
 	}
	for (i = 0; i < array.length; i++ ) {
		option = document.createElement("option");
		option.value = array[i].id;
		option.text = array[i].name;
		toDom.options[i + nextOptionPosition ] = option;
	}
}

 function showProduct(node) {
	var foodProduct = ${foodProduct};
	var entertainProduct = ${entertainProduct};
	var entertainService = ${entertainService};

	var displayNode;
	foodNode = document.getElementById("food_product");
	entertainProductNode = document.getElementById("entertain_product");
	entertainServiceNode = document.getElementById("entertain_service");
	
	if (node.value == foodProduct ) {
		foodNode.style.display = 'block';
		entertainProductNode.style.display = 'none';
		entertainServiceNode.style.display = 'none';
	}else if (node.value == entertainProduct ) {
		foodNode.style.display = 'none';
		entertainProductNode.style.display = 'block';
		entertainServiceNode.style.display = 'none';	
	}else if (node.value == entertainService ) {
		foodNode.style.display = 'none';
		entertainProductNode.style.display = 'none';
		entertainServiceNode.style.display = 'block';
	}else if (node.value == null || node.value == '' ) {
		//do nothing
	}else {
		alert("unknow Catalog, Please ask Developer to add this product field for you ");
	}
 }
/*
 * based on the parent catalog, display a proper field for this catalog.
 *
 */
function displayProductDetail(catalogValue) {
	

	
}
</script>

<style>
	#food_product {
		display: none;
	}
	#entertain_product {
		display:none;
	}
	#entertain_service {
		display:none;
	}


</style>
<head>
	<meta content="MainMenu" name="menu">
	<script type="javascript/text">
		
	
	</script>
</head>
<h1><fmt:message key="Add A Proudct" /></h1>
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




<form:form commandName="product" action="/productform.html" method="post">
	<form:hidden path="id"/>
<ul>

	<li>
		<a href="/catalogform.html" target="catalog" ><fmt:message key="catalog.add.item" /></a>
		<p>
		<a href="#"  onclick="location.href='<c:url value="/productform.html"/>'" /><fmt:message key="refresh.list" /></a>
		</p>
		<appfuse:label key="product.catalog" styleClass="desc" />
		<select name="mainCatalogy" id="mainCatalogy" onchange="fillChildren(this, catalogManager,'parent.id', catalogs); showProduct(this)">
			${pleaseSelect }
			<c:forEach var="catalog" items="${catalogs}">
				<option value="${catalog.id }" ${catalog.id == productCatalog.id ? 'selected' : '' } > ${catalog.name}</option>
			</c:forEach>
		</select>
	</li>
	<li>
		<c:if test="${not empty catalogs }">	
			<appfuse:label key="product.catalog" styleClass="desc" />
			<form:errors path="catalogs" cssStyle="fieldErrors" />
			<spring:bind path="catalogs" >
				<select name="catalogs" id="catalogs" multiple="multiple" size="5"  >
				</select>
			</spring:bind>
		</c:if>
		
	</li>
	<li>
		<a href="<c:url value="/manufacturerform.html" /> target="manufacturer"><fmt:message key="add.manufacturer" /></a>
		<%-- <a href="manufacturerform.html" target="manufacturer" ><fmt:message key="manufacturer.add.item" /></a>--%>
		<appfuse:label key="product.manufacturer" styleClass="desc" />
		<select id="manufacturer" name="manufacturer" class="text medium" onchange="fillChildren(this,brandNameManager,'manufacturer.id', brandName)">
			<c:out value="${pleaseSelect}" escapeXml="flase" />
			<c:forEach var="manufacturer" items="${manufacturers }">
				<option value="${manufacturer.id }" ${manufacturer.id == product.brandName.manufacturer.id ? 'selected' : '' }> ${manufacturer.name }</option>
			</c:forEach>
		</select>
	</li>
	<li>
		<appfuse:label key="product.brandName" styleClass="desc" />
		<form:errors path="brandName"  cssClass="text medium"/>
		<spring path="brandName">
			<select id="brandName" name="brandName">
				${pleaseSelect }
				<c:forEach var="brand" items="${brandNames}">
					<option value="${brand.id }" ${brand.id == product.brandName.id ? "selected" : "" }>${brand.name }</option>
				
				</c:forEach>
			</select>
		</spring>
	</li>
	<li>
		<appfuse:label key="product.name" styleClass="desc" />
		<form:errors path="name" cssClass="fieldErrors"/>
		<form:input path="name" cssClass="text medium" />
	</li>
	<li>
		<appfuse:label key="product.sku" styleClass="desc" />
		<form:errors path="sku" cssClass="fieldErrors" />
		<form:input path="sku" cssClass="text medium" />
	</li>
	<li>
		<appfuse:label key="product.barcode" styleClass="desc" />
		<form:errors path="barcode" cssStyle="fieldErrors" />
		<form:input path="barcode" cssStyle="text medium" />
	
	</li>
	<li>
		
		<appfuse:label key="product.description" styleClass="desc" />
		<form:errors path="description" cssStyle="fieldErrors" />
		<form:textarea path="description" rows="5" cols="80"/>
		
	</li>
	<li>
		<appfuse:label key="product.price" styleClass="desc" />
		<form:errors path="price" cssStyle="fieldErrors" />
		<form:input path="price" cssStyle="text medium" />
	</li>
	
	
	 <%@ include file="common/food_product.jsp" %>
	 <%@ include file="common/entertain_service.jsp" %>
	 <%@ include file="common/entertain_product.jsp"  %>
	
	
	
</ul>
	
<c:out value="${buttons}" escapeXml="false" />	
	

</form:form>

<p>
<fmt:message key="reminder.to.add.image" />
</p>
