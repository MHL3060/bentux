<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="Home" />

<link rel="shortcut icon" href="images/favicon2.ico" />
<link rel="icon" href="images/favicon2.png" type="image/png" />
</head>
<div id="main">

  	<c:choose>
	        	<c:when test="${list.id < 0 }">
	        		${list.id }
	        	</c:when>
	        	<c:otherwise>
	        		<c:url var="url" value="catalogform.html">
	        			<c:param name="id" value="${list.id}" />
	        		</c:url>
	        		<a href="<c:url value="${url }" />" >${list.id }</a>
	        	</c:otherwise>
	        </c:choose>

			<img src="<c:url value="http://lh5.ggpht.com/_WwislJULCHw/TNQ5AfR_lMI/AAAAAAAAB6o/OxPpWfV1LQs/Picture%204.png"/>" height=425px />

</div>
