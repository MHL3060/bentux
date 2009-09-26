<%@ include file="/common/taglibs.jsp" %>
<div id="food_product">
<li>
	<div class="left">
		<appfuse:label key="product.foodProduct.weight" styleClass="desc" />
		<form:errors path="foodProduct.weight" cssStyle="fieldErrors" />
		<form:input path="foodProduct.weight" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.foodProduct.weightUnit" styleClass="desc" />
		<form:errors path="foodProduct.weightUnit" cssStyle="fieldErrors" />
		<form:select path="foodProduct.weightUnit"  items="${units}"  cssStyle="text medium" />
		</div>
	</li>
	<li>
		<div class="left">
			<appfuse:label key="product.foodProduct.width" styleClass="desc" />
			<form:errors path="foodProduct.width" cssStyle="fieldErrors" />
			<form:input path="foodProduct.width" cssStyle="text medium" />
		</div>
		<div>
			<appfuse:label key="product.foodProduct.height" styleClass="desc" />
			<form:errors path="foodProduct.height" cssStyle="fieldErrors" />
			<form:input path="foodProduct.height" cssStyle="text medium" />
		</div>
		<div>
			<appfuse:label key="product.foodProduct.depth" styleClass="desc" />
			<form:errors path="foodProduct.depth" cssStyle="fieldErrors" />
			<form:input path="foodProduct.depth" cssStyle="text medium" />
		</div>
	</li>
	<li>
		<appfuse:label key="product.foodProduct.volumeUnit" styleClass="desc" />
		<form:errors path="foodProduct.volumeUnit" cssStyle="fieldErrors" />
		<form:input path="foodProduct.volumeUnit" cssStyle="text medium" />
	</li>
	<li>
		<appfuse:label key="product.foodProduct.dayLife" styleClass="desc" />
		<form:errors path="foodProduct.dayLife" cssStyle="fieldErrors" />
		<form:input path="foodProduct.dayLife" cssStyle="text medium" />
	</li>
	<li>
		<a href="ingredientform.html" target="ingredient" ><fmt:message key="ingredient.add.item" /></a>
		<appfuse:label key="product.foodProduct.ingredient" styleClass="desc" />
		<form:errors path="foodProduct.ingredient" cssStyle="fieldErrors" />
		<spring:bind path="foodProduct.ingredient">
			<select id="ingredient" name="ingredient" class="text medium">
				<c:out value="${pleaseSelect}" escapeXml="flase" />
				<c:forEach var="ingredient" items="${ingredient }">
					<option value="${ingredient.id }" ${ingredient.id == product.foodProduct.ingredient.id ? 'selected' : '' }> ${ingredient.name }</option>
				</c:forEach>
			</select>
		</spring:bind>
	</li>
</div>