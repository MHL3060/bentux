<%@ include file="/common/taglibs.jsp" %>

    <div id="sub">
            <div class="title">
				 <fmt:message key="current.page.home"/>
            </div>
			
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
		     </ul>
			
		</div>
		