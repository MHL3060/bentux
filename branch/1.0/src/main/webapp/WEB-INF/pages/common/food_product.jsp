<%@ include file="/common/taglibs.jsp" %>
<div id="food_product">
<li>
	<div class="left">
		<appfuse:label key="product.weight" styleClass="desc" />
		<form:errors path="weight" cssStyle="fieldErrors" />
		<form:input path="weight" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.weightUnit" styleClass="desc" />
		<form:errors path="weightUnit" cssStyle="fieldErrors" />
		<form:select path="weightUnit"  items="${units}"  cssStyle="text medium" />
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
</div>