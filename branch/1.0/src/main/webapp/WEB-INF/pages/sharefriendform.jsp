<%@ include file="/common/taglibs.jsp" %>

<head>
    <meta name="heading" content="<fmt:message key='shareFriend.heading'/>"/>
</head>

<div class="separator"></div>

	<form:form commandName="shareFriend" method="post" action="sharefriendform.html" onsubmit="return onFormSubmit(this);" id="shareFriendForm">
	    <form:hidden path="id"/>
	    
		<ul>
			<li>
				<appfuse:label key="shareFriend.name" styleClass="desc" />
				<form:errors path="name" cssClass="fieldError"  />
				<form:input path="name"/>
			</li>
			
			<li>
				<appfuse:label key="shareFriend.email" styleClass="desc" />
				<form:errors path="email" cssClass="fieldError"  />
				<form:input path="email" cssClass="text medium"/>
			</li>
				<li>
				<appfuse:label key="shareFriend.friendName" styleClass="desc" />
				<form:errors path="friendName" cssClass="fieldError"  />
				<form:input path="friendName"/>
			</li>
			<li>
				<appfuse:label key="shareFriend.friendEmail" styleClass="desc" />
				<form:errors path="friendEmail" cssClass="fieldError"  />
				<form:input path="friendEmail"/>
			</li>
			<li>
				<appfuse:label key="shareFriend.suggestion" styleClass="desc" />
				<form:errors path="suggestion" cssClass="fieldError"  />
				<form:textarea path="suggestion"  rows="3" cols="30"/>
				
			</li>
			<li>
				<appfuse:label key="shareFriend.validation" styleClass="desc" />	
				<img src="<c:url value="/captcha.html" />" />
			
				<appfuse:label key="shareFriend.validationbox" styleClass="desc" />
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
