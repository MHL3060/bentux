<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
     <li><a href="<c:url value="/productlist.html"/>" class="${pageContext.request.requestURI == '/productlist.html' ? 'current' : '' }" ><fmt:message key="proudct.list" /></a></li>
    <menu:displayMenu name="AdminMenu"/>
    <li><a href="<c:url value="/about_us.jsp"/>" class=" ${pageContext.request.requestURI == '/about_us.jsp' ? 'current' : '' }" ><fmt:message key="about.us" /></a></li>
    <menu:displayMenu name="Logout"/>
</ul>
</menu:useMenuDisplayer>
