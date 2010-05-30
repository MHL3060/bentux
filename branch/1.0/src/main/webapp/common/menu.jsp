<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
     <%-- these are not the errors. stupid Eclipse doesn't know how to handle EL. --%>
     
	<div id="vertmenu"> 


     <li>
     	<a href="<c:url value="/home.html"/>" class="${pageContext.request.requestURI == '/home.html' ? 'current' : '' }" >
     		<fmt:message key="home.list" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/special.html"/>" class="${pageContext.request.requestURI == '/special.html' ? 'current' : '' }" >
     		<fmt:message key="special.product" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/catalogs.html"/>" class="${pageContext.request.requestURI == '/catalogs.html' ? 'current' : '' }" >
     		<fmt:message key="main.catalog.list" />
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
    <li>
    	<a href="<c:url value="/about_us.jsp"/>" class=" ${pageContext.request.requestURI == '/about_us.jsp' ? 'current' : '' }" >
    	<fmt:message key="about.us" />
    </a>
    </li>
         <li>
     	<a href="<c:url value="/search.html"/>" class="${pageContext.request.requestURI == '/search.html' ? 'current' : '' }" >
     	    	<fmt:message key="search.page" />
     	</a>
     </li>
     
    <menu:displayMenu name="Logout"/>
   </div>
</ul>
</menu:useMenuDisplayer>
