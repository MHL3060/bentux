<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/scripts/jquery/jquery.js" />"></script>"
<script type="text/javascript" src="<c:url value="/scripts/jquery/jquery.corners.js" />"></script>
<h1>
</h1><fmt:message key="catalog.title" />
</h1>
<style>
<script type="text/javascript">
$(function(){	// shorthand for $(document).ready() BTW
        $('div.demo').each(function() {
			// The text of the paragraphs in the rounded divs is also the
			// jQuery code needed to create that effect. Cosmic.
             $('demo').corner();
        });
        $('#main p').wrap("<code></code>");
	});



</script>
div.section { clear: left; }
h1 { font-size: 150%; padding: 0 }
h2 { background: #ccc; padding: 1px 20px;  }
div.demo { 
	float: left; width: 18em; padding: 20px; margin: 1em;
    background: #c92; color:#000; text-align: center; font: verdana, arial, sans-serif;
}
div.fun  { margin: 2px; }
</style>
<div class="demo"><h1>Round</h1> <p>$(this).corner();</p></div>

