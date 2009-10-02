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
	width: 15em; 
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
	padding-left: 12em;

}
div.fun  { margin: 2px; }
</style>
<h1><fmt:message key="catalog.title" /></h1> 
<div id="whole" class="center">
	<div class="catalog">
		<p>Food Product holder</p>
		<a class="product" href="<c:url value="/productlist.html?cid=-1" />" > Click to view All Food Product</a>
	</div>
	<div class="catalog">
		
		<p>Entertainment Stuff</p>
		<a class="product" href="<c:url value="/productlist.html?cid=-2" />" > Click to view All Entertainment Product</a>
	</div>
	<div class="catalog">
		
		<p>Entertainment Service</p>
		<a class="product" href="<c:url value="/productlist.html?cid=-3" />" > Click to view All Entertainment Service</a>
	</div>
	<div class="catalog">
		
		<p>Misc</p>
		<a class="product" href="<c:url value="/productlist.html?cid=-3" />" > Click to view All Entertainment Service</a>
	</div>
	<div class="catalog">
		
		<p>Misc</p>
		<a href="<c:url value="/productlist.html?cid=-3" />" > Click to view All Entertainment Service</a>
	</div>
	<div id="misc" class="catalog">
		<p>Misc</p>
		<a id="product" href="<c:url value="/productlist.html?cid=-3" />"  > Click to view All Entertainment Service</a>
	</div>
</div>


