<%@ include file="/common/taglibs.jsp" %>

    <div id="sub">
            <div class="title">
				 <fmt:message key="current.page.home"/>
            </div>
			<%--
			<ul class="left">
			<c:forEach var="sideBanner" items="${sideBanners }">
				<li>
					<div class="banner">
						<img src="<c:url value="${sideBanner.thumbPath}"/>" width="130"
									height="80" alt="${sideBanner.name}"></img>
						<a href="<c:url value="${sideBanner.url }" />">${sideBanner.name}</a>
					</div>
				</li>
	         </c:forEach>		
	         
	         --%>			
		     <%-- The following are for the static sidebar for phrase 3 will use a dynamic sidebar until the next phraes 7/8/2010 --%>
			<div class="partners">
					<a href="<c:url value="/our_store.jsp"/>">						
				    <img src="<c:url value="/images/home_sub_mtr.png"/>" width="140"
								height="75" alt="partners"></img></a>
					<div class="subtitle">
						<fmt:message key="sub.by.mtr"/>						
					</div>
			</div>
		
		
			<div class="partners">
					<a href="<c:url value="/our_store_bus.jsp"/>">						
				    <img src="<c:url value="/images/home_sub_bus.png"/>" width="140"
								height="75" alt="partners"></img></a>
					<div class="subtitle">
						<fmt:message key="sub.by.bus"/>						
					</div>
	       	 </div> 					
			
			 <div class="partners">
			 		<a href="<c:url value="/our_store_taxi.jsp"/>">					
			 		<img src="<c:url value="/images/home_sub_road.png"/>" width="140"
							height="75" alt="partners"></img></a>
					<div class="subtitle">
						<fmt:message key="sub.by.taxi"/>						
					</div>
               </div> 	
			
			<div class="partners">
					<c:if test="${user != null }">		
						<div class="cart">
								
						</div>
					</c:if>
			</div>
	</div>	