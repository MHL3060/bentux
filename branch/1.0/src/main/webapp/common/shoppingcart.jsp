<%@ include file="taglibs.jsp" %>

<div id="shopping_cart">
	<ul>
		<li><a href="<c:url value="cart.html" />"></strong><img src="<c:url value="/images/img_cart.gif"/>" width="20"
									height="18" alt="cart"></img>
		</li>
		<li><fmt:message key="view.cart" /></a></li>
		<li class="label"><fmt:message key="cart.item.count" /> :</li>
		<li id="item_count">${cart_item_count}</li>
		<li class="label"><fmt:message key="cart.sub.total" /> : $</li>
		<li id="item_total">${cart_sub_total}</li>
	</ul>
</div>