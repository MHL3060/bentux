<%@ include file="/common/taglibs.jsp"%>
<P>
<H2>Compass Search:</H2>

<FORM method="GET"><spring:bind path="command.query">
	<INPUT type="text" size="20" name="query"
		value="<c:out value="${status.value}"/>" />
</spring:bind> <INPUT type="submit" value="Search" /></FORM>

<c:if test="${! empty searchResults}">

  Search took <c:out value="${searchResults.searchTime}" />ms


	<c:forEach var="searchResultBean" items="${searchResults}">
		<div name="title">
			<c:url var="url" value="${searchResultBean.objectName}">
			
			</c:url>
			${searchResultBean }</div>
		<div name="contentBody">${searchResultBean.resource }</div>
	</c:forEach>

	
		</c:if>

		<P><BR>