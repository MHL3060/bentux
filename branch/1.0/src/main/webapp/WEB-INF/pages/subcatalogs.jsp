<%@ include file="/common/taglibs.jsp" %>


 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
 <script type='text/javascript' src="<c:url value='/dwr/util.js' />"></script>
 <%--  
 <script type="text/javascript" src="<c:url value='/scripts/lightwindow.js'/>"></script>
 --%>
 <script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>
<style>
div.subcatalog-center{
	width: 100%;
	float: left;
	color: grey;
	letter-spacing: 2px;
	margin-top:10px;
}

div.heading li a {
    display: block;
    font-weight: normal;
    text-decoration: none;
    letter-spacing: 1px;
    font-size: 18px;
    margin: 0;
    padding: 5px;
    height: 17px;
    color: green;
	background: #fff;
}

div#nav li a:hover, div#nav li a.current {   
   	color: orange;
   	font-weight: bold;
	background: #fff;
	text-transform: uppercase;
}
div.subcatalog-new_line {
   	margin-top: 8px;
   	border-top: 1px dotted orange;
	width: 100%;
}

.breadcomb {
   font-size: 1.1em;
   font-weight: bold;
   margin: 0px;
   padding : 0px;
   white-space:nowrap;
   list-style-type: none;   
}

.breadcomb li {
   display: inline;
}
 
.breadcomb li.current {
   color: #fd8719;

}  
</style>


	<div class="subcatalog-center">
		<ul class="breadcomb">
		<c:forEach var="catalog" items="${catalogs}">
			<c:if test="${catalog.id != -3 }">
				<li ${param.pid == catalog.id ? 'class="current"' : '' }>
					<c:url var="url" value="/subcatalogs.html">
						<c:param name="pid" value="${catalog.id}"/>
					</c:url>
					/ <a href="${url }"> ${catalog.name } </a> 
				</li>
				<li ${param.pid == catalog.id ? 'class="current"' : '' }>
					<c:url var="url" value="/subcatalogs.html">
						<c:param name="pid" value="${catalog.id}"/>
					</c:url>
					/  
				</li>
			</c:if>
		</c:forEach>
		</ul>
		<div class="subcatalog-new_line"></div>
	</div>

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
			<select name="sub" id="sub_${catalog.id}" onChange="showProduct(this,'products')">
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



