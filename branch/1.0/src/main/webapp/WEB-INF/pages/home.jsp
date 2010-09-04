<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="Home" />
</head>

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

			<img src="<c:url value="/images/home_content_2.jpg"/>"  />

