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
			<div class="movie-short-description">
				<%-- Movie description goes to here --%>
				${product.entertainmentService.showShortDescription}
			</div>
			<div class="heading1">
				<fmt:message key="movie.starring"/>					
			</div>	
			<div class="movie-starring">
				${product.entertainmentService.showStarring}
			</div>
			<div class="heading1">
				<fmt:message key="movie.plot"/>					
			</div>			
			<div class="movie-plot">
				${product.entertainmentService.showPlot}
			</div>
			<div class="heading2">
				<fmt:message key="movie.date"/>					
			</div>			
			<div class="movie-date">
				${product.entertainmentService.showDate}
			</div>
			<div class="heading2">
				<fmt:message key="movie.venue"/>									
			</div>			
			<div class="movie-venue">						
				${product.entertainmentService.showVenue}
			</div>
			<div class="heading1">
				<fmt:message key="movie.ticket"/>					
			</div>			
			<div class="movie-ticket">
				${product.entertainmentService.showTicket}
			</div>
			<div class="heading2">
				<fmt:message key="movie.booking"/>					
			</div>	
			<div class="movie-booking">
				${product.entertainmentService.showBooking}
			</div>
			<div class="movie-link">
					<a target="_new" href="${product.entertainmentService.showMovieDetailLink}">click here to check the detail</a>
			</div>
		</div>
		<div class="movie-right">	
			<img src="<c:url value="${product.entertainmentService.moviePosterLink}"/>" width="270" height="427"  />
		 </div>
	</div>
</div>

	
