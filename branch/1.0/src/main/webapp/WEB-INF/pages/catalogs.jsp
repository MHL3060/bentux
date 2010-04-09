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
	width: 12em; 
	padding: 40px; 
	margin: 1em;
	height: 100px;
    background: #ccc; 
    color:#000; 
    text-align: center; 
    font: verdana, arial, sans-serif;
}
div.center{
	float: left;
	padding-left: 2em;

}

</style>
<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>
<h1><fmt:message key="catalog.title" /></h1> 
<div id="whole" class="center">
	<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
	<div class="catalog">
		<img alt="image holder" src="<c:url value="${catalog.image.thumbPath }" />" />
		<a class="product" href="<c:url value="/subcatalogs.html?pid=${catalog.id}" />" > ${catalog.name}</a>
	</div>
	</c:forEach>
</div>


