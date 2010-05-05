<%@ include file="/common/taglibs.jsp" %>

<c:choose>
	<c:when test="${emptyCart}">
		<h1>		

			<fmt:message key="empty.cart" />
		</h1>
		<p>
			<fmt:message key="please.add.item.to.cart" />
		</p>
	</c:when>
	<c:otherwise>



		<div class="group">
			<label class="desc"><fmt:message key="user.billing.address"/></label>
			<div class="left">${shippingAddress.user.firstName }</div>	
			<div>${shippingAddress.user.lastName }</div>
			<div>${shippingAddress.user.address.address }</div>
			<div class="left">${shippingAddress.user.address.city }</div>
			<div>${shippingAddress.user.address.province }</div>
			<div class="left">${shippingAddress.user.address.postalCode }</div>
			<div>${shippingAddress.user.address.country }</div>
		</div>
		
		<div>
			<label class="desc"><fmt:message key="user.shipping.address"/></label>
			<div class="left">${shippingAddress.firstName }</div>	
			<div>${shippingAddress.lastName }</div>
			<div>${shippingAddress.address.address }</div>
			<div class="left">${shippingAddress.address.city }</div>
			<div>${shippingAddress.address.province }</div>
			<div class="left">${shippingAddress.address.postalCode }</div>
			<div>${shippingAddress.address.country }</div>
		</div>
		
		
		<form:form commandName="confirmItem" >
		<c:set var="buttons" >
		    <li class="buttonBar bottom">
		        <input type="submit" class="button" name="edit" value="<fmt:message key="button.edit"/>"/>
		        <input type="submit" class="button" name="submit" value="<fmt:message key="button.submit"/>"/>        
		        </li>
		</c:set>
		<div>
			<label class="desc"><fmt:message key="order.items"/></label>
				<display:table id="cartItems" name="cartItems"  class="table items">
				<display:column property="product.name" titleKey="product.name" />
				<display:column property="quantity" titleKey="product.quantity" />
				<display:column property="product.price" titleKey="product.price" />
				
			</display:table>
		</div>
		<li>
			<c:out value="${buttons}" escapeXml="false" />
		</li>
		</form:form>
	</c:otherwise>
</c:choose>
