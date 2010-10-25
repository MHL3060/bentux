<%@ include file="/common/taglibs.jsp" %>
<div id="main">
	<head>
	<meta name="menu" content="Movie Detail" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
	</head>
	<div id="movie">
		<div class="movie-left">
			<div class="movie-title">
					<fmt:message key="movie.showing"/>					
			
					${product.name}
			</div>
			<div class="movie-description">
			<%-- Movie description goes to here --%>
				${product.description}
			</div>	
		</div>
		<div class="movie-right">
		 <%-- Movie poster goes to here --%>
		 		<img alt="image holder" src="<c:url value="${product.firstImage.thumbPath}" />" width="270" height="425" alt="coming-movie">		
		 </div>
	</div>
</div>

	