<%@ include file="/common/taglibs.jsp" %>

<h1><fmt:message key="add.news" /></h1>
<script type="text/javascript">
  window.onload = function() {
	  CKEDITOR.replace( 'contentBody' );
  }
</script>
<form:form commandName="news" method="post" action="newsform.html" onsubmit="return onFormSubmit(this)" id="catalogForm">
        <form:hidden path="id"/>
        <ul>
            <li>
                <appfuse:label key="news.title" styleClass="desc" />
                <form:errors path="title" cssClass="fieldError"/>
                <form:input path="title" cssStyle="text medium"/>
            </li>
            <li>
            	<appfuse:label key="news.content" styleClass="desc" />
            	<form:errors path="contentBody" cssClass="fieldError" />
            	<form:textarea path="contentBody"/>
            </li>
        </ul>
		
        <c:out value="${buttons}" escapeXml="false" />

</form:form>