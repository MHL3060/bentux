<%@ include file="taglibs.jsp"  %>
<script type="text/javascript">
function hideDiv() { 
		if (document.getElementById) { // DOM3 = IE5, NS6 
			document.getElementById('hideshow').style.visibility = 'hidden'; 
		} else { 
			if (document.layers) { // Netscape 4 
				document.hideshow.visibility = 'hidden'; 
			} else { // IE 4 
				document.all.hideshow.style.visibility = 'hidden'; 
			} 
		} 
	}
 
	function showDiv() { 
		if (document.getElementById) { // DOM3 = IE5, NS6 
			document.getElementById('hideshow').style.visibility = 'visible'; 
		} else { 
			if (document.layers) { // Netscape 4 
				document.hideshow.visibility = 'visible'; 
			} else { // IE 4 
				document.all.hideshow.style.visibility = 'visible'; 
			} 
		} 
	} 
</script>
<div id="hideshow" style="visibility:hidden;"> 
	<div id="fade"></div> 
	<div class="popup_block"> 
		<div class="popup"> 
			<a href="javascript:hideDiv()"><img src="<c:url value="/images/icon_close.png"/>" class="cntrl" title="Close" /></a> 
			<h3>Example of Styling CSS Popups</h3> 
			<p>Eu refero pertineo vulpes, molior, vel. Mos paulatim lobortis sed pneum antehabeo, tristique damnum dolor venio mauris, decet sudo, ibidem lucidus. 
	</p> 
			<p>Eu refero pertineo vulpes, molior, vel. Mos paulatim lobortis sed pneum antehabeo, tristique damnum dolor venio mauris, decet sudo, ibidem lucidus. 
	</p> 
			<h3>Example of Styling CSS Popups</h3> 
			<p>Eu refero pertineo vulpes, molior, vel. Mos paulatim lobortis sed pneum antehabeo, tristique damnum dolor venio mauris, decet sudo, ibidem lucidus. 
	</p> 
			<p>Eu refero pertineo vulpes, molior, vel. Mos paulatim lobortis sed pneum antehabeo, tristique damnum dolor venio mauris, decet sudo, ibidem lucidus. 
	</p> 
		</div> 
	</div> 
</div> 