<%@ include file="/common/taglibs.jsp" %>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/newsform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="tuxBaseObjectList" cellspacing="0" cellpadding="0" requestURI=""
    id="tuxBaseObjectList" pagesize="25" class="table tuxBaseObjectList" export="true">

    <display:column property="id" escapeXml="true" sortable="true"
        url="/newsform.html" paramId="id" paramProperty="id" titleKey="news.id"/>
    <display:column property="title" escapeXml="true" sortable="true" titleKey="news.title"/>
    <display:column property="addedOn" escapeXml="true" sortable="true" titleKey="news.added.on"/>
	<display:column property="user.username" escapeXml="true" sortable="true" titleKey="news.user" />
    <display:setProperty name="paging.banner.item_name" value="news"/>
    <display:setProperty name="paging.banner.items_name" value="news"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("list");
</script>