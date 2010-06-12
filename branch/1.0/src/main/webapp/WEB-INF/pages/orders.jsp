<%@include file="/common/taglibs.jsp" %>

 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
<script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>

<script type="text/javascript">
function hide(nodeId) { 
	if (document.getElementById) { // DOM3 = IE5, NS6 
		
		document.getElementById(nodeId).style.visibility = 'hidden'; 
	}
}
 
function showOrderDetail(nodeId, oid) {

	shoppingCartManager.get(oid, addRows(objects){
		//http://directwebremoting.org/dwr/browser/util/tables.html
		dwr.util.addRows("items", objects.shoppingItems, cellFunc, {escapeHtml:false });

	}); 

	
}

var cellFunc = [
	function(data) {return data.product.name; },
	function(data) {return quantity; },
	function(data) {return total;}
];




</script>
<h1>
	<fmt:message key="view.orders" />
</h1>


<display:table id="orders" name="orders" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table uutResultList" export="true">

	<display:column property="id" titleKey="order.id" url="/items.html" paramId="id" paramProperty="id" />
	<display:column property="user.username" titleKey="user.name"/>
	<display:column property="startDate" titleKey="ordered.date" format="{0,date,dd-MMM-yyyy}" sortable="true"/>
	<display:column property="status" titleKey="order.status" sortable="true" />
	<display:column titleKey="item.count">
		${fn:length(orders.shoppingItems)}
	</display:column>
	<display:column titleKey="item.detail">
		<a href="/orders.html" onclick="showOrderDetail(orderDetail,${orders.id})"><fmt:message key="view.order.detail" /></a>
	</display:column>
</display:table>

<div id="orderDetail" style="visibility:hidden;">
	
	<div id="fade"></div> 
	<div class="popup_block"> 
		<div class="popup"> 
			<a href="javascript:hide('orderDetail')"><img src="<c:url value="/images/icon_close.png" />" class="cntrl" title="Close" /></a> 
			<h3 id="product_title"></h3>
			<table id="order_detail_data">
				<tr>
					<td class="strong"><fmt:message key="product.name" /> :</td>
					<td class="strong"><fmt:message key="order.quantity" /> :</td>
					<td class="strong"><fmt:message key="product.price" /> :</td>
				</tr>
				<tbody id="items">
					
				</tbody>
			</table>
			 
		</div> 
	</div> 


</div>