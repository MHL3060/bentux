<%@ include file="/common/taglibs.jsp" %>
<div id="entertain_product">
<li>
	<div class="left">
		<appfuse:label key="product.entertainmentProduct.imdb_link" styleClass="desc" />
		<form:errors path="entertainmentProduct.imdbLink" cssStyle="fieldErrors" />
		<form:input path="entertainmentProduct.imdbLink" cssStyle="text medium" />	
	</div>
</li>
</div>