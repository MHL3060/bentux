<%@ include file="/common/taglibs.jsp" %>


 <script type='text/javascript' src='<c:url value="/dwr/interface/shoppingCartManager.js" />'></script>
 <script type='text/javascript' src='<c:url value="/dwr/interface/productManager.js" />'></script>
 <script type='text/javascript' src="<c:url value='/dwr/engine.js' />"></script>
 <script type='text/javascript' src="<c:url value='/dwr/util.js' />"></script>
 <%--  
 <script type="text/javascript" src="<c:url value='/scripts/lightwindow.js'/>"></script>
 --%>
 <script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>
<style>
div.subcatalog-center{
	width: 100%;
	float: left;
	color: grey;
	letter-spacing: 1px;
	margin-top:7px;
}

div.heading li a {
    display: block;
    font-weight: normal;
    text-decoration: none;
    letter-spacing: 1px;
    font-size: 18px;
    margin: 0;
    padding: 5px;
    height: 17px;
    color: green;
	background: #fff;
}

div#nav li a:hover, div#nav li a:active, div#nav li a.current {   
   	color: orange;
   	font-weight: bold;
	background: #fff;
	text-transform: uppercase;
}

div.subcatalog {
   
}
.subcatalog ul{
	margin:0;
	padding:0;
	margin-left:-3em; 
	*float:left!important;
	*margin-left:-3em!important;
	list-style:none;
}
.subcatalog ul li{
	padding-top: 15px;
	*padding-top: 0px!important;
	padding-bottom: 15px;
	*padding-bottom: 25px!important;
	width:89px; 
	margin-left:3em;
	*margin-left:3em!important;
	*display:inline;
	float:left;
}
.subcatalog img{
	width: 90px;
	border: 0px;
}

div.subcatalog-new_line {
	margin-top: 8px;
   	border-top: 1px dotted orange;
	width: 99.5%;
}


.breadcomb {
   	font-size: 21px;
   	margin: 0px;
	line-height:25px;
	*line-height:22px!important;
	padding : 0px;
	white-space:nowrap;
	list-style-type: none;   
}

.breadcomb li {
   	display: inline;
   	margin-right: 16px;
   *margin-right: 20px!important;
}

p.catalog_name {
  margin: 0px;
  letter-spacing: -1px;
}
 
.breadcomb a{
   color:gray;
   font-weight: normal;
}
.breadcomb li.current {
   color:black;
}
/** hack for IE7 */
.table {
	border-collapse: separate;
	
}
.breadcomb a:hover{
   color: #bebebe;
   font-weight: normal;
}
</style>

<div id="main">
	<div class="subcatalog-center">
		<ul class="breadcomb">
			<c:forEach var="catalog" items="${catalogs}">
               			<c:if test="${catalog.id != -3 }">
                		<c:choose>
                	
                		<c:when test="${catalog.id ==param.pid}">
                                       <li class="current">
						${catalog.name }
					</li>
				</c:when>
				<c:otherwise>
	                       		<c:url var="url" value="/subcatalogs.html">
						<c:param name="pid" value="${catalog.id}"/>
					</c:url>   
					<li class="noncurrent">
						<a href="${url }"> ${catalog.name }</a>
					</li> 
				</c:otherwise>
        			</c:choose>
        			</c:if>
        		</c:forEach>
		</ul>
		<div class="subcatalog-new_line"></div>
	</div>
 	
	<div id="whole">
	<div class="subcatalog">
	<ul>
	<c:forEach var="catalog" items="${tuxBaseObjectList.list}">

 	       <li>

		<%--<li id="subcatalog_${catalog.id}">--%>
                        <c:url var="url" value="/file.html">
                                <c:param name="path" value="${catalog.image.thumbPath}" />
                        </c:url>
                        <img alt="image holder" src="${url}" />
                        <%--
                        <a class="product" alt="click here to view all the products related to ${catalog.name }"
                                        onclick="new Effect.Puff('subcatalog_${catalog.id}');
                                        window.setTimeout('Effect.Appear(\'subcatalog_${catalog.id}\', {duration:.3})',4000); "
                                        href='<c:url value="/productlist.html?catalogId=${catalog.id}" />' > ${catalog.name}</a>
                        --%>
                        <div style="display: block; flow: left; margin-top:5px;">
                        <select name="sub" id="sub_${catalog.id}" style="width: 90px;font-size:11px;important;letter-spacing:-1px;text-align:left;" onChange="showProduct(this,'products'); document.getElementById('product_table').style.borderCollapse='collapse'">
                                <p class="catalog_name">
                                        <option value="${grand.id }"> ${catalog.name }</option>
                                </p>
                                <c:forEach var="grand" items="${catalog.children}">
                                        <option value="${grand.id }"> ${grand.name }</option>
                                </c:forEach>
                        </select>
                        </div>
                </li>

        </c:forEach>
	</ul>
   	</div>
	</div>
	
	<div id="productlist" style="visibility: hidden;"> 
		<div class="fade"></div>		 
		<div class="popup_product_block"> 
			<div class="popup"> 
				<a href="javascript:hide('productlist');window.location.reload()"><img src="<c:url value="/images/icon_close.png" />" class="cntrl" title="Close" /></a> 
				<table class="table" id="product_table">
					<thead>
						<tr>
							<th><fmt:message key="product.id" /></th>
							<th><fmt:message key="product.name" /></th>
							<th><fmt:message key="product.brandName"/></th>
							<th><fmt:message key="product.description" /></th>
							<th><fmt:message key="product.availability" /></th>
							<th><fmt:message key="product.price" /></th>
							<th><fmt:message key="Add To Cart" /></th>
						</tr>
					</thead>
					<tbody id="products"></tbody>
				</table>
				 
			</div> 
		</div> 
	</div> 
</div>
<%@ include file="/common/cart.jsp" %>

<div style="visibility: hidden;">
	

</div>
