<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="checkout.address" /></h1>

<form:form commandName="shoppingAddress" >

	<ul>
	
		<li>
			<label class="desc"><fmt:message key="user.billing.address"/></label>
        <div class="group">
            <div>
                <form:input path="user.address.address" id="user.address.address" cssClass="text large" cssErrorClass="text large error"/>
                <form:errors path="user.address.address" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.address"/></p>
            </div>
            <div class="left">
                <form:input path="user.address.city" id="user.address.city" cssClass="text medium" cssErrorClass="text medium error"/>
                <form:errors path="user.address.city" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.city"/></p>
            </div>
            <div>
                <form:input path="user.address.province" id="user.address.province" cssClass="text state" cssErrorClass="text state error"/>
                <form:errors path="user.address.province" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.province"/></p>
            </div>
            <div class="left">
                <form:input path="user.address.postalCode" id="user.address.postalCode" cssClass="text medium" cssErrorClass="text medium error"/>
                <form:errors path="user.address.postalCode" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.postalCode"/></p>
            </div>
            <div>
                <appfuse:country name="user.address.country" prompt="" default="${user.user.address.country}"/>
                <p><appfuse:label key="user.address.country"/></p>
            </div>
        </div>
		</li>
		
		<li>
			<label class="desc"><fmt:message key="user.address.address"/></label>
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
	</ul>
</form:form>