<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="checkout.address" /></h1>

<c:set var="buttons" >
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="next" value="<fmt:message key="button.next"/>"/>
        <c:if test="${not empty id}">
        <input type="submit" class="button" name="delete" onclick="return confirmDelete('')" 
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
    </li>
</c:set>
<form:form commandName="shippingAddress" >

	<ul>
	
		<li>
			
        <div class="group">
        <label class="desc"><fmt:message key="user.billing.address"/></label>
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
                <appfuse:country name="user.address.country" prompt="" default="${shippingAddress.user.address.country}"/>
                <p><appfuse:label key="user.address.country"/></p>
            </div>
        </div>
		
		<br />
		
        <div class="group">
        	<label class="desc"><fmt:message key="user.address.address"/></label>
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
                <appfuse:country name="address.country" prompt="" default="${shippingAddress.address.country}"/>
                <p><appfuse:label key="user.address.country"/></p>
            </div>
        </div>
		</li>
		<li>
			<c:out value="${buttons}" escapeXml="false" />
		</li>
	</ul>
</form:form>