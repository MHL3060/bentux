<%@include file="/common/taglibs.jsp" %>

<h1>
	<fmt:message key="view.orders" />
</h1>

<display:table id="orders" name="orders" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table uutResultList" export="true">

	<display:column titleKey="order.id" url="/items.html" paramId="id" paramProperty="id" />
	<display:column property="user.username" titleKey="user.name"/>
	<display:column property="startDate" titleKey="ordered.date" format="{0,date,dd-MMM-yyyy}" sortable="true"/>
	<display:column property="status" titleKey="order.status" sortable="true" />
	<display:column titleKey="item.count">
		${fn:length(orders.shoppingItems)}
	</display:column>

</display:table>