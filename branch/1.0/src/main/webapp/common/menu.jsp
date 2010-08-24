<%@ include file="/common/taglibs.jsp"%>

<div class="heading">
		Welcome to Trinity, Taste of India
</div>  
	
<menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
     <%-- these are not the errors. stupid Eclipse doesn't know how to handle EL. --%>
       	   
	<div id="nav"> 
  
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
     	<a href="<c:url value="/subcatalogs.html"/>" class="${pageContext.request.requestURI == '/subcatalogs.html' ? 'current' : '' }" >
     		<fmt:message key="product.menu" />
     	</a>
     </li>
     <li>
    	<a href="<c:url value="/catalogs.html"/>" class="${pageContext.request.requestURI == '/catalogs.html' ? 'current' : '' }" >
     		<fmt:message key="catalog.menu" />
     	</a>
     
     </li>
     <!--  Not yet implemented yet, just started the basic interface -->    
     <li>
     	<a href="<c:url value="/special.html"/>" class="${pageContext.request.requestURI == '/special.html' ? 'current' : '' }" >
     		<fmt:message key="special.menu" />
     	</a>
     </li>
   	 <!--  Not yet implemented yet -->
     <li>
     	<a href="<c:url value="/event.jsp"/>" class="${pageContext.request.requestURI == '/event.jsp' ? 'current' : '' }" >
     		<fmt:message key="event.menu" />
     	</a>
     </li>
     <!--  Movie Page -->
     <li>
     	<a href="<c:url value="/movie.jsp"/>" class="${pageContext.request.requestURI == '/movie.jsp' ? 'current' : '' }" >
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
     <!-- This will be gone by the offical first release -->
  
    <li>
    	<a href="<c:url value="/faq.html"/>" class="${pageContext.request.requestURI == '/faq.html' ? 'current' : '' }" >
     		<fmt:message key="faq.menu" />
     	</a>
     </li>
      
    <li>
     	<a href="<c:url value="/search.html"/>" class="${pageContext.request.requestURI == '/search.html' ? 'current' : '' }" >
     	    	<fmt:message key="search.menu" />
     	</a>
     </li>
     <menu:displayMenu name="AdminMenu"/>
    
     <li>
          <div class ="search">
          Site Search
	          <form method="get" action="#">
				<input type="text" size="15" name="s" id="search-text" value="" />&nbsp;<input type="image" id="search-submit" src="/images/common/search_button.png" height="21" width="21" align="absmiddle" />
			   </form>
		  </div>
	 </li>
	 
	     <div class= "partners">
	         <a href="http://www.facebook.com/group.php?gid=111666002279&ref=mf"><img src="<c:url value="/images/facebook_logo.png"/>" width="130" height="48" alt="facebook"></img></a>
	     </div>

		 <div class="share">
             <a href="http://www.facebook.com/group.php?gid=111666002279&ref=mf"><img src="<c:url value="/images/common/add_facebook.png"/>" width="20" height="20" align="absmiddle"  alt="add"></img></a>&nbsp;Share with Friends
   	     </div>
    <!-- <menu:displayMenu name="Logout"/> -->
   </div>
</ul>
</menu:useMenuDisplayer>
