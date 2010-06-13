<%@include file="/common/taglibs.jsp" %>

 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
<script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/util.js' />"></script>

<script type="text/javascript">
	
 	function addItem(pidNodeId, quantityNodeId){

		product = document.getElementById(pidNodeId).value;
		quantity = document.getElementById(quantityNodeId).value;
 	 	if (quantity < 1) {
			alert("Error: The quantity must be greater than 0" );
 	 	}else {
			shoppingCartManager.addItem(-1,'admin', product, quantity, 
					function(result) {
						if (result == true ) {
							hide('cart');
							window.location.reload();
						}else {
	
						}
						
					}																
				); 
 	 	}
 	}
	function popup(pid, toNodeId) {
		toNode = document.getElementById(toNodeId);
		productManager.getById(pid, function(product) {
			var ul = toNode.createNode('ul');
			var li = ul.createElement('li');
			li.innerText = product.name;
			li = ul.createElement('li');
			li.innerText = product.availibility;
			
		});
		myLightWindow.createWindow(toNodeId);
	}
	function hide(nodeId) { 
		if (document.getElementById) { // DOM3 = IE5, NS6 
			
			document.getElementById(nodeId).style.visibility = 'hidden'; 
		}
	}
	 
	function show(nodeId, oid) {
		g_pid = oid; 
		if (document.getElementById) { // DOM3 = IE5, NS6
			shoppingCartManager.getItemsByCartId("${username}",oid, function(cart){
				addRows(cart);
			});

					
			document.getElementById(nodeId).style.visibility = 'visible'; 
		}
	}
	var cellFunc = [
	            	function(data) {return data.product.name; },
	            	function(data) {return data.quantity; },
	            	function(data) {return data.product.price},
	            	function(data) {return data.total;}
	            ];

	function addRows(objects){
		//http://directwebremoting.org/dwr/browser/util/tables.html
		dwr.util.addRows("items", objects, cellFunc, {escapeHtml:false});

	}             	 
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
		<a href="javascript:showOrderDetail(orderDetail,${orders.id});"><fmt:message key="view.order.detail" /></a> <br/>
		<a href="javascript:show('orderDetail',${orders.id});"><fmt:message key="add.to.cart" /></a>
	</display:column>
</display:table>


<div id="orderDetail" style="visibility:hidden;"> 
	<div id="fade"></div> 
	<div class="popup_block"> 
		<div class="popup"> 
			<a href="javascript:hide('orderDetail')"><img src="<c:url value="/images/icon_close.png" />" class="cntrl" title="Close" /></a> 
			<h3 id="product_title"><fmt:message key="shopping.items" /></h3>
			<table id="product_data" class="table">
				<thead>
				<tr>
					<th class="strong"><fmt:message key="product.name" /></th>
					<th class="strong"><fmt:message key="order.quantity" /></th>
					<th class="strong"><fmt:message key="product.price" /></th>
					<th class="Strong"><fmt:message key="product.total" /></th>
				</tr>
				</thead>
				<tbody id="items">
					
				</tbody>
			</table>
			 
		</div> 
	</div> 
</div> 