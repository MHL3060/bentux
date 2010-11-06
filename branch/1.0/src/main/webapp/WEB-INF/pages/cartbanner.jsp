<%@ include file="/common/taglibs.jsp" %>

<div id="shopping_cart">
		<ul>
			<!-- <li><a href="<c:url value="cart.html" />"><img src="<c:url value="/images/img_cart.gif"/>" width="20"
										height="10" align="absmiddle" alt="cart"></img>-->
			
			<li><a href="<c:url value="cart.html" />"><fmt:message key="view.cart" /></a></li>
			<li class="label"><fmt:message key="cart.item.count" /> :</li>
			<li id="item_count">${cart_item_count}</li>
			<li class="label"><fmt:message key="cart.sub.total" /> : $</li>
			<li id="item_total">${cart_sub_total}</li>
	    </ul>
</div>
