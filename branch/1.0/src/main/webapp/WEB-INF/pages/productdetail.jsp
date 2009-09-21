<%@ include file="/common/taglibs.jsp" %>

<c:choose>
	<c:when test="${not empty product }">
		<table>
			<tr>
				<td><font class="desc"><fmt:message key="product.name" /></font></td>
				<td><font class="value">${product.name }</font></td>
			</tr>
			<tr>
				<td>more fields will be listed below</td>
			</tr>
			
				
			
		</table>
	
	</c:when>
	<c:otherwise>
		<fmt:message key="product.not.found" />
	</c:otherwise>
</c:choose>