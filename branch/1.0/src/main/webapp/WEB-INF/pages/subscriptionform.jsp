<%@ include file="/common/taglibs.jsp" %>

<display:table id="list" name="subscription" class="table list">
	<display:column property="email" titleKey="subscription.email"/>
</display:table>

<form:form commandName="subscription" method="post" action="subscriptionform.html" onsubmit="return onFormSubmit(this)" id="subscriptionForm">
	<form:hidden path="id"/>
	<ul>
		<li>
			<img src="<c:url value="/captcha.html" />" />
		</li>
		<li>
			<appfuse:label key="subscription.validation" styleClass="desc" />
			<form:errors path="validation" cssClass="fieldError"  />
			<form:input path="validation"/>
		</li>
		<li>
			<appfuse:label key="subscription.email" styleClass="desc" />
			<form:errors path="email"  cssClass="fieldError" />
			<form:input path="email" cssStyle="text medium" />
		</li>
		
		<li class="buttonBar bottom">
	        <input type="submit" name="upload" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.upload"/>" />
	        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	 </ul>
</form:form>

