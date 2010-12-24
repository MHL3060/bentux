<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
var catalog;
	
 	function addItem(pidNodeId, quantityNodeId){

		var product = document.getElementById(pidNodeId).value;
		var quantity = document.getElementById(quantityNodeId).value;
 	 	if (quantity < 1) {
			alert("Error: The quantity must be greater than 0" );
 	 	}else {
			shoppingCartManager.addItem(${empty user ? -1 : user.id },'${user.username}', product, quantity, 
					function(result) {
						if (result == true ) {
							hide('cart');
							showProduct(catalog, 'products');
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
		var price = 0;
		if (document.getElementById) { // DOM3 = IE5, NS6
			
			productManager.getById(pid, function(product) {
				
				
				price = "" + product.price;
				
				if (product.special) {
					price = product.discountPrice;
				}
				
				titleNode = document.getElementById("product_title");
				
				titleNode.value = product.name;
                cell = document.getElementById("available");
                //cellText = document.createTextNode(product.availability);
                cell.innerHTML = product.availability;
				
                cell = document.getElementById("price");
                //cellText = document.createTextNode(price);
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
		function (product) {
			if (product.brandName) {
				return product.brandName.name;
			}else {
				return "";
			}
		},
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
	function showProduct(catalogId, toNodeName) {
		try {
			catalog = catalogId;
			dwr.util.removeAllRows(toNodeName);
		
			productManager.getProductByCatalogId(catalogId, function(arrayObjs){
				dwr.util.addRows(toNodeName,arrayObjs, cellFuncs,{escapeHtml:false}); 
			});
			document.getElementById("productlist").style.visibility = 'visible'; 
		}catch (exception ) {
			window.location.reload();
		};
	} 

</script>