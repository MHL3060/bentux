<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
/**
 * todo : 
 * 
 */
 function fillChildren(fromNode, manager, toNode) {



}
/*
 * based on the parent catalog, display a proper field for this catalog.
 *
 */
function displayProductDetail(catalogValue) {


	
}
</script>
<head>
	<meta content="MainMenu" name="menu">
	<script type="javascript/text">
		
	
	</script>
</head>
<h1><fmt:message key="Add A Proudct" /></h1>
<c:set var="pleaseSelect">
	<option value=""><fmt:message key="please.select" /></option>
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
		<select name="mainCatalogy" id="mainCatalogy" onchange="fillChildren(this, catalogManager, catalogs)">
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
		<a href="<c:url value="/manufacturerform.html" /> target="manufacturer"><fmt:message key="add.manufacturer" /></a>
		<%-- <a href="manufacturerform.html" target="manufacturer" ><fmt:message key="manufacturer.add.item" /></a>--%>
		<appfuse:label key="product.manufacturer" styleClass="desc" />
		<form:errors path="manufacturer" cssStyle="fieldErrors" />
		<spring:bind path="manufacturer">
			<select id="manufacturer" name="manufacturer" class="text medium">
				<c:out value="${pleaseSelect}" escapeXml="flase" />
				<c:forEach var="manufacturer" items="${manufacturers }">
					<option value="${manfucturer.id }" ${manufacturer.id == product.manufacturer.id ? 'selected' : '' }> ${manufacturer.name }</option>
				</c:forEach>
			</select>
		</spring:bind>
	</li>
	
	<li>
		<a href="ingredientform.html" target="ingredient" ><fmt:message key="ingredient.add.item" /></a>
		<appfuse:label key="product.ingredient" styleClass="desc" />
		<form:errors path="ingredient" cssStyle="fieldErrors" />
		<spring:bind path="ingredient">
			<select id="ingredient" name="ingredient" class="text medium">
				<c:out value="${pleaseSelect}" escapeXml="flase" />
				<c:forEach var="ingredient" items="${ingredient }">
					<option value="${ingredient.id }" ${ingredient.id == product.ingredient.id ? 'selected' : '' }> ${ingredient.name }</option>
				</c:forEach>
			</select>
		</spring:bind>
	</li>
	
	<li>
		<appfuse:label key="product.price" styleClass="desc" />
		<form:errors path="price" cssStyle="fieldErrors" />
		<form:input path="price" cssStyle="text medium" />
	</li>
	
	<li>
		<appfuse:label key="product.dayLife" styleClass="desc" />
		<form:errors path="dayLife" cssStyle="fieldErrors" />
		<form:input path="dayLife" cssStyle="text medium" />
	</li>
	
</ul>
	
	<input type="submit" name="submit" value="Submit" />
	

</form:form>

<p>
<fmt:message key="reminder.to.add.image" />
</p>
