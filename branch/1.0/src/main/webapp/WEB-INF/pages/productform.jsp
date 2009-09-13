<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="Add A Proudct" /></h1>
<c:set var="pleaseSelect">
	<option value=""><fmt:message key="please.select" /></option>
</c:set>
<form:form path="product" action="/productform.html" method="post">
	<form:hidden path="id"/>
<ul>
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
		<appfuse:label key="product.image" styleClass="desc" />
		<form:errors path="image" cssStyle="fieldErrors" />
		<spring:bind path="image">
			<select name="image" id="image">
				<c:out value="${pleaseSelect}" escapeXml="false" />
				<c:forEach var="image" items="${images}">
					<option value="${image.id}" ${image.id == product.image.id ? 'selected' : '' }>${image.name }</option>
				</c:forEach>
			</select>
		</spring:bind>
	</li>
	<li>
		<appfuse:label key="product.description" styleClass="desc" />
		<form:errors path="descrition" cssStyle="fieldErrors" />
		<form:textarea path="description" cssClass="text medium"  rows=5 cols="50"/>
	</li>
	<li>
		<appfuse:label key="product.manufacturer" styleClass="desc" />
		<form:errors path="product.manufacturer" cssStyle="fieldErrors" />
		<spring:bind path="manufacturer">
			<select id="manufacturer" name="manufacturer" class="text medium">
				<c:out value="${pleaseSelect" escapeXml="flase" />
				<c:forEach var="manufacturer" items="${manufacturers }">
					<option value="${manfucturer.id }" ${manufacturer.id == product.manufacturer.id ? 'selected' : '' }> ${manufacturer.name }</option>
				</c:forEach>
			</select>
		</spring:bind>
	</li>
	<li>
		<div class="left">
			<appfuse:label key="product.weight" styleClass="desc" />
			<form:errors path="weight" cssStyle="fieldErrors" />
			<form:input path="weight" cssStyle="text medium" />
		</div>
		<div>
			<appfuse:label key="product.weightUnit" styleClass="desc" />
			<form:errors path="weightUnit" cssStyle="fieldErrors" />
			<form:select path="weightUnit" itemValue="unit" items="${units}"  cssStyle="text medium" />
		</div>
	</li>
	<li>
		<div class="left">
			<appfuse:label key="product.width" styleClass="desc" />
			<form:errors path="width" cssStyle="fieldErrors" />
			<form:input path="width" cssStyle="text medium" />
		</div>
		<div>
			<appfuse:label key="product.height" styleClass="desc" />
			<form:errors path="height" cssStyle="fieldErrors" />
			<form:input path="height" cssStyle="text medium" />
		</div>
		<div>
			<appfuse:label key="product.depth" styleClass="desc" />
			<form:errors path="depth" cssStyle="fieldErrors" />
			<form:input path="depth" cssStyle="text medium" />
		</div>
	</li>
	<li>
		<appfuse:label key="product.volumeUnit" styleClass="desc" />
		<form:errors path="volumeUnit" cssStyle="fieldErrors" />
		<form:input path="volumeUnit" cssStyle="text medium" />
	</li>
	
	
	
</ul>


</form:form>

