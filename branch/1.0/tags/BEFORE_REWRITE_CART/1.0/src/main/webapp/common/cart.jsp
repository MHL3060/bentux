<script type="text/javascript">
	var catalogNode;
	
 	function addItem(pidNodeId, quantityNodeId){

		product = document.getElementById(pidNodeId).value;
		quantity = document.getElementById(quantityNodeId).value;
 	 	if (quantity < 1) {
			alert("Error: The quantity must be greater than 0" );
 	 	}else {
			shoppingCartManager.addItem(${empty user ? -1 : user.id },'${user.username}', product, quantity, 
					function(result) {
						if (result == true ) {
							hide('cart');
							showProduct(catalogNode, 'products');
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
	 
	function show(nodeId, pid) {
		g_pid = pid; 
		if (document.getElementById) { // DOM3 = IE5, NS6
			productManager.getById(pid, function(product) {
				price = product.price;
				if (product.special) {
					price = product.discountPrice;
				}
				titleNode = document.getElementById("product_title");
				titleNode.innerHTML = product.name;
                cell = document.getElementById("available");
                cellText = document.createTextNode(product.availability);
                cell.innerHTML = product.availability;

                cell = document.getElementById("price");
                cellText = document.createTextNode(price);
                cell.innerHTML = price;
                inputNode = document.createElement("input");
                inputNode.name = 'pid';
                inputNode.id = 'pid';
                inputNode.type = 'hidden';
                inputNode.value = product.id;
                node = document.getElementById(nodeId);
                node.appendChild(inputNode);
			}); 
			document.getElementById(nodeId).style.visibility = 'visible'; 
		}
	}
	var cellFuncs = [
		function (product) {
			<c:choose>
			<c:when test="${hasPermission}">
					<c:url var="url" value="/productform.html" />
				return '<a href="${url}?id='+product.id+'">'+product.id+'</a>';
			</c:when>
			<c:otherwise>
				
				return product.id;
			</c:otherwise>
			</c:choose>
			},
		function (product) {return product.name},
		function (product) {return product.brandName.name},
		function (product) {return product.description},
		function (product) {return product.availability},
		
		<c:choose>
			<c:when test="${not empty user}">
				function (product) {return product.price},
				function (product) {
					if (product.availability > 0){
						return '<a href="javascript:show(\'cart\','+product.id+');">Add to Cart</a>'; 
					}else {
						return 'Out of Stock';
					}
				}
			</c:when>
			<c:otherwise>
				function(product) {return "<fmt:message key="member.only" />";},
				function(product) {
					return "<fmt:message key="member.only" />";
				}
			</c:otherwise>
		</c:choose>
	];
	function showProduct(node, toNodeName) {
		try {
			catalogNode = node;
			dwr.util.removeAllRows(toNodeName);
			catalogId = node.value;
			productManager.getProductByCatalogId(catalogId, function(arrayObjs){
				dwr.util.addRows(toNodeName,arrayObjs, cellFuncs,{escapeHtml:false}); 
			});
			document.getElementById("productlist").style.visibility = 'visible'; 
		}catch (exception ) {
			window.location.reload();
		};
	} 
</script>
<style>
div.section { clear: left; }
<<<<<<< .mine
div.subcatalog { 
    float: left; 
	width: 4em; 
	padding: 33px; 
	margin: 1em;
	height: 4em;
    background: #ccc; 
    color:#000; 
    text-align: center; 
    font: verdana, arial, sans-serif;
}
=======

>>>>>>> .r358
div.center{
	float: left;
	/*padding-left: 2em;*/

}
</style>

<div id="cart" style="visibility:hidden;"> 
	<div class="fade"></div> 
	<div class="popup_block"> 
		<div class="popup"> 
			<a href="javascript:hide('cart')"><img src="<c:url value="/images/icon_close.png" />" class="cntrl" title="Close" /></a> 
			<h3 id="product_title"></h3>
			<table id="product_data">
				<tr>
					<td class="strong">Available :</td>
					<td id="available"></td>
				</tr>
				<tr>
					<td class="strong">Price :</td>
					<td id="price"></td>
				</tr>
				<tr>
					<td colspan="2"> Add <input id="quantity" name="quantity" value="1" type="text" size="3" maxlength="3" />  to my cart  </td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" name="add" value="Add" onclick="addItem('pid', 'quantity')"/></td>
				</tr>
			</table>
			 
		</div> 
	</div> 
</div> 
