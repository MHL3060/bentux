<%@ include file="/common/taglibs.jsp" %>
<head>
<meta name="menu" content="Home" />

<link rel="shortcut icon" href="images/favicon2.ico" />
<link rel="icon" href="images/favicon2.png" type="image/png" />
</head>

<script type="text/javascript" src="<c:url value="/scripts/corners.js" />"></script>


<%--


<script type="text/javascript">
/*
Event.observe(window, 'load', function() {
$$('div.catalog').each(function(el) {
        
    new Effect.Corner(el);
	});
});

$('product').observe('click', function(event) {
	  event.stop();
	  
	  new Effect.Parallel([
	    new Effect.Move('whole', { sync: true, x: 400, y: 0, mode: 'relative' }), 
	    new Effect.Opacity('whole', { sync: true, from: 1, to: 0 })
	  ], { 
	    duration: 1.5
	  });
	});

*/
</script>
--%>
<style>
div.section { clear: left; }

div.display {
	width: 100%;
}

div.display .food_catalog { 
    float: left; 
    width: 237px; 
    padding: 12px 0px 13px 0px;
    list-style: none;
    text-align:center;
    font: verdana, arial, sans-serif;
}

div.display .food_catalog img{ 
    width: 237px;
    height: 63px;
    margin-bottom: 8px;
}

div.display .catalog {
    font: verdana, arial, sans-serif;
    text-align:center;
}

div.display .catalog ul{
        margin-left:-1em;
        list-style:none;
}
div.display .catalog ul li{
        padding-top: 13px;
        padding-bottom: 15px;
        margin-left:1em;
	float: left;
	width: 110px;
}
div.display .catalog img{
        border: 0px;
	width: 110px;
	height: 63px;
	margin-bottom: -3px;
}

div.center{
	float: left;
	width: 100%;
}

div.subcatalog {
	margin-top: 5px; 
    float: left; 
	width: 6em; 
	padding: 40px; 
	margin: 1em;
	height: 6em;
    background: #ccc; 
    color:#000; 
    text-align: center; 
    font: verdana, arial, sans-serif;
}
div.new_line {
   	margin-top: 15px;
   	border-top: 1px dotted orange;
	width: 100%;
	background: #fff;
	height: 1px;
	display: block;
	overflow: none;
	float: left;
}

</style>

<div id="main">
	<div class="center">
	
		<img src="<c:url value="http://lh3.ggpht.com/_WwislJULCHw/TM03juLTGKI/AAAAAAAAB50/Xz3ygubHlyA/product_content.png" />" width="606" height="297" />
		<div class="new_line"></div>
	<div class="display">	
	<span class="food_catalog">
		<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
			 <c:if test="${catalog.id == -1}">
                                <c:url var="url" value="/file.html">
                                        <c:param name="path" value="${catalog.image.thumbPath }" />
                                </c:url>
				<a class="product" href="<c:url value="/subcatalogs.html?pid=${catalog.id}" />" > 			
                                	<img alt="image holder" src="${url}" />
				          ${catalog.name}
                                </a>
                         </c:if>
		</c:forEach>
		</span>
		
	<span class="catalog">
		<ul>
		<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
			<%-- to hide the Entertainment Catalog --%>
				<c:if test="${(catalog.id == -2) || (catalog.id == -5) || (catalog.id == -4)}" >
			<li>
				<c:url var="url" value="/file.html">
					<c:param name="path" value="${catalog.image.thumbPath }" />
				</c:url>
				<a class="product" href="<c:url value="/subcatalogs.html?pid=${catalog.id}" />" > 			
					<img alt="image holder" src="${url}" />
					${catalog.name}
				</a>
			</li>
			</c:if>
		</c:forEach>
		</ul>
	</span>
	</div>
	</div>
</div>
