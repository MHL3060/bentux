<%@ include file="/common/taglibs.jsp"%>
<P>
<H2>Product Search:</H2>

<FORM method="GET"><spring:bind path="command.query">
	<INPUT type="text" size="20" name="query"
		value="<c:out value="${status.value}"/>" />
</spring:bind> <INPUT type="submit" value="Search" /></FORM>

<c:if test="${! empty searchResults}">

	<c:forEach var="searchResultBean" items="${list}">
		<div class="result">
			<div class="title">
				<a href="<c:url value="/productdetail.html?id=${searchResultBean.id}" />" > ${searchResultBean.name}</a>	
			</div>
			<div class="content">
				${searchResultBean.resource }
			</div>
			<div class="url">
				<c:url var="url" value="${searchResultBean.objectName}">
				</c:url>
			</div>
				
		</div>
	</c:forEach>

<P><BR>
Search took <c:out value="${searchResults.searchTime}" />ms

</c:if>
  