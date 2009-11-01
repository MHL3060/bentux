<%@ include file="/common/taglibs.jsp"%>

<head>
    <meta name="menu" content="Home"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/layout-home.css'/>" />
</head>
<body id="home">
<div id="wrapper">
	<div id="mainPage">
		<div id="main-title"> Taste Of India's Online Store</div>
		<div id="page-bgtop">
		<div id="page-bgbtm">
		<div id="left-main">
			
			<div class="main-banner">
				<img src="<c:url value="/images/sample-banner.gif"/>" width="620" height="85" alt="trinity group" ></img>			
			</div>
						
			<div class="post">
				<h1 class="title">Our Site has been launched</h1>				
				<p class="meta"><span class="date">Oct 24, 2009</span><span class="posted">Posted by <a href="#"> Matt Lai	</a></span>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
					Taste of India, by Trinity Infotech. We provide over a thousand plus items in our store, please come to visit us sometimes.
					<div class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a></div>
				</div>		
			</div>	
		
		 
			<div class="post">	
				<h1 class="title">What's a "wrapper"</h1>					
				<p class="meta"><span class="date">Oct 29, 2009</span><span class="posted">Posted by <a href="#"> Matt Lai</a></span>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
					Essentially, a wrapper is nothing more than a generic "div" tag element that usually contains all the other page elements. This wrapper div provides a way to constrain the width of the page content, and can also be colored, bordered, and perhaps even display a background image. In short, a wrapper can be a very useful thing to have.
					<div class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a></div>
				</div>		
			</div>
				
		<div style="clear: both;">&nbsp;</div>
		</div>
	
	<div id="sidebar">
		<ul>
			<li>
				<div id="search" >
					<form method="get" action="#">
						<div>
							<input type="text" name="s" id="search-text" value="" />
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
				<p><img src="<c:url value="/images/sample-banner2.jpg"/>" width="220" height="160" alt="trinity group" ></img></p>	
				
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
