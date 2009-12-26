<%@ include file="/common/taglibs.jsp" %>
<c:set var="button">
	<input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/productform.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>
 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
 <%--  
 <script type="text/javascript" src="<c:url value='/scripts/lightwindow.js'/>"></script>
 --%>
 <script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>
 
 
 <script type="text/javascript">

 	function addItem(product, quantity){
		shoppingCartManager.addItem(${user.id},product, quantity, 
				function(result) {
					if (result == true ) {
						
					}else {

					}
					
				}																
			); 
 	}
	function popup(pid, toNodeId) {
		toNode = document.getElementById(toNodeId);
		productManager.getById(pid, function(product) {
			var ul = toNode.createNode('ul');
			var li = ul.createElement('li');
			li.innerText = product.name;
			li = ul.createElement('li');
			li.innerText = product.availibility;
			
		});
		myLightWindow.createWindow(toNodeId);
	}
</script>

<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>
<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>
<display:table id="tuxBaseObjectList" name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
	pagesize="25" class="table uutResultList" export="true" >
	<c:if test="${hasPermission }">
		<display:column titleKey="id" property="id" url="/productform.html" paramId="id" 
			paramProperty="id" />
	</c:if>
	<display:column titleKey="product.image">
		<img src="<c:url value="${tuxBaseObjectList.firstImage.thumbPath}"  />" title="<fmt:message key="click.enlarge" />" />
	</display:column>
	<display:column property="brandName.name" titleKey="product.brandName.name" sortable="true" />
	<display:column property="name" titleKey="product.name" sortable="true" />
	<display:column property="description" titleKey="product.description" maxWords="50" />
	<display:column property="availability" titleKey="product.availability" />
	<c:if test="${hasPermission }">
		<display:column titleKey="product.add.image">
			<c:url var="imageUrl" value="/imageform.html">
				<c:param name="pid" value="${tuxBaseObjectList.id }" />
			</c:url>
			<a href="<c:url value="${imageUrl}" />" /><fmt:message key="add.image" /></a>
		</display:column>
	</c:if>
	<display:column titleKey="more.info" >
		<c:url var="url" value="/productdetail.html">
			<c:param name="id"  value="${tuxBaseObjectList.id}" />
		</c:url>
		<a href="${url }" ><fmt:message key="more.info" /></a>
	</display:column>
	<display:column titleKey="add.cart">
		<c:if test="${user != null && tuxBaseObjectList.availability > 0 }">
		
			<c:url var="url" value="/additem.html">
				<c:param name="pid" value="${tuxBaseObjectList.id }" />
			</c:url>
			<a href="javascript:showDiv();"><fmt:message key="add.to.cart" /></a>
		</c:if>
	</display:column>
	
</display:table>
<c:if test="${hasPermission }"><c:out value="${button}" escapeXml="false" /></c:if>

<div id="hideshow" style="visibility:hidden;"> 
	<div id="fade"></div> 
	<div class="popup_block"> 
		<div class="popup"> 
			<a href="javascript:hideDiv()"><img src="<c:url value="/images/icon_close.png" />" class="cntrl" title="Close" /></a> 
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

<script language=javascript type='text/javascript'> 
function hideDiv() { 
if (document.getElementById) { // DOM3 = IE5, NS6 
document.getElementById('hideshow').style.visibility = 'hidden'; 
} 
else { 
if (document.layers) { // Netscape 4 
document.hideshow.visibility = 'hidden'; 
} 
else { // IE 4 
document.all.hideshow.style.visibility = 'hidden'; 
} 
} 
}
 
function showDiv() { 
if (document.getElementById) { // DOM3 = IE5, NS6 
document.getElementById('hideshow').style.visibility = 'visible'; 
} 
else { 
if (document.layers) { // Netscape 4 
document.hideshow.visibility = 'visible'; 
} 
else { // IE 4 
document.all.hideshow.style.visibility = 'visible'; 
} 
} 
} 
</script> 



