<%@ include file="/common/taglibs.jsp" %>
<h1><fmt:message key="contact.us" /></h1>
<head>
<meta name="menu" content="About Us" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
</head>

<c:if test="${user != null }">
	<%@ include file="/common/shoppingcart.jsp" %>
</c:if>

<div id="photo">
	<img src="<c:url value="/images/location.png"/>" width="360" height="400" alt="location">
</div>
<div class="detail">
			<ul>
				<li>Tel: &nbsp;&nbsp;+852 2314 9295</li>
                <li>Fax: &nbsp;&nbsp;+852 2369 0927</li>
				<li>Email: &nbsp;&nbsp;til@biznetvigator.com</li>
			</ul>
			<p></p>
			<div class="picture">
				<a href="<c:url value="http://maps.google.com/maps?f=q&hl=en&q=Unit+1210%2C+12%2FF%2C+Sunbeam+Centre%2C+27+Shing+Yip+Street%2C+%2C+Kwun+Tong%2C+Hong+Kong"/>">
				<img src="<c:url value="/images/google_map.png"/>" width="120" height="42" alt="location"></a>
			</div>	
	
			<ul>
				<li>Address:</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; Unit 1210, 12/F, Sunbeam Centre,</li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp; 27 Shing Yip Street, Kwun Tong,</li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp; Kowloon, Hong Kong </li>
			</ul>
			<p>
			
			</p>			
			<ul>
				<li>Going Trinity by MTR?</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; Our store is located near the Kwun Tong MTR Station.</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; Get down to B1 Exit, walk along and take the 1st left</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; turn to Shing Yip Street. Another 150m walk and take the </li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; lift from the Carpark area to the 12th floor. Turn right</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; and walk to 1210.</li>
			</ul>
</div>


<div style="clear: both;">&nbsp;</div>

