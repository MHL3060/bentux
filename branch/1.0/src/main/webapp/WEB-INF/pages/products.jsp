<%@ include file="/common/taglibs.jsp" %>
<c:set var="button">
	<input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/productform.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>
 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
 <%--  
 <script type="text/javascript" src="<c:url value='/scripts/lightwindow.js'/>"></script>
 --%>
 <script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>
 
 <%--
 <script type="text/javascript">
	
 	function addItem(pidNodeId, quantityNodeId){

		product = document.getElementById(pidNodeId).value;
		quantity = document.getElementById(quantityNodeId).value;
 	 	if (quantity < 1) {
			alert("Error: The quantity must be greater than 0" );
 	 	}else {
			shoppingCartManager.addItem(${user.id},'${user.username}', product, quantity, 
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
</script>
 --%>
<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>
<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>
<display:table id="tuxBaseObjectList" name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table uutResultList" export="true" >
	<c:if test="${hasPermission }">
		<display:column titleKey="id" property="id" url="/productform.html" paramId="id" 
			paramProperty="id" />
	</c:if>
	<display:column titleKey="product.image">
		<a href="<c:url value="${tuxBaseObjectList.firstImage.path}"/>" rel="lightbox" title="">
			<img src="<c:url value="${tuxBaseObjectList.firstImage.thumbPath}"  />" title="<fmt:message key="click.enlarge" />" />
		</a>
	</display:column>
	<display:column property="brandName.name" titleKey="product.brandName.name" sortable="true" />
	<display:column property="name" titleKey="product.name" sortable="true" />
	<display:column property="description" titleKey="product.description" maxWords="50" />
	<display:column property="availability" titleKey="product.availability" />
	<c:if test="${hasPermission }">
		<display:column titleKey="product.add.image">
			<c:url var="imageUrl" value="/imageform.html">
				<c:param name="pid" value="${tuxBaseObjectList.id }" />
			</c:url>
			<a href="${imageUrl}"><fmt:message key="add.image" /></a>
		</display:column>
	</c:if>
	<display:column titleKey="more.info" >
		<c:url var="url" value="/productdetail.html">
			<c:param name="id"  value="${tuxBaseObjectList.id}" />
		</c:url>
		<a href="${url }" ><fmt:message key="more.info" /></a>
	</display:column>
	<display:column titleKey="add.cart">
		<c:if test="${user != null && tuxBaseObjectList.availability > 0 }">
		
			<c:url var="url" value="/additem.html">
				<c:param name="pid" value="${tuxBaseObjectList.id }" />
			</c:url>
			<a href="javascript:show('cart', ${tuxBaseObjectList.id});"><fmt:message key="add.to.cart" /></a>
		</c:if>
	</display:column>
	
</display:table>
<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>

<div id="cart" style="visibility:hidden;"> 
	<div id="fade"></div> 
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



