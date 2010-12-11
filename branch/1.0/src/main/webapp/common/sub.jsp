<%@ include file="/common/taglibs.jsp" %>

    <div id="sub2">
            <div class="title">
				 <fmt:message key="sub.title"/>
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
				    <img src="<c:url value="http://lh4.ggpht.com/_WwislJULCHw/TM02M1NDlSI/AAAAAAAAB5s/P0QNbi0YMy4/home_sub_mtr.png"/>" width="140"
								height="75" alt="partners"/></a>
					<div class="subtitle">
						<fmt:message key="sub.by.mtr"/>						
					</div>
			</div>
		
		
			<div class="partners">
					<a href="<c:url value="/our_store_bus.jsp"/>">						
				    <img src="<c:url value="http://lh3.ggpht.com/_WwislJULCHw/TM02MyReK7I/AAAAAAAAB5o/4pNTnUXV-TM/home_sub_bus.jpg"/>" width="140"
								height="75" alt="partners"/></a>
					<div class="subtitle">
						<fmt:message key="sub.by.bus"/>						
					</div>
	       	 </div> 					
			
			 <div class="partners">
			 		<a href="<c:url value="/our_store_taxi.jsp"/>">					
			 		<img src="<c:url value="http://lh5.ggpht.com/_WwislJULCHw/TM1ERBjjJoI/AAAAAAAAB58/AxiU1Fp4wTg/home_sub_road.png"/>" width="140"
							height="75" alt="partners"/></a>
					<div class="subtitle">
						<fmt:message key="sub.by.taxi"/>						
					</div>
               </div> 	
			
			
			<div class="partners">
					
					<div class="cart">
						shopping cart
					</div>
					<div class="cart-middle">
					<ul>
						<li>Item(s): ${cart_item_count}</li>
						<li>Total: ${cart_sub_total}</li>
					</div>
					<div class="cart-bottom">
                                        </div>


				<%--	
					<div class="cart-top">

								<a href="<c:url value="/cart.html"/>">Shopping cart</a>
					</div>
					<div class="cart-middle">	
						<div class="left">Items</div>							
						<div class="right">${cart_item_count}</div>
								
						<div class="left">Total</div>
						<div class="right">$ ${cart_sub_total}</div>
					</div>
					<div class="cart-bottom">
						<a href="<c:url value="/addressform.html"/>">Checkout</a>
					</div>
				--%>
						
			</div>
</div>
