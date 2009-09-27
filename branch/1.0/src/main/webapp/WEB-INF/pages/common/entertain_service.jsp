<%@ include file="/common/taglibs.jsp" %>
<div id="entertain_service">
<li>
	<div class="left">
		<appfuse:label key="product.entertainService.showFrom" styleClass="desc" />
		<form:errors path="entertainService.showFrom" cssStyle="fieldErrors" />
		<form:input path="entertainService.showFrom" cssStyle="text medium" />	
	</div>
	<div>
		<appfuse:label key="product.entertainService.showTo" styleClass="desc" />
		<form:errors path="entertainService.showTo" cssStyle="fieldErrors" />
		<form:input path="entertainService.showTo" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainService.address" styleClass="desc" />
		<form:errors path="entertainService.address" cssStyle="fieldErrors" />
		<form:input path="entertainService.address" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainService.showTime" styleClass="desc" />
		<form:errors path="entertainService.showTime" cssStyle="fieldErrors" />
		<form:input path="entertainService.showTime" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainService.showDuration" styleClass="desc" />
		<form:errors path="entertainService.showDuration" cssStyle="fieldErrors" />
		<form:input path="entertainService.showDuration" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainService.showType" styleClass="desc" />
		<form:errors path="entertainService.showType" cssStyle="fieldErrors" />
		<form:input path="entertainService.showType" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainService.showDescription" styleClass="desc" />
		<form:errors path="entertainService.showDescription" cssStyle="fieldErrors" />
		<form:input path="entertainService.showDescription" cssStyle="text medium" />
	</div>
</li>
</div>