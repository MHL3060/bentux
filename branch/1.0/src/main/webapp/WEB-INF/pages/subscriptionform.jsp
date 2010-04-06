<%@ include file="/common/taglibs.jsp" %>
<h1><fmt:message key="subscribeUsers.message"/></h1>

<head>
    <title><fmt:message key="subscribeUsers.message"/></title>
    <meta name="heading" content="<fmt:message key='subscribeUsers.heading'/>"/>
</head>

<body id="subscribeUsers"/>

<div class="separator"></div>

<input type="button" onclick="location.href='mainMenu.html'" value="<fmt:message key="button.done"/>"/>


<c:if test="${hasPermission }">
<display:table id="list" name="subscription" class="table list" >
		<display:column property="email" titleKey="subscription.email"/>
</display:table>
</c:if>

<form:form commandName="subscription" method="post" action="subscriptionform.html" onsubmit="return onFormSubmit(this)" id="subscriptionForm">
    <form:hidden path="id"/>
    <form:hidden path="user"/>
    
	<ul>
		<li>
			<img src="<c:url value="/captcha.html" />" />
		</li>
		
		<li>
			<appfuse:label key="subscription.phoneNumber" styleClass="desc" />
			<form:errors path="phoneNumber" cssClass="fieldError"  />
			<form:input path="phoneNumber"/>
		</li>
		
		<li>
			<appfuse:label key="subscription.email" styleClass="desc" />
			<form:errors path="email" cssClass="fieldError"  />
			<form:input path="email"/>
		</li>
	

		<li>
			<appfuse:label key="subscription.validation" styleClass="desc" />
			<form:errors path="validation" cssClass="fieldError"  />
			<form:input path="validation"/>
		</li>
	
          
				
		<li class="buttonBar bottom">
	        <input type="submit" name="upload" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.upload"/>" />
	        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	 </ul>
</form:form>

