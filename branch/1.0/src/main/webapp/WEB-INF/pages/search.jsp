<%@ include file="/common/taglibs.jsp"%>

<P>
 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
 <script type='text/javascript' src="<c:url value='/dwr/util.js' />"></script>
<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>
<H2>Product Search:</H2>

<FORM method="GET"><spring:bind path="command.query">
	<INPUT type="text" size="20" name="query"
		value="<c:out value="${status.value}"/>" />
</spring:bind> <INPUT type="submit" value="Search" /></FORM>

<display:table id="tuxBaseObjectList" name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table " export="true" >

	<display:column property="brandName.name" titleKey="product.brandName.name" sortable="true" />
	<display:column property="name" titleKey="product.name" sortable="true" />
	<display:column property="description" titleKey="product.description" maxWords="50" />
	<display:column property="availability" titleKey="product.availability" />
	<display:column property="price" titleKey="product.price" />
	<display:column titleKey="more.info" >
		<c:url var="url" value="/productdetail.html">
			<c:param name="id"  value="${tuxBaseObjectList.id}" />
		</c:url>
		<a href="${url }" ><fmt:message key="more.info" /></a>
	</display:column>
	<display:column>
		<c:choose>
			<c:when test="${tuxBaseObjectList.availability > 0}">
					<a href="javascript:show('cart','${tuxBaseObjectList.id}');">Add to Cart</a>; 
			</c:when>
			<c:otherwise>
				Out of Stock
			</c:otherwise>
		</c:choose>
	</display:column>	
</display:table>


<%@ include file="/common/cart.jsp" %>