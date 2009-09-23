<%@ include file="/common/taglibs.jsp" %>

    <div id="divider"><div></div></div>
    <span class="left"><fmt:message key="webapp.version"/> |
        <span id="validators">
            <a href="#">Disclaimer</a> 
            <a href="#"></a>
        </span>
        <c:choose>
	        <c:when test="${pageContext.request.remoteUser != null}">
	       		 | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
	       		 | <a href="<c:url value="/userForm.html" />"> <fmt:message key="user.profile"/></a>
	       	</c:when>
	       	<c:otherwise>
	       		 | <a href="<c:url value="/login.jsp"/>"><fmt:message key="login.title"/></a>
	       	</c:otherwise>
       	</c:choose>
       
    </span>
    <span class="right">
        &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
    </span>
