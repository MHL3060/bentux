<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
     <%-- these are not the errors. stupid Eclipse doesn't know how to handle EL. --%>
     <li>
     	<a href="<c:url value="/special.html"/>" class="${pageContext.request.requestURI == '/special.html' ? 'current' : '' }" >
     		<fmt:message key="special.product" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/productlist.html"/>" class="${pageContext.request.requestURI == '/productlist.html' ? 'current' : '' }" >
     		<fmt:message key="product.list" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/contact_us.jsp"/>" class="${pageContext.request.requestURI == '/contact_us.jsp' ? 'current' : '' }" >
     		<fmt:message key="contact.list" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/links.jsp"/>" class="${pageContext.request.requestURI == '/links.jsp' ? 'current' : '' }" >
     		<fmt:message key="link.list" />
     	</a>
     </li>
    <menu:displayMenu name="AdminMenu"/>
    <li><a href="<c:url value="/about_us.jsp"/>" class=" ${pageContext.request.requestURI == '/about_us.jsp' ? 'current' : '' }" ><fmt:message key="about.us" /></a></li>
    <menu:displayMenu name="Logout"/>
</ul>
</menu:useMenuDisplayer>
