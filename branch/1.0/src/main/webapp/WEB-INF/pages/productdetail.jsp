<%@ include file="/common/taglibs.jsp" %>

<head>
<meta name="menu" content="Product Detail" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-product-detail.css'/>" />
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
		
		<div class="detail">
			<ul>
                <li>Price: $${product.price} HKD</li>
				<li>Barcode: 			
					<c:if test="${product.barcode == null}">
						Not Available
					</c:if>${product.barcode}
				</li>
                <li>Rating:
					<c:if test="${product.rating == null}">
						Not Available
					</c:if> ${product.rating }
					</li>
                <li>Availability: ${product.availability} IN STOCK</li>
                <li>Shipping: Free Shipping NOW for $200 </li>
			</ul>		
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

