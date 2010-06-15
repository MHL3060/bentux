<%@ include file="/common/taglibs.jsp" %>

<form:form commandName="shoppingCart" method="post" action="cartform.html">
	<form:hidden path="id"/>
	<ul>
		<li>
			<strong>Order ID:</strong> ${shoppingCart.id }
		</li>
		<li>
			<strong>User :</strong> ${shoppingCart.user.firstName } ${shoppingCart.user.lastName }
		</li>
		<li>
			<div class="left">
				<h3>Shipping Address:</h3>
				${shoppingCart.shippingAddress.address.address} <br />
				${shoppingCart.shippingAddress.address.city}<br />
			
			</div>
			<div>
				<h3>Billing Address:</h3>
				${shoppingCart.user.address.address }<br />
				${shoppingCart.user.address.city } <br />
			</div>
		</li>
		<li>
			<display:table name="${shoppingCart.shoppingItems}" style="table shoppingItem">
				<display:column property="product.name" />
				<display:column property="product.price" />
				<display:column property="quantity" />
				<display:column property="total" />
			</display:table>
		
		</li>
		<li>
			<strong>Status :</strong>
			<form:select path="status">
				<form:options items="${statuses}"/>
			</form:select>
		<input type="submit" name="update" value="update" />
	</ul>



</form:form>