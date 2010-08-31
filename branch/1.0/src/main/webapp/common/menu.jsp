<%@ include file="/common/taglibs.jsp"%>

<div class="heading">
		Welcome to Trinity, Taste of India!
</div>  

<menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">

<ul id="primary-nav" class="menuList">
     <%-- these are not the errors. stupid Eclipse doesn't know how to handle EL. --%>
       	   
	 
  
     <li>
     	<a href="<c:url value="/home.html"/>" class="${pageContext.request.requestURI == '/home.html' ? 'current' : '' }" >
     		<fmt:message key="home.menu" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/about_us.jsp"/>" class=" ${pageContext.request.requestURI == '/about_us.jsp' ? 'current' : '' }" >
    	<fmt:message key="about.us.menu" />
   		</a>
     </li>
     <!--  product page -->
     <li>
     	<a href="<c:url value="/catalogs.html"/>" class="${pageContext.request.requestURI == '/subcatalogs.html' ? 'current' : '' }" >
     		<fmt:message key="product.menu" />
     	</a>
     </li>
     <!-- 
     <li>
    	<a href="<c:url value="/catalogs.html"/>" class="${pageContext.request.requestURI == '/catalogs.html' ? 'current' : '' }" >
     		<fmt:message key="catalog.menu" />
     	</a>
     
     </li>
      -->
     <!--  Not yet implemented yet, just started the basic interface, will not included in the first phrase -->
     <!--     
     <li>
     	<a href="<c:url value="/special.html"/>" class="${pageContext.request.requestURI == '/special.html' ? 'current' : '' }" >
     		<fmt:message key="special.menu" />
     	</a>
     </li>
      -->
   	 <!--  Not yet implemented yet -->
     <li>
     	<a href="<c:url value="/event.jsp"/>" class="${pageContext.request.requestURI == '/event.jsp' ? 'current' : '' }" >
     		<fmt:message key="event.menu" />
     	</a>
     </li>
     <!--  Movie Page -->
     <li>
     	<a href="<c:url value="/movie.html"/>" class="${pageContext.request.requestURI == '/movie.html' ? 'current' : '' }" >
     		<fmt:message key="movie.menu" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/our_store.jsp"/>" class="${pageContext.request.requestURI == '/our_store.jsp' ? 'current' : '' }" >
     		<fmt:message key="our.store.menu" />
     	</a>
     </li>
     <li>
     	<a href="<c:url value="/contact_us.jsp"/>" class="${pageContext.request.requestURI == '/contact_us.jsp' ? 'current' : '' }" >
     		<fmt:message key="contact.us.menu" />
     	</a>
     </li>
 
    <li>
    	<a href="<c:url value="/faq.html"/>" class="${pageContext.request.requestURI == '/faq.html' ? 'current' : '' }" >
     		<fmt:message key="faq.menu" />
     	</a>
     </li>
    
    <!-- Not included in the first release -->  
    <!--
    <li>
     	<a href="<c:url value="/search.html"/>" class="${pageContext.request.requestURI == '/search.html' ? 'current' : '' }" >
     	    	<fmt:message key="search.menu" />
     	</a>
     </li>
     -->
     <menu:displayMenu name="AdminMenu"/>
    <li>
	     <div style="margin-top: 8px; margin-bottom: 5px; height: 26px; width: 100%; overflow: hidden; padding: 0;" >
		 	<a style="display: inline" href="http://www.facebook.com/group.php?gid=111666002279&ref=mf">
		 		<img src="<c:url value="/images/common/add_facebook.png"/>" alt="add_facebook" />
		 	</a>
		 	<a  style="display: inline" href="http://www.twitter.com">
		 		<img src="<c:url value="/images/common/add_twitter.png"/>" alt="add_twitter" />
			</a>
			<a  style="display: inline" href="http://www.twitter.com">
				<!--  hack. this image is too big for this -->
				<img src="<c:url value="/images/common/share_friends.png"/>" alt="share" />
			</a>
	     </div>
		 <div class="advertise">
             <img src="<c:url value="/images/common/advertise.png"/>" width="145" height="70" alt="advertise"/>
   	     </div>
   	</li>
    <!-- <menu:displayMenu name="Logout"/> -->
  
</ul>

</menu:useMenuDisplayer>
