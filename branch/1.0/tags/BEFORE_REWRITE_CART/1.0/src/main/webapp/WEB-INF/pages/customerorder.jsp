<%@ include file="/common/taglibs.jsp" %>

<h1>
	<fmt:message key="customer orders" />
	
	<display:table id="tuxBaseObjectList" name="tuxBaseObjectList" class="table tuxBaseObjectList">
		<display:column  property="id" titleKey="cart.id" href="items.html" paramId="id" paramProperty="id" />
		<display:column sortProperty="user.username" titleKey="cart.username" >
			${tuxBaseObjectList.user.firstName } ${tuxBaseObjectList.user.lastName }
		</display:column>
		<display:column property="shoppingItems.size" titleKey="cart.item.count" />
		<display:column property="status" titleKey="cart.status" />
		
	</display:table>
</h1>


