<%@ include file="/common/taglibs.jsp"%>

<script>

//"Accept terms" form submission- By Dynamic Drive
//For full source code and more DHTML scripts, visit http://www.dynamicdrive.com
//This credit MUST stay intact for use

var checkobj

function agreesubmit(el){
checkobj=el
if (document.all||document.getElementById){
for (i=0;i<checkobj.form.length;i++){  //hunt down submit button
var tempobj=checkobj.form.elements[i]
if(tempobj.type.toLowerCase()=="submit")
tempobj.disabled=!checkobj.checked
}
}
}

function defaultagree(el){
if (!document.all&&!document.getElementById){
if (window.checkobj&&checkobj.checked)
return true
else{
alert("Please read/accept terms to submit form")
return false
}
}
}


function tryAnotherCaptcha() {
	document.getElementById('captcha_image').src = '<c:url value="/captcha.html"/>' + '?' + (new Date()).getTime();
}
</script>



<head>
    <title><fmt:message key="signup.title"/></title>
    <meta name="heading" content="<fmt:message key='signup.heading'/>"/>
</head>

<body id="signup"/>

<spring:bind path="user.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">    
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<div class="separator"></div>

<form:form commandName="user" method="post" action="signup.html" onsubmit="return validateUser(this)" id="signupForm">
<ul>
    <li class="info">
        <fmt:message key="signup.message"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="user.username"/>
        <form:errors path="username" cssClass="fieldError"/>
        <form:input path="username" id="username" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    <li>
    	<div>
            <div class="left">
                <appfuse:label styleClass="desc" key="user.password"/>
                <form:errors path="password" cssClass="fieldError"/>
                <form:password path="password" id="password" cssClass="text medium" cssErrorClass="text medium error" showPassword="true"/>
            </div>
            <div>
                <appfuse:label styleClass="desc" key="user.confirmPassword"/>
                <form:errors path="confirmPassword" cssClass="fieldError"/>
                <form:password path="confirmPassword" id="confirmPassword" cssClass="text medium" cssErrorClass="text medium error" showPassword="true"/>
            </div>
        </div>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="user.passwordHint"/>
        <form:errors path="passwordHint" cssClass="fieldError"/>
        <form:input path="passwordHint" id="passwordHint" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    <li>
        <div class="left">
            <appfuse:label styleClass="desc" key="user.firstName"/>
            <form:errors path="firstName" cssClass="fieldError"/>
            <form:input path="firstName" id="firstName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        </div>
        <div>
            <appfuse:label styleClass="desc" key="user.lastName"/>
            <form:errors path="lastName" cssClass="fieldError"/>
            <form:input path="lastName" id="lastName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        </div>
    </li>
    <li>
        <div>
            <div class="left">
                <appfuse:label styleClass="desc" key="user.email"/>
                <form:errors path="email" cssClass="fieldError"/>
                <form:input path="email" id="email" cssClass="text medium" cssErrorClass="text medium error"/>
            </div>
            <div>
                <appfuse:label styleClass="desc" key="user.phoneNumber"/>
                <form:errors path="phoneNumber" cssClass="fieldError"/>
                <form:input path="phoneNumber" id="phoneNumber" cssClass="text medium" cssErrorClass="text medium error"/>
            </div>
        </div>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="user.website"/>
        <form:errors path="website" cssClass="fieldError"/>
        <form:input path="website" id="website" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    <li>
        <label class="desc"><fmt:message key="user.address.address" /></label>
        <div class="group">
            <div>
                <form:input path="address.address" id="address.address" cssClass="text large" cssErrorClass="text large error"/>
                <form:errors path="address.address" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.address"/></p>
            </div>
            <div class="left">
                <form:input path="address.city" id="address.city" cssClass="text medium" cssErrorClass="text medium error"/>
                <form:errors path="address.city" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.city"/></p>
            </div>
            <div>
                <form:input path="address.province" id="address.province" cssClass="text state" cssErrorClass="text state error"/>
                <form:errors path="address.province" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.province"/></p>
            </div>
            <div class="left">
                <form:input path="address.postalCode" id="address.postalCode" cssClass="text medium" cssErrorClass="text medium error"/>
                <form:errors path="address.postalCode" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.postalCode"/></p>
            </div>
            <div>
                <appfuse:country name="address.country" prompt="" default="${user.address.country}"/>
                <p><appfuse:label key="user.address.country"/></p>
            </div>
       </div>
    </li>

	
	  <li>
        <div class="group">
	        <div>
				<img id="captcha_image" src="<c:url value="/captcha.html"/>" alt="Dynamic Verification Code" border="5"/>
			</div>
			<div>
				<input type="text" name="captcha"  />
				<a href="javascript:tryAnotherCaptcha()">Refresh</a>
				    
			</div>
		</div>
	</li>


        	       	
	<li>
	    <label class="desc"><fmt:message key="user.agreement"/></label>
		<div class="group">
			<div>
				<form name="agreeform" onSubmit="return defaultagree(this)">
				If you want to turn on Registration Agreement you must put a check the box for, "Show and require agreement letter when registering." This makes every new Member agree to your terms before allowing them to register. Otherwise if this is disabled no registration agreement will be shown on the registration page.<br>
				<input name="agreecheck" type="checkbox" onClick="agreesubmit(this)"><b>I agree to the above terms</b><br>
				</form>	
			</div>
		<script>
		//change two names below to your form's names
		document.forms.agreeform.agreecheck.checked=false
		</script>
		</div>
	</li>			
    <li class="buttonBar bottom">
        <input type="submit" value="submit" disabled class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.register"/>"/>
        <input type="submit" value="cancel" disabled class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
    </li>
</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('signupForm'));
    highlightFormElements();
</script>

<v:javascript formName="user" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>


