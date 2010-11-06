<%@ include file="/common/taglibs.jsp"%>
<c:if test="${!empty cookie.preferredLocale}">
<fmt:setLocale value="${cookie.preferredLocale.value}" />
</c:if>
<%--
<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
--%>
<style>

</style>
<script type="text/javascript" src="<c:url value="/scripts/dojo/dojo.js"/>"></script>
<div id="top">
		<span class="left">
			<a href="home.html"><fmt:message key="company.url"/></a>	    
		</span>
	<span class="right">
		<c:if test="${pageContext.request.remoteUser}">
			<a href="userform.html">MY ACCOUNT</a>&nbsp;|&nbsp;
		</c:if>
		<c:choose>
      		<c:when test="${pageContext.request.remoteUser != null}"><a href="logout.jsp">SIGN OUT</a>
      </c:when>
	      <c:otherwise><a href="login.jsp">LOGIN</a>
      </c:otherwise>
    </c:choose>
		&nbsp;|&nbsp;<a href="signup.html">REGISTER</a>&nbsp;|&nbsp;<a href="disclaimer.jsp">DISCLAIMER</a>&nbsp;|&nbsp;<a href="help.html">HELP</a>
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
   
    	<img src="<c:url value="http://lh4.ggpht.com/_WwislJULCHw/TM02Mj9Y-KI/AAAAAAAAB5g/82nLCVIY8yw/header_logo.png"/>" width="178" />
   		<img src="<c:url value="http://lh6.ggpht.com/_WwislJULCHw/TM02MVvz8DI/AAAAAAAAB5c/EyZdVl54Kj4/header_banner_2.jpg"/>"/>
   
</div>

<div id="news">
	<div class="left">

	    <%-- No order history for Phrase 1, 28/08/2010 
						Hi, Please&nbsp;(<a href="<c:url value="/login.jsp"/>">sign in</a>) or not yet a member? (<a href="<c:url value="/signup.html"/>">register</a>) 	       		
		--%>
				<c:if test="${pageContext.request.remoteUser != null}">
					
					<div class="user">
						 <fmt:message key="user.status"/> ${pageContext.request.remoteUser} 
						 	<%-- No order history for Phrase 1, 28/08/2010 
						 | <a href="<c:url value='/orders.html' />"><fmt:message key="order.history" /></a>
						 | <a href="<c:url value="/logout.jsp"/>">sign out</a>
				    	--%>
					</div>
				</c:if>

	</div>
	<div class="right">
		<c:if test="${pageContext.request.remoteUser != null}">
			
			<%@ include file="/common/shoppingcart.jsp" %>
		</c:if>	
	</div>
</div>
<div id="top-divider"></div>
<hr />
<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>
