<%@ include file="/common/taglibs.jsp"%>


<script type="text/javascript">
	function setAccpacInfo(node) {
		if (node.value != "") {
			projectInformationManager.getId(node.value, pInformation);
		} else {
			var contractNode = document.getElementById("contract");
			var projectNode = document.getElementById("project");
			str = "";
			contractNode.innerHTML = str;
			projectNode.innerHTML = str;
		}
	}
	function pInformation(p) {
		var contractNode = document.getElementById("contract");
		str = p.contract.name;
		contractNode.innerHTML = str;
		var projectNode = document.getElementById("project");
		str = p.project.name;
		projectNode.innerHTML = str;
	}
	function confirmSubmit(){
		return confirm("Are you sure you want to submit this week's time?" );
	}

	function addThisWeek(){
		dom = document.getElementById("method");
		value = dom.value;
		location.href ='./worktime.html?method='+value;
	}
</script>
<c:set var="checkAll">
	<input type="checkbox" name="allbox" onclick="checkAll(this.form)"
		style="margin: 0 0 0 4px" />
</c:set>
<ul>
	
		<div
			style="outline-color: #d7e9f5; outline-style: solid; outline-width: 1px;">
		</div>
		
			<form:form commandName="shoppingItem" action="cart.html" id="shoppingItem">
			<form:errors path="*" cssClass="error" element="div" />
			<li>
          
		  		<input type="submit" name="method" value="Edit" class="button" 
			
				<c:if test="${not empty method and method == 'Add' }">
					disabled="disabled"
				</c:if>
				/> 
			
	          <input type="submit" name="method" value="Add" class="button"
	        	  <c:if test="${not empty method and method == 'Edit' }">
					disabled="disabled"
				  </c:if>
	          /> 
	          <input type="submit" name="method" value="Delete" class="button" 
				<c:if test="${not empty method and not ( method == 'Save' or method == 'Delete')}">
						disabled="disabled"
				</c:if>	
				
				/>
			<input type="reset" name="method" value="Cancel" class="button" onclick="location.href='./worktime.html'" />
        </li>
			
			<display:table name="${shoppingItems}" id="items" class="list">
  			<display:column style="width: 5%" title="${checkAll}">
    			<input type="checkbox" name="id" value="<c:out value="${test.id}"/>" 
    				<c:if test="${param.id == test.id and param.method != 'Save'}">checked="checked"</c:if>
        			style="margin: 0 0 0 4px" onclick="radio(this)" />
  			</display:column>
  			<display:column titleKey="cart.item.product" property="items.product.name" />
 			<display:column titleKey="cart.time.quantity">
 				<c:choose>
 					<c:when test="${method != null}">
 						<form:input path="quantity" />
 					</c:when>
 					<c:otherwise>
 						${items.quantity }
 					</c:otherwise>
 				</c:choose>
 			</display:column>
  			<display:column title="product.price" property="product.price" />
			</display:table>
			<c:if test="${not week.submitted}">
				<input type="submit" name="method" value="Save"
					onclick="location.href='?method=Submit'" />
				<input type="submit" name="method" value="Submit" style="font-weight:bold; background-color: #CC6666;" 
					onclick="return confirmSubmit()" />
			</c:if>
			</form:form>
</ul>
<div
	style="outline-color: #d7e9f5; outline-style: solid; outline-width: 1px;">
</div>
<br />
<form:form commandName="timeWebBean" action="worktime.html"
	id="timeWebBeanForm">
	<c:if test="${submitted}">
		<input type="submit" name="method" value="Add New Week"
			onclick="location.href='?method=Submit'" />
	</c:if>
</form:form>


