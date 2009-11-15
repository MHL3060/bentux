<%@ include file="/common/taglibs.jsp"%>

<head>
    <meta name="menu" content="Home"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/layout-home.css'/>" />
</head>
<div id="wrapper">
	<div id="mainPage">
		<div id="main-title"> Taste Of India's Online Store</div>
		<div id="page-bgtop">
		<div id="page-bgbtm">
		<div id="left-main">
			
			<div class="main-banner">
				<img src="<c:url value="/images/sample-banner.gif"/>" width="620" height="90" alt="trinity group" ></img>			
			</div> 			
			<c:forEach var="news" items="${tuxBaseObjectList}">
			<div class="post">
				 	
				<h1 class="title">${news.title}</h1>					
				<p class="meta"><span class="date"><fmt:formatDate value="${news.addedOn}" pattern="${datePattern}"/></span><span class="posted">Posted by <a href="#">${news.user.firstName } ${news.user.lastName }</a></span>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
					<c:out value="${news.contentBody}" escapeXml="false" />
					<div class="links">
						<a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a>
						<c:if test="${(pageContext.request.remoteUser == news.user.username) || (hasPermission)}">
							<c:url var="url" value="/newsform.html">
								<c:param name="id" value="${news.id}" />	
							</c:url>
							| <a href="${url }">Edit</a>
						</c:if>
					</div>
				</div>		
			</div>
			</c:forEach>
			<c:if test="${empty tuxBaseObjectList }">
				<c:if test="${hasPermission }">
					<div class="links"> No News Found.<a href="<c:url value="/newsform.html" />" >Add One</a></div>
				</c:if>
			</c:if>	
		<div style="clear: both;">&nbsp;</div>
		</div>
	
	<div id="sidebar">
		<ul>
			<li>
				<div id="search" >
					<form method="get" action="/search.html">
						<div>
							<input type="text" name="query" id="search-text" value="" />
							<input type="submit" id="search-submit" value="GO" />
						</div>
					</form>				
				</div>
				<div style="clear: both;">&nbsp;</div>				
			</li>
			<li>
				<h2>Features Product</h2>
				<p>Coca Cola Zero X Neighorhood</p>
			</li>
			<li>
				<h2>Main Categories</h2>
				<ul>
						<li><a href="#">Snacks</a></li>
						<li><a href="#">Drinks</a></li>
						<li><a href="#">Movies</a></li>
						<li><a href="#">Dried Fruits</a></li>
						<li><a href="#">Rice/Noodles</a></li>
				</ul>
			</li>
			<li>
				<p><img src="<c:url value="/images/sample-banner2.jpg"/>" width="170" height="100" alt="trinity group" ></img></p>	
				
			</li>	
		</ul>
		</div>
	<!-- end #sidebar -->
	<div style="clear: both;">&nbsp;</div>

		<!-- end #content -->
	
	<!-- end #page -->
	</div>
	</div>
	</div>
</div>
<!-- end #footer -->
</body>
