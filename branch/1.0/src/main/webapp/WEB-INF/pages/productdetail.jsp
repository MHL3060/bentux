<%@ include file="/common/taglibs.jsp" %>

<head>
<meta name="menu" content="Home" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-product-detail.css'/>" />
</head>
<c:choose>
	<c:when test="${not empty product }">
	
		<div id="title">Product Details</div>
	
			<div class="post">
			 <div id="picture">
				<img alt="image holder" src="<c:url value="${product.firstImage.thumbPath}" />" align="left" border="0" height="130" hspace="10" width="180"
				title="<fmt:message key="click.enlarge" />" />
	 		</div>
			<h1 class="title">${product.name}</h1>
			<p class="meta">			
							<span class="feature">Price: $${product.price}	
							<span class="feature">Barcode: 			
								<c:if test="${product.barcode == null}">
									Not Available
								</c:if>${product.barcode}
							<span class="feature">Rating:
								<c:if test="${product.rating == null}">
									Not Available
								</c:if> ${product.rating }
							<span class="feature">Availability: ${product.availability} IN STOCK</span>	
							<div style="clear: both;">&nbsp;</div>
							
			<h3 class="title">Product Description</h3>
			<div class="entry"><c:out value="${product.description}"
				escapeXml="false" />
			</div>
			</div>
			
		 	
		
	</c:when>
	<c:otherwise>
		<fmt:message key="product.not.found" />
	</c:otherwise>
</c:choose>

