<%@ include file="/common/taglibs.jsp" %>
<div id="main">
<div id= "title">
	<fmt:message key="contact.us.title" />
</div>

<head>
<meta name="menu" content="About Us" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
</head>

<div id="contact-us">
	<div class="location">
		<fmt:message key="contact.us.store.location" />
	</div>
	<div class="address">
		<fmt:message key="contact.us.address" />		
	</div>
	<div class="detail">
		<h6><fmt:message key="contact.us.address.tel" /></h6>
		<h6><fmt:message key="contact.us.address.fax" /></h6>
		<h6><fmt:message key="contact.us.address.email" /></h6>		
	</div>

	<div class="feedback">
		<fmt:message key="contact.us.feedback" />
		<div class="description">
			<fmt:message key="contact.us.feedback.description" />
		</div>
		<div class="form">
			<img src="<c:url value="/images/contact_us_form.png"/>" width="607" height="306" alt="contact_us_form"/>
		</div>
	
	</div>



</div>

</div>