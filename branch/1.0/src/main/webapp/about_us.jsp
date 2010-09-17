<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="About Us" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
</head>

<div id="main">
	<div id="about-us">
		<img src="<c:url value="/images/about_us.jpg"/>" width="601" height="224" alt="about us" />			
		
		<div class="detail">

			<h1><fmt:message key="company.name"/></h1>
			
			<p><h5><fmt:message key="about.us.content"/></h5></p>
			
			<p><h5><fmt:message key="about.us.content2"/></h5></p>
		</div>		
	</div>
</div>