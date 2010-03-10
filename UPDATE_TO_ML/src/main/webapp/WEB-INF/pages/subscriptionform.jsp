<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="subscribeUsers.title"/></title>
    <meta name="heading" content="<fmt:message key='subscribeUsers.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<body id="subscribeUsers"/>

<p><fmt:message key="subscribeUsers.message"/></p>


<div class="separator"></div>

<input type="button" onclick="location.href='mainMenu.html'" value="<fmt:message key="button.done"/>"/>

<display:table id="list" name="subscription" class="table list" >
		<display:column property="email" titleKey="subscription.email"/>
		<display:column property="phone_number" titleKey="subscription.phone_number"/>
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
			 <appfuse:label styleClass="desc" key="subscription.phone_number"/>
            <form:errors path="phone_number" cssClass="fieldError"/>
            <form:input path="phone_number" id="email" cssClass="text medium" cssErrorClass="text medium error"/>
        </li>  		
        <li>
            <appfuse:label styleClass="desc" key="subscription.email"/>
            <form:errors path="email" cssClass="fieldError"/>
            <form:input path="email" id="email" cssClass="text medium" cssErrorClass="text medium error"/>
        </li>  
          
				
		<li class="buttonBar bottom">
	        <input type="submit" name="upload" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.upload"/>" />
	        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	 </ul>
</form:form>

