<%@ include file="/common/taglibs.jsp" %>

<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>

<h1><fmt:message key="catalog.heading" /></h1>
 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
 <script type='text/javascript' src="<c:url value='/dwr/util.js' />"></script>
 <%--  
 <script type="text/javascript" src="<c:url value='/scripts/lightwindow.js'/>"></script>
 --%>
 <script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>

<div id="whole" class="center">
<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
	<div class="subcatalog" id="subcatalog_${catalog.id}">
		<img alt="image holder" src="<c:url value="${catalog.image.thumbPath }" />" 
			onclick="new Effect.Puff('subcatalog_${catalog.id}'); 
				window.setTimeout('Effect.Appear(\'subcatalog_${catalog.id}\', {duration:.3})',4000); 
				document.location='<c:url value="/productlist.html?catalogId=${catalog.id}" />'"
		/>
		<%--
		<a class="product" alt="click here to view all the products related to ${catalog.name }"
				onclick="new Effect.Puff('subcatalog_${catalog.id}'); 
				window.setTimeout('Effect.Appear(\'subcatalog_${catalog.id}\', {duration:.3})',4000); "
				href='<c:url value="/productlist.html?catalogId=${catalog.id}" />' > ${catalog.name}</a>
		--%>
		<div style="display: block; flow: left;">
		${catalog.name }
		<select name="sub" id="sub" onChange="showProduct(this,'products')">
			${pleaseSelect }
			<c:forEach var="grand" items="${catalog.children}">
				<option value="${grand.id }"> ${grand.name }</option>
			</c:forEach>
		</select>
		</div>
	</div>

</c:forEach>
</div>

<div id="productlist" style="visibility:hidden;"> 
	<div id="fade"></div> 
	<div class="popup_product_block"> 
		<div class="popup"> 
			<a href="javascript:hide('productlist');window.location.reload()"><img src="<c:url value="/images/icon_close.png" />" class="cntrl" title="Close" /></a> 
			<table class="table">
				<thead>
				<tr>
					<th><fmt:message key="product.id" /></th>
					<th><fmt:message key="product.name" /></th>
					<th><fmt:message key="product.brandName"/></th>
					<th><fmt:message key="product.description" /></th>
					<th><fmt:message key="product.availability" /></th>
					<th><fmt:message key="product.price" /></th>
					<th><fmt:message key="Add To Cart" /></th>
				</tr>
				</thead>
				<tbody id="products"></tbody>
			</table>
			 
		</div> 
	</div> 
</div> 


<%@ include file="/common/cart.jsp" %>



