<%@ include file="/common/taglibs.jsp" %>

    <div id="divider">
		<span class="center">
			<span class="left">
				<a href="home.html">Home</a>
				|<a href="catalogs.html">Categories</a>
				|<a href="productlist.html">Product</a>
				|<a href="search.html">Search</a>
				|<a href="disclaimer.jsp">Disclaimer</a>
			
			
			<c:choose>
				<c:when test="${pageContext.request.remoteUser == null}">
					|<a href="<c:url value="/login.jsp"/>"><fmt:message key="login.title"/></a>	       		
				</c:when>
				<c:otherwise>	
					 <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
					|<a href="<c:url value="/userForm.html" />"> <fmt:message key="user.profile"/></a>
						 
				 </c:otherwise>
			</c:choose>
			</span>
			<span class="right">
				&copy;<fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
			</span>
	<div></div></div>