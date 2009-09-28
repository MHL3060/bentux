<%@ include file="/common/taglibs.jsp" %>
<div id="entertain_service">
<li>
	<div class="left">
		<appfuse:label key="product.entertainmentService.showFrom" styleClass="desc" />
		<form:errors path="entertainmentService.showFrom" cssStyle="fieldErrors" />
		<form:input path="entertainmentService.showFrom" cssStyle="text medium" />	
	</div>
	<div>
		<appfuse:label key="product.entertainmentService.showTo" styleClass="desc" />
		<form:errors path="entertainmentService.showTo" cssStyle="fieldErrors" />
		<form:input path="entertainmentService.showTo" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainmentService.address" styleClass="desc" />
		<form:errors path="entertainmentService.address" cssStyle="fieldErrors" />
		<form:input path="entertainmentService.address" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainmentService.showTime" styleClass="desc" />
		<form:errors path="entertainmentService.showTime" cssStyle="fieldErrors" />
		<form:input path="entertainmentService.showTime" cssStyle="text medium" />
	</div>
	<div>
		<appfuse:label key="product.entertainmentService.showDuration" styleClass="desc" />
		<form:errors path="entertainmentService.showDuration" cssStyle="fieldErrors" />
		<form:input path="entertainmentService.showDuration" cssStyle="text medium" />
	</div>
</li>
</div>