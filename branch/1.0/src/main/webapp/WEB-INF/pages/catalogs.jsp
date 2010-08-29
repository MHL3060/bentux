<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/scripts/corners.js" />"></script>





<script type="text/javascript">

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


</script>
<style>
div.section { clear: left; }
div.catalog { 
    float: left; 
	width: 90px; 
	padding: 10px; 
	margin: 5px;
	height: 90px;
    background: #ccc; 
    color:#000; 
    text-align: center; 
    font: verdana, arial, sans-serif;
}
div.center{
	float: left;
	width: 100%;
	padding-left: 2em;

}

div.subcatalog { 
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
   
	width: 100%;
	background: #fff;
	height: 1px;
	display: block;
	overflow: none;
	float: left;
}

</style>
<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>
<h1><fmt:message key="product.title" /></h1>

<div class="center">

	<img src="<c:url value="/images/mainProduct.jpg" />" width="600" height="400" />
	<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
	<div class="catalog">
		<img alt="image holder" src="<c:url value="${catalog.image.thumbPath }" />" />
		<a class="product" href="<c:url value="/subcatalogs.html?pid=${catalog.id}" />" > ${catalog.name}</a>
	</div>
	</c:forEach>
</div>
 

	

	



<%--
<div class="new_line"></div>
		<c:forEach var="subCatalog" items="${catalog.children}" >
			<div class="subcatalog" id="subcatalog_${subCatalog.id}">
				<img alt="image holder" src="<c:url value="${subCatalog.image.thumbPath }" />" 
					onclick="new Effect.Puff('subcatalog_${subCatalog.id}'); 
					window.setTimeout('Effect.Appear(\'subcatalog_${subCatalog.id}\', {duration:.3})',4000); 
					document.location='<c:url value="/productlist.html?catalogId=${subCatalog.id}" />'"
				/>
				<a class="product" alt="click here to view all the products related to ${subCatalog.name }"
				onclick="new Effect.Puff('subcatalog_${subCatalog.id}'); 
				window.setTimeout('Effect.Appear(\'subcatalog_${subCatalog.id}\', {duration:.3})',4000); "
				href='<c:url value="/productlist.html?catalogId=${subCatalog.id}" />' > ${subCatalog.name}</a>
			</div>
	
		</c:forEach>
		<div class="new_line"></div>

 --%>

