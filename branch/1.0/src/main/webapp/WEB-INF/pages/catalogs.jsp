<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/scripts/corners.js" />"></script>





<script type="text/javascript">
/*
Event.observe(window, 'load', function() {
$$('div.catalog').each(function(el) {
        
    new Effect.Corner(el);
	});
});
*/
$('product').observe('click', function(event) {
	  event.stop();
	  
	  new Effect.Parallel([
	    new Effect.Move('whole', { sync: true, x: 400, y: 0, mode: 'relative' }), 
	    new Effect.Opacity('whole', { sync: true, from: 1, to: 0 })
	  ], { 
	    duration: 1.5
	  });
	});


</script>
<style>
div.section { clear: left; }
div.catalog { 
    float: left; 
	width: 130px; 
	padding: 1px; 
	margin: 15px 20px 20px 0px;
	height: 130px;
 
    color:#000; 
    text-align: center; 
    font: verdana, arial, sans-serif;
}

div.catalog img {
    width: 116px;
	height: 63px;
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
   	border-top: 1px solid orange;
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
	
		<img src="<c:url value="/images/product_content.jpg" />" width="606" height="297" />
		<div class="new_line"></div>
		<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
			<%-- to hide the Entertainment Catalog --%>
			<c:if test="${catalog.id != -3}">
			<div class="catalog">
				<c:url var="url" value="/file.html">
					<c:param name="path" value="${catalog.image.thumbPath }" />
				</c:url>
				<img alt="image holder" src="${url}" />
				<a class="product" href="<c:url value="/subcatalogs.html?pid=${catalog.id}" />" > ${catalog.name}</a>
			</div>
			</c:if>
		</c:forEach>
	</div>
</div>

