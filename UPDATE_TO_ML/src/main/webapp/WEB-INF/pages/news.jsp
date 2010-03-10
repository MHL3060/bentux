<%@ include file="/common/taglibs.jsp" %>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/newsform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>
<c:choose>
<c:when test="${not empty news }">

	<div class="post">
			<h1 class="title">${news.title}</h1>
			<p class="meta"><span class="date"><fmt:formatDate
				value="${news.addedOn}" pattern="${datePattern}" /></span><span
				class="posted">Posted by <a href="#">${news.user.firstName
			} ${news.user.lastName }</a></span>
			<div style="clear: both;">&nbsp;</div>
			<div class="entry"><c:out value="${news.contentBody}"
				escapeXml="false" />
			<div class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="#">Comments</a> <c:if
				test="${(pageContext.request.remoteUser == news.user.username) || (hasPermission)}">
				<c:url var="url" value="/newsform.html">
					<c:param name="id" value="${news.id}" />
				</c:url>
												&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="${url }">Edit</a>
			</c:if></div>
			</div>
			</div>

</c:when>
<c:otherwise>
	<c:if test="${hasPermisson }">
		<c:out value="${buttons}" escapeXml="false"/>
	</c:if>
	<display:table name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
	    id="tuxBaseObjectList" pagesize="25" class="table tuxBaseObjectList" export="true">
		<c:if test="${hasPermission}">
	    	<display:column property="id" escapeXml="true" sortable="true"
	        	url="/newsform.html" paramId="id" paramProperty="id" titleKey="news.id"/>
	    </c:if>
	    <display:column property="title" escapeXml="true" sortable="true" titleKey="news.title"/>
	    <display:column property="addedOn" escapeXml="true" sortable="true" titleKey="news.added.on"/>
		<display:column property="user.username" escapeXml="true" sortable="true" titleKey="news.user" />
	    <display:setProperty name="paging.banner.item_name" value="news"/>
	    <display:setProperty name="paging.banner.items_name" value="news"/>
	</display:table>
	
	<c:if test="${hasPermisson }">
		<c:out value="${buttons}" escapeXml="false"/>
	</c:if>

</c:otherwise>
</c:choose>
<script type="text/javascript">
    highlightTableRows("list");
</script>