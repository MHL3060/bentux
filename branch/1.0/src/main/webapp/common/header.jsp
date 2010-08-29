<%@ include file="/common/taglibs.jsp"%>

<%--
<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
--%>
<div id="top">
		<span class="left">
			<fmt:message key="company.url"/>	    
		</span>
	<span class="right">
		<c:if test="${pageContext.request.remoteUser}">
			<a href="userform.html">MY ACCOUNT</a>&nbsp;|&nbsp;
		</c:if>
		<a href="login.jsp">LOGIN</a>&nbsp;|&nbsp;<a href="signup.html">REGISTER</a>&nbsp;|&nbsp;<a href="disclaimer.jsp">DISCLAIMER</a>&nbsp;|&nbsp;<a href="subscriptionform.html">SUBSCRIBE</a>
	</span>
</div>
<style>
	
	#branding img {
		height: 110px;
		padding: 0px;
		float: left;
	}
</style>

<div id="branding">
   
    	<img src="<c:url value="/images/common/header_logo.png"/>" width="173" />
   		<img src="<c:url value="/images/common/header_banner_2.jpg"/>" />
   
</div>

<div id="news">
	<div class="left">

	    Hi, 
		<c:choose>
					<c:when test="${pageContext.request.remoteUser == null}">
						Please&nbsp;(<a href="<c:url value="/login.jsp"/>">sign in</a>) or not yet a member? (<a href="<c:url value="/signup.html"/>">register</a>) 	       		
					</c:when>
					<c:otherwise>
						 	
						 <fmt:message key="user.status"/> ${pageContext.request.remoteUser} 
						 | <a href="<c:url value='/orders.html' />"><fmt:message key="order.history" /></a>
						 | <a href="<c:url value="/logout.jsp"/>">sign out</a>
				    </c:otherwise>
				</c:choose>

	</div>
	<div class="right">
		<c:if test="${pageContext.request.remoteUser != null}">
			<%@ include file="/common/shoppingcart.jsp" %>
		</c:if>	
	</div>
</div>
<hr />
<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>