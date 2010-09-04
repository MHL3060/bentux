<%@ include file="/common/taglibs.jsp"%>
<div id="main">

	<head>
	<meta name="menu" content="Now Showing" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
	</head>
	<div id="movie">
		<div class="left">
	
			<div class="movie-heading">
						<fmt:message key="movie.showing"/>						
			</div>
			<div class="movie-description">
			<%-- Movie description goes to here --%>
						<fmt:message key="movie.not.available"/>						
			</div>
			
		</div>
		<div class="right">
		 <%-- Movie poster goes to here --%>
		    	<img src="<c:url value="/images/movie_coming_soon.jpg"/>" width="270" height="425" alt="coming-movie"></a>
		</div>
	</div>
	
	
	
</div>









