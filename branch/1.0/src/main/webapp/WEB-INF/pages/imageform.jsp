<%@ include file="/common/taglibs.jsp" %>
<h1>
<fmt:message key="image.heading" />
</h1>
<display:table id="list" name="list" class="table" requestURI="imageform.html">
	<display:column property="id" titleKey="lookup.id"/>
	<display:column property="product.name" titleKey="product.name" />
	<display:column property="name" titleKey="lookup.name"/>
	<display:column titleKey="image.thumbnail">
		<img src="<c:url value="${list.thumbPath}" />" />
	</display:column>
</display:table>

<form:form commandName="image" method="post" action="imageform.html" enctype="multipart/form-data"
    onsubmit="return validateFileUpload(this)" id="imageForm">
    <form:hidden path="id"/>
	<ul>
	    
	    <li>
	    	<appfuse:label key="image.product" styleClass="desc"/>
	    		<form:errors path="product" cssClass="fieldError" />
	    	<spring:bind path="product">
	    		
	    		<select id="product" name="product">
	    			<option value=""><fmt:message key="option.select" /></option>
	    		<c:forEach var="p" items="${products}">
	    			<option value="${p.id}" ${p.id == product.id ? 'selected' : '' }>
	    				${p.name }
	    			</option>
	    		</c:forEach>
	    		</select>
	    	</spring:bind>
	    </li>
	    <li>
	        <appfuse:label key="image.name" styleClass="desc"/>
	        <form:errors path="name" cssClass="fieldError"/>
	        <form:input path="name" id="name" cssClass="text medium" cssErrorClass="text state error"/>
	    </li>
	    <li>
	        <appfuse:label key="image.file" styleClass="desc"/>
	        <form:errors path="file" cssClass="fieldError"/>
	        <input type="file" name="file" id="file" class="file medium"/>
	    </li>
	    <li class="info">
	        <fmt:message key="upload.message"/>
	    </li>
	    <li class="buttonBar bottom">
	        <input type="submit" name="upload" class="button" onclick="bCancel=false"
	            value="<fmt:message key="button.upload"/>" />
	        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
	            value="<fmt:message key="button.cancel"/>" />
	    </li>
	</ul>
</form:form>