<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="Home" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-home.css'/>" />
</head>

<div id="wrapper">
	<div id="main-title">Taste of India's Online Store</div>
		<div id="main-banner"><img src="<c:url value="/images/sample_banner.gif"/>" width="620" height="90" alt="trinity group"></img></div>
			<div id="right-sidebar">
				<img src="<c:url value="/images/sample_banner_06.gif"/>" width="150"
				height="90" alt="trinity group"></img>
				</div>
				
				<div style="clear: both;">&nbsp;</div>
				<div id="leftside">
				
				<h2 class="hide">Menu:</h2>
				
				<ul class="avmenu">
					<li><a class="current" href="catalogs.html">Categories</a>
					<ul>
						<li><a href="subcatalogs.html?pid=-1">Foods</a></li>
						<li><a href="subcatalogs.html?pid=-4">Cultural</a></li>
						<li><a href="subcatalogs.html?pid=-2">Entertainment</a></li>
					</ul>
					</li>
				</ul>
				<a href="http://www.facebook.com/group.php?gid=111666002279&ref=mf"><img src="<c:url value="/images/facebook_2.jpg"/>" width="140" height="50" alt="trinity group on facebook"></img></a>
		
				
				<div class="announce">
				<h2>List Of Festivals:</h2>
				<p><strong>Apr 24, 2008:</strong><br />
				Refreshed: v3.0!</p>
				<p><strong>Jan 11, 2007:</strong><br />
				Improved: v2.5!</p>
				<p><strong>June 25, 2006:</strong><br />
				Major upgrade: v2.0.</p>
				<p><strong>June 25, 2005:</strong><br />
				First release: v1.0.</p>
				<p class="textright"><a href="#">More Festivals &raquo;</a></p>
				</div>
				
				<img src="<c:url value="/images/sample_banner2.jpg"/>" width="140" height="100" alt="trinity group"></img></div>
		
		<div id="page-bgtop">
		<div id="page-bgbtm">
		<div id="center-main">
		
	
		
		<c:forEach var="news" items="${tuxBaseObjectList}">
			<div class="post">
			<h1 class="title">${news.title}</h1>
			<p class="meta"><span class="date"><fmt:formatDate
				value="${news.addedOn}" pattern="${datePattern}" /></span><span
				class="posted">Posted by <a href="#">${news.user.firstName
			} ${news.user.lastName }</a></span>
			<div style="clear: both;">&nbsp;</div>
			<div class="entry"><c:out value="${news.contentBody}"
				escapeXml="false" />
			<div class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="#">Comments</a> <c:if
				test="${(pageContext.request.remoteUser == news.user.username) || (hasPermission)}">
				<c:url var="url" value="/newsform.html">
					<c:param name="id" value="${news.id}" />
				</c:url>
												| <a href="${url }">Edit</a>
			</c:if></div>
			</div>
			</div>
		</c:forEach> <c:if test="${empty tuxBaseObjectList }">
			<c:if test="${hasPermission }">
				<div class="links">No News Found.<a
					href="<c:url value="/newsform.html" />">Add One</a></div>
			</c:if>
		</c:if>
		<div style="clear: both;">&nbsp;</div>
		</div>
		</div>
		</div>
		
		<div id="rightside">
		<ul>
		
			<li><img src="<c:url value="/images/login_2_grey.jpg"/>"
				width="120" height="50" alt="trinity group"></img></li>
		
			<li><img src="<c:url value="/images/register_2.gif"/>" width="120"
				height="50" alt="trinity group"></img></li>
			<li>
			<div id="search">
			<form method="get" action="#">
			<div><input type="text" name="s" id="search-text" value="" /> <input
				type="submit" id="search-submit" value="GO" /></div>
			</form>
			</div>
		
			<div style="clear: both;">&nbsp;</div>
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
			<img src="<c:url value="/images/sample_banner_3.jpg"/>" width="150"
				height="100" alt="trinity group"></img>
			</li>
			<li>
			<img src="<c:url value="/images/sample_banner_4.jpg"/>" width="150"
				height="100" alt="trinity group"></img>
			</li>
			<img src="<c:url value="/images/sample_banner_06.gif"/>" width="150"
				height="100" alt="trinity group"></img>
						
		
		</ul>
		
		</div>
		
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
		
		<!-- end #content --> <!-- end #page --></div>
		<!-- end #footer -->
</body>
