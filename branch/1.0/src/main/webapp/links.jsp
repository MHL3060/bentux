<%@ include file="/common/taglibs.jsp" %>

<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>

<h1><fmt:message key="link.page" /></h1>

<p>
Link info
</p>