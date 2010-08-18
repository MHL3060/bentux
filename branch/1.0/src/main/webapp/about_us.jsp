<%@ include file="/common/taglibs.jsp"%>

<head>
<meta name="menu" content="About Us" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
</head>

<div id="main">
<img src="<c:url value="/images/about_us.png"/>" width="606" height="226" alt="about us" ></img>			

<div id="about-us">
	<h1><fmt:message key="company.name"/></h1>
	
	<p><h5><fmt:message key="about.us.content"/></h5></p>
	
	<p><h5><fmt:message key="about.us.content2"/></h5></p>
	
	</div>
</div>
