<%@ include file="/common/taglibs.jsp" %>
<div id="main">
	<head>
	<meta name="menu" content="Movie Detail" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
	</head>
	<div id="movie">
		<div class="movie-left">
			<div class="movie-heading">	
				<fmt:message key="movie.showing"/>					
			</div>
			<div class="movie-title">
				${product.name}
			</div>
			<div class="movie-description">
			<%-- Movie description goes to here --%>
				${product.description}
			</div>	
		</div>
		<div class="movie-right">	
			<img src="<c:url value="${product.entertainmentService.moviePosterLink}"/>" width="295" height="380"  />
			
			
		 </div>
	</div>
</div>

	
