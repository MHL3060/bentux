<%@ include file="/common/taglibs.jsp"%>


<script type="text/javascript">
	function confirmSubmit(){
		return true;
	}
</script>
<ul>
	
		<div
			style="outline-color: #d7e9f5; outline-style: solid; outline-width: 1px;">
		</div>
		
			<form:form commandName="shoppingItem" action="cart.html" id="shoppingItem">
			<form:hidden path="shoppingCart" />
			<form:errors path="*" cssClass="error" element="div" />
			<li>
          
		  		<input type="submit" name="edit" value="Edit" class="button" ${action != null ? 'disabled="disabled"' : '' } />
	          <input type="submit" name="delete" value="Delete" class="button" ${action != null ? 'disabled="disabled"' : '' } />
        </li>
			
			<display:table name="${shoppingItems}" id="items" class="table">
  			<display:column style="width: 5%" title="${checkAll}">
    			<input type="radio" name="id"
									value="${items.id}" ${(param.id == items.id && param.edit != null) ? 'checked=checked' : ''}/>

        			
  			</display:column>
  			<display:column titleKey="cart.item.product" >
  				<c:if test="${action != null}">
  					<form:hidden path="product" />
  				
  				</c:if>
  				${items.product.name }
  			</display:column>
 			<display:column titleKey="cart.item.quantity">
 				<c:choose>
 					<c:when test="${action != null}">
 						<form:input path="quantity" />
 					</c:when>
 					<c:otherwise>
 						${items.quantity }
 					</c:otherwise>
 				</c:choose>
 			</display:column>
  			<display:column title="product.price" property="product.price" />
  			<display:column title="shopping.item.total" property="total" total="true"/>
			</display:table>
			
			
			
			
			<c:set var="i" value="${0}"/> 
			<c:forEach var="c" items="${shoppingItems}">
			 	<c:set var="i" value="${i+c.total}"/>
			</c:forEach>
			<li class="label"><fmt:message key="cart.sub.total" /> : $ ${i}</li>
				
			
			<input type="submit" name="save" value="<fmt:message key="save" />"
				onclick="location.href='?method=Submit'" />
			<input type="submit" name="checkout" value="Check Out" style="font-weight:bold; background-color: #CC6666;" 
				onclick="return confirmSubmit()" />
			
			</form:form>
</ul>
<div
	style="outline-color: #d7e9f5; outline-style: solid; outline-width: 1px;">
</div>
<br />


