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
	<iframe width="400" height="400" 
						frameborder="0" 
						scrolling="no" 
						marginheight="0" 
						marginwidth="0" 
						src="http://maps.google.com/maps?f=d&amp;source=s_d&amp;saddr=22.31218,114.226425&amp;daddr=Sunbeam+Centre,+27+Shing+Yip+St,+Kwun+Tong,+Hong+Kong&amp;geocode=%3BFZprVAEd1vjOBilJm7O1WgEENDGOsvCWKyeT4w&amp;hl=en&amp;mra=ls&amp;dirflg=w&amp;doflg=ptm&amp;sll=22.31126,114.22187&amp;sspn=0.009032,0.016512&amp;ie=UTF8&amp;ll=22.310716,114.226313&amp;spn=0.00397,0.004549&amp;z=17&amp;output=embed">
	</iframe>
	<br />
	<small>
		<a href="http://maps.google.com/maps?f=d&amp;source=embed&amp;saddr=22.31218,114.226425&amp;daddr=Sunbeam+Centre,+27+Shing+Yip+St,+Kwun+Tong,+Hong+Kong&amp;geocode=%3BFZprVAEd1vjOBilJm7O1WgEENDGOsvCWKyeT4w&amp;hl=en&amp;mra=ls&amp;dirflg=w&amp;doflg=ptm&amp;sll=22.31126,114.22187&amp;sspn=0.009032,0.016512&amp;ie=UTF8&amp;ll=22.310716,114.226313&amp;spn=0.00397,0.004549&amp;z=17" style="color:#0000FF;text-align:left">
			View Larger Map
		</a>
	</small>
</div>
<div class="detail">
			<ul>
				<li>Tel: &nbsp;&nbsp;+852 2314 9295</li>
                <li>Fax: &nbsp;&nbsp;+852 2369 0927</li>
				<li>Email: &nbsp;&nbsp;til@biznetvigator.com</li>
			</ul>
			<p></p>
				
				
			<!--
						<div class="picture">
				<a href="<c:url value="http://maps.google.com/maps?f=q&hl=en&q=Unit+1210%2C+12%2FF%2C+Sunbeam+Centre%2C+27+Shing+Yip+Street%2C+%2C+Kwun+Tong%2C+Hong+Kong"/>">
				<img src="<c:url value="/images/google_map.png"/>" width="120" height="42" alt="location"></a>
			</div>	
			-->
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
				<li>&nbsp;&nbsp;&nbsp;&nbsp; Our store is located near the Kwun Tong</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; MTR Station. Get down to B1 Exit, walk </li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; along and take the 1st left turn to Shing</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; Yip Street. Another 150m walk and take the </li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp; lift from the Carpark area to the 12th floor.</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;  Turn right and walk to suite #1210.</li>
			</ul>
</div>


<div style="clear: both;">&nbsp;</div>

