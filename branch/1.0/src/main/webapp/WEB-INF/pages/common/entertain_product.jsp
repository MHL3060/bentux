<%@ include file="/common/taglibs.jsp" %>
<div id="entertain_product">
	<li>
		<appfuse:label key="product.entertainmentProduct.imdb_link" styleClass="desc" />
		<form:errors path="entertainmentProduct.imdbLink" cssStyle="fieldErrors" />
		<form:input path="entertainmentProduct.imdbLink" cssStyle="text medium" />	
	</li>
	<li>
		<appfuse:label key="product.entertainmentProduct.issn" styleClass="desc" />
		<form:errors path="entertainmentProduct.issn" cssStyle="fieldErrors" />
		<form:input path="entertainmentProduct.issn" cssStyle="text medium" />	
	</li>
</div>