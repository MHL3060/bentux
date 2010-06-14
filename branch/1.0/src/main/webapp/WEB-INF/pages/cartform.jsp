<%@ include file="/common/taglibs.jsp" %>

<form:form commandName="shoppingCart">
	<form:hidden path="id"/>
	<ul>
		<li>
			<strong>Order ID:</strong> ${shoppingCart.id }
		</li>
		<li>
			<strong>User :</strong> ${shoppingCart.user.firstName } ${shoppingCart.user.lastName }
		</li>
		<li>
			<strong>Status :</strong>
			<form:select path="status">
				<form:options items="${statuses}"/>
			</form:select>
		<input type="submit" name="update" value="update" />
	</ul>



</form:form>