<%@ include file="/common/taglibs.jsp" %>

<div class="group">
	<label class="desc"><fmt:message key="user.billing.address"/></label>
	<div class="left">${shippingAddress.user.firstName }</div>	
	<div>${shippingAddress.user.lastname }</div>
	<div>${shippingAddress.user.address.address }</div>
	<div class="left">${shippingAddress.user.address.city }</div>
	<div>${shippingAddress.user.address.province }</div>
	<div class="left">${shippingAddress.user.address.postalCode }</div>
	<div>${shippingAddress.user.address.country }</div>
</div>

<div>
	<label class="desc"><fmt:message key="user.shipping.address"/></label>
	<div class="left">${shippingAddress.firstName }</div>	
	<div>${shippingAddress.lastname }</div>
	<div>${shippingAddress.address.address }</div>
	<div class="left">${shippingAddress.address.city }</div>
	<div>${shippingAddress.address.province }</div>
	<div class="left">${shippingAddress.address.postalCode }</div>
	<div>${shippingAddress.address.country }</div>
</div>

<div>
	<label class="desc"><fmt:message key="order.items"/></label>
	<display:table id="cartItems" name="cartItems">
		<display:column property="product.name" titleKey="product.name" />
		<display:column property="product.quantity" titleKey="product.quantity" />
		<display:column property="product.price" titleKey="product.price" />
		
	</display:table>
</div>
