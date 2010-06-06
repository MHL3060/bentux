<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>


<script type="text/javascript">

	var bannerImg = new Array();
	// Enter the names of the images below
	bannerImg[0]="<c:url value='/images/store_photo/DSCN0211.JPG' />";
	
	var newBanner = 0;
	var totalBan = bannerImg.length;
	
	function cycleBan() {
		newBanner++;
		if (newBanner == totalBan) {
			newBanner = 0;
		}
		document.banner.src=bannerImg[newBanner];
		// set the time below for length of image display
		// i.e., "4*1000" is 4 seconds
		setTimeout("cycleBan()", 4*600);
	}
	//window.onload=cycleBan;

</script>

<div id="top">
		<span class="left">
			<fmt:message key="company.url"/>	    
		</span>
	<span class="right">
		<a href="userform.jsp">My ACCOUNT</a>&nbsp;|&nbsp;<a href="login.jsp">LOGIN</a>&nbsp;|&nbsp;<a href="signup.html">REGISTER</a>&nbsp;|&nbsp;<a href="disclaimer.jsp">DISCLAIMER</a>&nbsp;|&nbsp;<a href="subscriptionform.html">SUBSCRIBE</a>
	</span>
</div>

<div id="branding">

    <img src="<c:url value="/images/common/header_logo.jpg"/>" width="190" height="110"  hspace="0" vspace="0" align="left" />
   	<img src="<c:url value="/images/common/header_banner_1.jpg"/>" width="760" float="left" height="110" name="banner"  hspace="0" vspace="0" align="left"/>
       
</div>

<div id="news">
    Welcome, 
	<c:choose>
				<c:when test="${pageContext.request.remoteUser == null}">
					Please&nbsp;(<a href="<c:url value="/login.jsp"/>">sign in</a> ) or not yet a member? (<a href="<c:url value="/signup.html"/>">register</a>) 	       		
				</c:when>
				<c:otherwise>	
					 <fmt:message key="user.status"/> ${pageContext.request.remoteUser} &nbsp;&nbsp;<a href="<c:url value="/logout.jsp"/>">sign out</a>
			    </c:otherwise>
			</c:choose>
</div>
<div id="divider">

</div>
<hr />
<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>