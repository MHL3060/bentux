<%@ include file="/common/taglibs.jsp" %>

<head>
    <meta name="heading" content="<fmt:message key='subscribeUsers.heading'/>"/>
</head>

<div class="separator"></div>

<c:if test="${subscription.user.username == 'admin'}">
<display:table name="list" id="list" pagesize="25" class="table" requestURI="subscriptionform.html">
		<display:column property="email" titleKey="subscription.email"/>
		<display:column property="phoneNumber" titleKey="subscription.phoneNumber"/>
</display:table>
<input type="button" onclick="location.href='mainMenu.html'" value="<fmt:message key="button.done"/>"/>
</c:if>

<div class="separator"></div>


<c:if test="${subscription.user.username != 'admin'}">
	<fmt:message key="subscribeUsers.message"/>

	<form:form commandName="subscription" method="post" action="subscriptionform.html" onsubmit="return onFormSubmit(this)" id="subscriptionForm">
	    <form:hidden path="id"/>
	    
		<ul>
			<li>
				<appfuse:label key="subscription.phoneNumber" styleClass="desc" />
				<form:errors path="phoneNumber" cssClass="fieldError"  />
				<form:input path="phoneNumber"/>
			</li>
			
			<li>
				<appfuse:label key="subscription.email" styleClass="desc" />
				<form:errors path="email" cssClass="fieldError"  />
				<form:input path="email" cssClass="text medium"/>
			</li>
		
			<li>
				<appfuse:label key="subscription.validation" styleClass="desc" />	
				<img src="<c:url value="/captcha.html" />" />
			
				<appfuse:label key="subscrition.validationbox" styleClass="desc" />
				<form:errors path="validation" cssClass="fieldError"  />
				<form:input path="validation"/>
			</li>
						
			<li class="buttonBar bottom">
		        <input type="submit" name="done" class="button" onclick="bCancel=false"
		            value="<fmt:message key="button.done"/>" />
		        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
		            value="<fmt:message key="button.cancel"/>" />
		    </li>
		 </ul>
	</form:form>
</c:if>
