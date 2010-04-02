<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>


<script type="text/javascript">

	var bannerImg = new Array();
	// Enter the names of the images below
	bannerImg[0]="<c:url value='/images/store_photo/DSCN0211.JPG' />";
	bannerImg[1]="<c:url value='/images/store_photo/DSCN0216.JPG' />";
	bannerImg[2]="<c:url value='/images/store_photo/DSCN0219.JPG' />";
	bannerImg[3]="<c:url value='/images/store_photo/DSCN0223.JPG' />";
	bannerImg[4]="<c:url value='/images/store_photo/DSCN0228.JPG' />";
	bannerImg[5]="<c:url value='/images/store_photo/DSCN0229.JPG' />";
	
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
	window.onload=cycleBan;

</script>
<div id="branding">

    <h1><img src="<c:url value="/images/logo_small.png"/>" height="100" style="float: left;"/><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a>
   	<img src="<c:url value="/images/store_photo/DSCN0211.JPG"/>" width="410" height="90" style="float: right;" name="banner">
    </h1>
	<p><fmt:message key="webapp.tagline"/></p>		
	    
    </div>
<hr />
<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>