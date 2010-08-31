<%@ include file="/common/taglibs.jsp" %>
<div id="main">

	<div id= "title">
		<fmt:message key="our.store.mtr" />
	</div>
	<head>
	<meta name="menu" content="Our Store by MTR" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
	</head>
	   
	   	<div id="our-store">
	   		<fmt:message key="our.store.mtr.description" />
		   	<div class="help">	
	   			<fmt:message key="our.store.help" />
	   		</div>
			
			<div class="content-divide">
			
			</div>
			
			<div class="info">
					<div class="left">
						<h4><fmt:message key="our.store.contact" /></h4>
						
						<fmt:message key="our.store.contact.address" />
						<div class="bottom">
							<h6><fmt:message key="our.store.contact.tel" /></h6>
							<h6><fmt:message key="our.store.contact.fax" /></h6>
							<h6><fmt:message key="our.store.contact.email" /></h6>
						</div>
					</div>
					<div class="right">
						<h4><fmt:message key="our.store.google.map" /></h4>
						<div class="divide">
						</div>
						<div class="bottom">
							<a href="http://maps.google.com/maps?f=d&amp;source=embed&amp;saddr=22.31218,114.226425&amp;daddr=Sunbeam+Centre,+27+Shing+Yip+St,+Kwun+Tong,+Hong+Kong&amp;geocode=%3BFZprVAEd1vjOBilJm7O1WgEENDGOsvCWKyeT4w&amp;hl=en&amp;mra=ls&amp;dirflg=w&amp;doflg=ptm&amp;sll=22.31126,114.22187&amp;sspn=0.009032,0.016512&amp;ie=UTF8&amp;ll=22.310716,114.226313&amp;spn=0.00397,0.004549&amp;z=17" style="color:#0000FF;text-align:left">
							<img src="<c:url value="/images/google_map_logo.png"/>" width="70" height="69" alt="google_map_logo"/>
						</div>
					</div>
			</div>
		
		</div>
		
		<div id="photo">
			<iframe width="320" height="386" 
								frameborder="0" 
								scrolling="no" 
								marginheight="0" 
								marginwidth="0" 
								src="http://maps.google.com/maps?f=d&amp;source=s_d&amp;saddr=22.31218,114.226425&amp;daddr=Sunbeam+Centre,+27+Shing+Yip+St,+Kwun+Tong,+Hong+Kong&amp;geocode=%3BFZprVAEd1vjOBilJm7O1WgEENDGOsvCWKyeT4w&amp;hl=en&amp;mra=ls&amp;dirflg=w&amp;doflg=ptm&amp;sll=22.31126,114.22187&amp;sspn=0.009032,0.016512&amp;ie=UTF8&amp;ll=22.310716,114.226313&amp;spn=0.00397,0.004549&amp;z=17&amp;output=embed">
			</iframe>
		
		</div>
</div>
