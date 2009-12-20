<%@ include file="/common/taglibs.jsp" %>

<head>
<meta name="menu" content="Product Detail" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
</head>
<c:choose>
	<c:when test="${not empty product }">	
	
		<div id="title">Product Details</div>
			
		<div class="post">
		<h1>${product.name}</h1>
			<div class="picture">
			<img alt="image holder" src="<c:url value="${product.firstImage.thumbPath}" />" border="0" height="130" hspace="10" width="180"
			title="<fmt:message key="click.enlarge" />" />
			</div>	
		</div>
		
		<div>
			<c:if test="${hasPermission }">
				<c:url var="url" value="/additem.html">
				<c:param name="pid" value="${product.id }" />
			</c:url>
			<a href="${url }"><fmt:message key="add.to.cart" /></a>
			
			</c:if>
			
		</div>
		
		<div class="detail">
			<ul>			
				<li>Brand: ${product.brandName.name}</li>
                <li>Price: $${product.price} HKD</li>
				<li>Discount:
					<c:choose>
						<c:when test="${product.discountPrice != null}">
							 ${product.discountPrice}
						</c:when>
						<c:otherwise>
							No Discount Available
						</c:otherwise>
					</c:choose>
				</li>
                <li>Rating:
					<c:choose>
						<c:when test="${product.rating != null}">
							${product.rating }
						</c:when> 
					<c:otherwise>
						No Rating Available						
					</c:otherwise>
					</c:choose>
				</li>
                <li>Availability: ${product.availability} IN STOCK</li>
                <li>Shipping: Free Shipping Over $200 purphase</li>
			</ul>	
		
			
		</div>
		<div style="clear: both;">&nbsp;</div>
			
		<div id="title">Product Specification</div>
		
		<div class="detail">
	
			<c:forEach var="item" items="${product.catalogs}">
				<c:if test="${item.parent.id == -2}">
					<ul>			
						<li>Catalog: ${item.name}</li>
						<li>IMDB Link: ${product.entertainmentProduct.imdbLink}</li>
					</ul>
				</c:if>		
				<c:if test="${item.parent.id == -1}">
					<ul><li>Catalog: ${item.name}</li></ul>
					<c:if test="${product.foodProduct.weight != null}">
						<ul>
						<li>Weight: ${product.foodProduct.weight}
							${product.foodProduct.weightUnit}
						</li>
						</ul>
					</c:if>
					<c:if test="${product.foodProduct.width != null}">
						<ul>
						<li>Width: ${product.foodProduct.width}</li>
						</ul>
					</c:if>
					<c:if test="${product.foodProduct.height != null}">
						<ul><li>Height: ${product.foodProduct.height}</li></ul>
					</c:if>
					<c:if test="${product.foodProduct.depth != null}">
						<ul><li>Depth: ${product.foodProduct.depth}</li></ul>
					</c:if>
					<c:if test="${not empty product.foodProduct.volumeUnit}">
						<ul><li>Volume: ${product.foodProduct.volumeUnit}</li></ul>
					</c:if>
					<c:if test="${product.foodProduct.dayLife != null}">
						<ul><li>Day Life: ${product.foodProduct.dayLife}</li></ul>
					</c:if>
				</c:if>			
				<c:if test="${item.parent.id == -3}">
					<ul><li>Catalog: ${item.name}</li></ul>
					<c:if test="${not empty product.entertainmentService.address}">
						<ul><li>Address: ${product.entertainmentService.address}</li></ul>
					</c:if>
					<c:if test="${not empty product.entertainmentService.showTime}">
						<ul><li>Show Time: ${product.entertainmentService.showTime}</li></ul>
					</c:if>
					<c:if test="${product.entertainmentService.showDuration != null}">
						<ul><li>Duration: ${product.entertainmentService.showDuration}</li></ul>
					</c:if>
					<c:if test="${product.entertainmentService.showFrom != null}">
						<ul><li>Show From:${product.entertainmentService.showFrom}</li></ul>
					</c:if>
					<c:if test="${product.entertainmentService.showTo != null}">
						<ul><li>Show To: ${product.entertainmentService.showTo}</li></ul>
					</c:if>
					
					
				</c:if>				
						
			</c:forEach>
		</div>
				
		<div style="clear: both;">&nbsp;</div>
											
		<div id="title">Product Descriptions</div>
		<div class="post">
			<div class="description"><c:out value="${product.description}"
				escapeXml="false" />
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<fmt:message key="product.not.found" />
	</c:otherwise>
</c:choose>

