<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="Home" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-home.css'/>" />
</head>
</head>

<div id="wrapper">
	<div id="sidebar">
					<jsp:include page="/common/sidebar.jsp"/>	
	</div>  
	<div id="main-title">Welcome to Taste of India</div>
		<div id="main-banner-left"><img src="<c:url value="/images/sample_banner.gif"/>" width="680" height="90" alt="trinity group"></img></div>
					
		
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
												&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="${url }">Edit</a>
			</c:if></div>
			</div>
			</div>
		</c:forEach> <c:if test="${empty tuxBaseObjectList }">
			<c:if test="${hasPermission }">
				<div class="links">No News Found.<a
					href="<c:url value="/newsform.html" />">&nbsp;Add One</a></div>
			</c:if>
		</c:if>
		
							
		<div style="clear: both;">&nbsp;</div>
		</div>
		
		
		<div class="sidebar">
			<ul class="left">
				<a href="login.jsp">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="signup.html">Sign Up</a>
			
				<li>
					<ul>	
					<form method="get" action="#">
						<div><input type="text" name="s" id="search-text" value="" /> <input
						type="submit" id="search-submit" value="search" /></div>
					</form>
					</ul>
				</li>
				
				<li>
					<ul>
						<a href="http://www.facebook.com/group.php?gid=111666002279&ref=mf"><img src="<c:url value="/images/facebook_2.jpg"/>" width="140" height="50" alt="trinity group on facebook"></img></a>
						<a href="http://www.orkut.com/"><img src="<c:url value="/images/orkut2.png"/>" width="140" height="50" alt="Orkut"></img></a>
					
					
					</ul>
				</li>
			
				
				
				<li>
					<h2>Sponsored Links</h2>
						<ul>

			                <li><script language=JavaScript src=''></script></li>
							<li><script language=JavaScript src=''></script></li>
			                <li><script language=JavaScript src=''></script></li>
			                <li><script language=JavaScript src=''></script></li>
					</ul>

				</li>

				<li><form style="border:1px solid #ccc;padding:3px;text-align:center;" action="http://www.feedburner.com/fb/a/emailverify" 
					method="post" target="popupwindow" onsubmit="window.open('http://www.feedburner.com', 'popupwindow', 
					'scrollbars=yes,width=550,height=520');return true" id="commentform">Get updates via email.<br/>
					<input type="text" style="width:140px" name="email" /><br/>
					<input type="hidden" value="http://feeds.feedburner.com/~e?ffid=1057567" name="url" />
					<input type="hidden" value="CSS Juice" name="title" /><input type="hidden" name="loc" value="en_US" />
					<input type="submit" name="submit" value="Subscribe"/><br/>Delivered by 
					<a href="http://www.feedburner.com" target="_blank" rel="nofollow">FeedBurner</a></form>
				</li>
				
				<li>
					<h2></h2>
					<div class="partners">
					<img src="<c:url value="/images/sample_banner_3.jpg"/>" width="150"
									height="100" alt="partners"></img>
					</div>
					
				</li>

				<li>
					<h2></h2>
					<div class="partners">
					<img src="<c:url value="/images/sample_banner_4.jpg"/>" width="150"
									height="100" alt="partners"></img>
					</div>
					
				</li>
				<li>
					<h2>Latest Posts</h2>
					<ul>
						<c:forEach items="${latestNews }" var="news"> 
							<li>
								<c:url var="url" value="/news.html">
									<c:param name="id" value="${news.id}" />
								</c:url>
								<a href="${url }">${news.title}</a>
							</li>
						</c:forEach>
					</ul>
				</li>
				
				<li>
					<h2>Archives</h2>
					<ul>
					<li><a href='#' title='September 2009'>September 2009</a></li>
					<li><a href='#' title='August 2009'>August 2009</a></li>
					<li><a href='#' title='July 2009'>July 2009</a></li>
					<li><a href='#' title='June 2009'>June 2009</a></li>
					<li><a href='#' title='May 2009'>May 2009</a></li>
					<li><a href='#' title='April 2009'>April 2009</a></li>
					<li><a href='#' title='March 2009'>March 2009</a></li>
					<li><a href='#' title='February 2009'>February 2009</a></li>
					<li><a href='#' title='January 2009'>January 2009</a></li>
					<li><a href='#' title='December 2008'>December 2008</a></li>
					<li><a href='#' title='October 2008'>October 2008</a></li>
					<li><a href='#' title='September 2008'>September 2008</a></li>
					</ul>
				</li>
				
				<li>
					<h2></h2>
					<div class="partners">
					<img src="<c:url value="/images/sample_banner_06.gif"/>" width="150"
									height="100" alt="partners"></img>
					</div>
					
				</li>
			
				
			</ul>
		</div>

		
			
		
		
		
		
		
		
		
		
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
		
		<!-- end #content --> <!-- end #page --></div>
		<!-- end #footer -->
</body>
