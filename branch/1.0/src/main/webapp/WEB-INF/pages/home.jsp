<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="Home" />

</head>

<div id="wrapper">
	<div id="main-title">Welcome to Taste of India</div>
		<div id="main-banner-left"><img src="<c:url value="/images/sample_banner.gif"/>" width="680" height="90" alt="trinity group"></img></div>
			
			<div style="clear: both;">&nbsp;</div>
					
			<div id="leftside">
				<ul>			
					<li>
					<h2 class="hide">Menu:</h2>
				
					<ul class="avmenu">
						<li><a href="subcatalogs.html">Categories</a></li>
						<ul>
							<li><a href="subcatalogs.html?pid=-1">Foods</a></li>
							<li><a href="subcatalogs.html?pid=-4">Cultural</a></li>
							<li><a href="subcatalogs.html?pid=-2">Entertainment</a></li>
						</ul>
						</li>
					</ul>
				</li>
			
				<li>	
					<div class="announce">
					<h2>Feature Products</h2>
			
					<p><a href="#">Snacks</a><br />
					<p><a href="#">Drinks</a><br />
					<p><strong><a href="#">Movies</a></strong><br />
					<p><strong><a href="#">Dried Fruits</a></strong><br />
					<p><strong><a href="#">Rice/Noodles</a></strong><br />
					</div>
					
				</li>
				
				<li>		
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
				</li>
				
				<li>	
					<img src="<c:url value="/images/sample_banner2.jpg"/>" width="140" height="100" alt="trinity group"></img>
				</li>
			</ul>
			</div>
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
												&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="${url }">Edit</a>
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
					<li><a href="#">Adding A Complete CSS Resource To Your Arsenal</a></li>
					<li><a href="#">10 Useful Free Ajax Tools to Add To Your Toolbox</a></li>
					<li><a href="#">CSS Button Animation without Images</a></li>
					<li><a href="#">Create Interactive Web Pages with The Ajax Control Kit</a></li>
					<li><a href="#">How To Use CSS Margins On Pages</a></li>
					<li><a href="#">Top CSS Navigation Menu For Commercial Sites</a></li>
					<li><a href="#">Best Ways To Write Clean CSS Code</a></li>
					<li><a href="#">How to Deploy Web Projects Fast with Deploy</a></li>
					<li><a href="#">CSS Tools to Make Design Easier</a></li>
					<li><a href="#">Smooth Your Design and Round Those Corners</a></li>
					<li><a href="#">Dynamic Font Sizes</a></li>
					<li><a href="#">Designing For Those With Disabilities</a></li>
					<li><a href="#">How to over design with CSS.</a></li>
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
